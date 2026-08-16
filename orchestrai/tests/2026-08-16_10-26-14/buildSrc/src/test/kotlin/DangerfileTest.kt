package config

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File

/**
 * Tests for `Dangerfile.df.kts`.
 *
 * Because Danger Kotlin scripts execute inside the Danger plugin sandbox and rely on
 * GitHub PR/Issue context objects that are not trivially constructible in a unit test,
 * these tests cover the script in two complementary ways:
 *
 * 1. Structural/content assertions on the actual script source to guarantee every
 *    branch documented in the file is present and unmodified.
 * 2. Behavioral replication tests that exercise the exact algorithms used inside the
 *    script (header search / sublist joining, threshold checks, blank checks) with
 *    boundary and edge case coverage.
 */
class DangerfileTest {

    private fun findFileUpwards(fileName: String): File {
        var dir = File(System.getProperty("user.dir"))
        var attempts = 0
        while (attempts < 6) {
            val candidate = File(dir, fileName)
            if (candidate.exists()) return candidate
            dir = dir.parentFile ?: break
            attempts++
        }
        throw IllegalStateException("Could not locate $fileName starting from ${System.getProperty("user.dir")}")
    }

    private val dangerfileContent: String by lazy {
        findFileUpwards("Dangerfile.df.kts").readText()
    }

    @Test
    @DisplayName("should exist and be non-blank")
    fun `dangerfile should exist and be non blank`() {
        val file = findFileUpwards("Dangerfile.df.kts")
        assertTrue(file.exists())
        assertTrue(file.readText().isNotBlank())
    }

    @Test
    @DisplayName("should contain the danger(args) onGitHub block")
    fun `should contain danger onGitHub block`() {
        assertTrue(dangerfileContent.contains("danger(args)"))
        assertTrue(dangerfileContent.contains("onGitHub {"))
    }

    @Test
    @DisplayName("should thank the PR author")
    fun `should thank pr author`() {
        assertTrue(dangerfileContent.contains("Thanks @\${pullRequest.user.login}!"))
    }

    @Test
    @DisplayName("should fail when body is blank")
    fun `should contain body blank fail branch`() {
        assertTrue(dangerfileContent.contains("pullRequest.body.isNullOrBlank()"))
        assertTrue(dangerfileContent.contains("Please provide a summary in the Pull Request description."))
    }

    @Test
    @DisplayName("should warn on large additions")
    fun `should contain large pr warn branch`() {
        assertTrue(dangerfileContent.contains("additions > 500"))
        assertTrue(dangerfileContent.contains("Please consider breaking up this pull request."))
    }

    @Test
    @DisplayName("should warn on missing labels")
    fun `should contain missing labels warn branch`() {
        assertTrue(dangerfileContent.contains("issue.labels.isEmpty()"))
        assertTrue(dangerfileContent.contains("Please add labels to this PR."))
    }

    @Test
    @DisplayName("should message on cleanup")
    fun `should contain cleanup message branch`() {
        assertTrue(dangerfileContent.contains("deletions > additions"))
        assertTrue(dangerfileContent.contains("🎉 Code Cleanup!"))
    }

    @Test
    @DisplayName("should read dependency updates report")
    fun `should reference dependency updates report file`() {
        assertTrue(dangerfileContent.contains("build/dependencyUpdates/report.txt"))
        assertTrue(dangerfileContent.contains("The following dependencies have later milestone versions:"))
        assertTrue(dangerfileContent.contains("headerIndex"))
    }

    @Nested
    @DisplayName("Logic replication: dependency update header search")
    inner class HeaderSearchLogic {

        private fun findDependencyUpdatesMessage(lines: List<String>): String? {
            val headerIndex = lines.indexOfFirst { line ->
                line.contains("The following dependencies have later milestone versions:")
            }
            return if (headerIndex >= 0) {
                lines.subList(headerIndex, lines.size).joinToString("\n")
            } else {
                null
            }
        }

        @Test
        @DisplayName("should return null for empty lines")
        fun `should return null for empty lines`() {
            val result = findDependencyUpdatesMessage(emptyList())
            assertNull(result)
        }

        @Test
        @DisplayName("should return null when header is absent")
        fun `should return null when header absent`() {
            val lines = listOf("Some unrelated line", "Another line", "No header here")
            val result = findDependencyUpdatesMessage(lines)
            assertNull(result)
        }

        @Test
        @DisplayName("should return full joined text when header is at index 0")
        fun `should return joined text when header at start`() {
            val lines = listOf(
                "The following dependencies have later milestone versions:",
                " - com.example:lib [1.0.0 -> 2.0.0]",
                " - com.example:other [3.0.0 -> 3.1.0]"
            )
            val result = findDependencyUpdatesMessage(lines)
            assertNotNull(result)
            assertEquals(lines.joinToString("\n"), result)
        }

        @Test
        @DisplayName("should return sublist joined text when header is in the middle")
        fun `should return sublist when header in middle`() {
            val lines = listOf(
                "Some report preamble",
                "Nothing to see here",
                "The following dependencies have later milestone versions:",
                " - com.example:lib [1.0.0 -> 2.0.0]"
            )
            val result = findDependencyUpdatesMessage(lines)
            val expected = lines.subList(2, lines.size).joinToString("\n")
            assertEquals(expected, result)
        }

        @Test
        @DisplayName("should return single line when header is the last line")
        fun `should return single line when header is last`() {
            val lines = listOf(
                "Preamble line 1",
                "Preamble line 2",
                "The following dependencies have later milestone versions:"
            )
            val result = findDependencyUpdatesMessage(lines)
            assertEquals("The following dependencies have later milestone versions:", result)
        }

        @Test
        @DisplayName("should read lines from a real temp report file and locate header")
        fun `should read from temp file and find header`(@TempDir tempDir: File) {
            val reportFile = File(tempDir, "report.txt")
            reportFile.writeText(
                """
                Some header info
                The following dependencies have later milestone versions:
                 - com.example:lib [1.0.0 -> 2.0.0]
                """.trimIndent()
            )
            val lines = reportFile.readLines()
            val result = findDependencyUpdatesMessage(lines)
            assertNotNull(result)
            assertTrue(result!!.contains("com.example:lib"))
        }

        @Test
        @DisplayName("should return null when reading an empty temp report file")
        fun `should return null for empty temp file`(@TempDir tempDir: File) {
            val reportFile = File(tempDir, "report.txt")
            reportFile.writeText("")
            val lines = reportFile.readLines()
            val result = findDependencyUpdatesMessage(lines)
            assertNull(result)
        }
    }

    @Nested
    @DisplayName("Logic replication: PR size / cleanup / label thresholds")
    inner class ThresholdLogic {

        private fun shouldWarnLargePr(additions: Int): Boolean = additions > 500

        private fun isCleanupPr(deletions: Int, additions: Int): Boolean = deletions > additions

        private f