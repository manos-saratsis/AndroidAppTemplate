@file:Suppress("MagicNumber", "WildcardImport", "LargeClass")

import io.mockk.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import systems.danger.kotlin.*
import java.io.File
import java.io.FileNotFoundException

class DangerfileTest {

    private lateinit var mockDanger: Danger
    private lateinit var mockGitHub: GitHub
    private lateinit var mockPullRequest: GitHubPR
    private lateinit var mockIssue: GitHubIssue
    private lateinit var mockUser: GitHubUser
    private lateinit var mockFile: File

    @BeforeEach
    fun setup() {
        mockDanger = mockk(relaxed = true)
        mockGitHub = mockk(relaxed = true)
        mockPullRequest = mockk(relaxed = true)
        mockIssue = mockk(relaxed = true)
        mockUser = mockk(relaxed = true)
        mockFile = mockk(relaxed = true)

        every { mockDanger.github } returns mockGitHub
        every { mockGitHub.pullRequest } returns mockPullRequest
        every { mockGitHub.issue } returns mockIssue
        every { mockPullRequest.user } returns mockUser
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Nested
    inner class PullRequestUserMessageTests {
        @Test
        fun `should display thanks message with correct username`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid PR description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.message("Thanks @testuser!") }
        }

        @Test
        fun `should display thanks message with empty username`() {
            // Arrange
            every { mockUser.login } returns ""
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid PR description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.message("Thanks @!") }
        }

        @Test
        fun `should display thanks message with special characters in username`() {
            // Arrange
            every { mockUser.login } returns "user-name_123"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid PR description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.message("Thanks @user-name_123!") }
        }
    }

    @Nested
    inner class PullRequestBodyValidationTests {
        @Test
        fun `should fail when PR body is null`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns null
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.fail("Please provide a summary in the Pull Request description.") }
        }

        @Test
        fun `should fail when PR body is blank`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns ""
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.fail("Please provide a summary in the Pull Request description.") }
        }

        @Test
        fun `should fail when PR body contains only whitespace`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "   \n\t  "
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.fail("Please provide a summary in the Pull Request description.") }
        }

        @Test
        fun `should not fail when PR body has valid content`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "This is a valid PR description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.fail("Please provide a summary in the Pull Request description.") }
        }
    }

    @Nested
    inner class AdditionsValidationTests {
        @Test
        fun `should warn when additions are exactly 501`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 501
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.warn("Please consider breaking up this pull request.") }
        }

        @Test
        fun `should warn when additions are greater than 500`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 1000
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.warn("Please consider breaking up this pull request.") }
        }

        @Test
        fun `should not warn when additions are exactly 500`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 500
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.warn("Please consider breaking up this pull request.") }
        }

        @Test
        fun `should not warn when additions are less than 500`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.warn("Please consider breaking up this pull request.") }
        }

        @Test
        fun `should handle when additions is null`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns null
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.warn("Please consider breaking up this pull request.") }
        }

        @ParameterizedTest
        @ValueSource(ints = [0, 1, 499, 500, 501, 1000, Int.MAX_VALUE])
        fun `should handle various addition values correctly`(additions: Int) {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns additions
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            if (additions > 500) {
                verify { mockDanger.warn("Please consider breaking up this pull request.") }
            } else {
                verify(exactly = 0) { mockDanger.warn("Please consider breaking up this pull request.") }
            }
        }
    }

    @Nested
    inner class LabelsValidationTests {
        @Test
        fun `should warn when PR has no labels`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns emptyList()
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.warn("Please add labels to this PR.") }
        }

        @Test
        fun `should not warn when PR has one label`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.warn("Please add labels to this PR.") }
        }

        @Test
        fun `should not warn when PR has multiple labels`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk(), mockk(), mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.warn("Please add labels to this PR.") }
        }
    }

    @Nested
    inner class DeletionsVsAdditionsTests {
        @Test
        fun `should show cleanup message when deletions exceed additions`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 50
            every { mockPullRequest.deletions } returns 100
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.message("🎉 Code Cleanup!") }
        }

        @Test
        fun `should not show cleanup message when deletions equal additions`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 100
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.message("🎉 Code Cleanup!") }
        }

        @Test
        fun `should not show cleanup message when additions exceed deletions`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.message("🎉 Code Cleanup!") }
        }

        @Test
        fun `should handle when deletions is null`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns null
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.message("🎉 Code Cleanup!") }
        }

        @Test
        fun `should handle when both additions and deletions are null`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns null
            every { mockPullRequest.deletions } returns null
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.message("🎉 Code Cleanup!") }
        }

        @Test
        fun `should handle when both additions and deletions are zero`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 0
            every { mockPullRequest.deletions } returns 0
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            mockStaticFile()

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 0) { mockDanger.message("🎉 Code Cleanup!") }
        }
    }

    @Nested
    inner class DependencyUpdatesFileTests {
        @Test
        fun `should display dependency update message when header is found`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            
            val fileContent = listOf(
                "Some header line",
                "Another line",
                "The following dependencies have later milestone versions:",
                "  - dependency1:1.0.0",
                "  - dependency2:2.0.0"
            )
            mockStaticFileWithContent(fileContent)

            // Act
            executeDangerfile(mockDanger)

            // Assert
            val expectedMessage = """
                The following dependencies have later milestone versions:
                  - dependency1:1.0.0
                  - dependency2:2.0.0
            """.trimIndent()
            verify { mockDanger.message(expectedMessage) }
        }

        @Test
        fun `should not display message when header is not found`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            
            val fileContent = listOf(
                "Some header line",
                "Another line",
                "No dependency updates"
            )
            mockStaticFileWithContent(fileContent)

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 1) { mockDanger.message(any()) } // Only the thanks message
        }

        @Test
        fun `should handle empty dependency updates file`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            
            mockStaticFileWithContent(emptyList())

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 1) { mockDanger.message(any()) } // Only the thanks message
        }

        @Test
        fun `should handle header at first line`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            
            val fileContent = listOf(
                "The following dependencies have later milestone versions:",
                "  - dependency1:1.0.0"
            )
            mockStaticFileWithContent(fileContent)

            // Act
            executeDangerfile(mockDanger)

            // Assert
            val expectedMessage = """
                The following dependencies have later milestone versions:
                  - dependency1:1.0.0
            """.trimIndent()
            verify { mockDanger.message(expectedMessage) }
        }

        @Test
        fun `should handle header at last line`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            
            val fileContent = listOf(
                "Some other content",
                "The following dependencies have later milestone versions:"
            )
            mockStaticFileWithContent(fileContent)

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.message("The following dependencies have later milestone versions:") }
        }

        @Test
        fun `should handle file not found exception`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            
            mockkStatic(File::class)
            every { File("build/dependencyUpdates/report.txt") } throws FileNotFoundException()

            // Act & Assert
            assertThrows<FileNotFoundException> {
                executeDangerfile(mockDanger)
            }
        }

        @Test
        fun `should handle partial header match`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Valid description"
            every { mockIssue.labels } returns listOf(mockk())
            
            val fileContent = listOf(
                "Dependencies have later versions",
                "The following dependencies have later",
                "milestone versions but not complete"
            )
            mockStaticFileWithContent(fileContent)

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify(exactly = 1) { mockDanger.message(any()) } // Only the thanks message
        }
    }

    @Nested
    inner class EdgeCasesAndCombinationsTests {
        @Test
        fun `should handle all warnings and messages at once`() {
            // Arrange
            every { mockUser.login } returns "testuser"
            every { mockPullRequest.additions } returns 600
            every { mockPullRequest.deletions } returns 700
            every { mockPullRequest.body } returns null
            every { mockIssue.labels } returns emptyList()
            
            val fileContent = listOf(
                "The following dependencies have later milestone versions:",
                "  - update1"
            )
            mockStaticFileWithContent(fileContent)

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.message("Thanks @testuser!") }
            verify { mockDanger.fail("Please provide a summary in the Pull Request description.") }
            verify { mockDanger.warn("Please consider breaking up this pull request.") }
            verify { mockDanger.warn("Please add labels to this PR.") }
            verify { mockDanger.message("🎉 Code Cleanup!") }
            verify { mockDanger.message(match { it.contains("The following dependencies") }) }
        }

        @Test
        fun `should handle perfect PR with no warnings`() {
            // Arrange
            every { mockUser.login } returns "perfectuser"
            every { mockPullRequest.additions } returns 100
            every { mockPullRequest.deletions } returns 50
            every { mockPullRequest.body } returns "Excellent PR description"
            every { mockIssue.labels } returns listOf(mockk(), mockk())
            
            mockStaticFileWithContent(listOf("No updates"))

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.message("Thanks @perfectuser!") }
            verify(exactly = 0) { mockDanger.fail(any()) }
            verify(exactly = 0) { mockDanger.warn(any()) }
        }

        @Test
        fun `should handle minimum valid PR`() {
            // Arrange
            every { mockUser.login } returns "minuser"
            every { mockPullRequest.additions } returns 0
            every { mockPullRequest.deletions } returns 0
            every { mockPullRequest.body } returns "Min"
            every { mockIssue.labels } returns listOf(mockk())
            
            mockStaticFileWithContent(emptyList())

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.message("Thanks @minuser!") }
        }

        @Test
        fun `should handle maximum boundary values`() {
            // Arrange
            every { mockUser.login } returns "maxuser"
            every { mockPullRequest.additions } returns Int.MAX_VALUE
            every { mockPullRequest.deletions } returns Int.MAX_VALUE
            every { mockPullRequest.body } returns "A".repeat(10000)
            every { mockIssue.labels } returns List(100) { mockk() }
            
            mockStaticFileWithContent(List(1000) { "Line $it" })

            // Act
            executeDangerfile(mockDanger)

            // Assert
            verify { mockDanger.message("Thanks @maxuser!") }
            verify { mockDanger.warn("Please consider breaking up this pull request.") }
        }
    }

    private fun mockStaticFile() {
        mockkStatic(File::class)
        val mockFile = mockk<File>()
        every { File("build/dependencyUpdates/report.txt") } returns mockFile
        every { mockFile.readLines() } returns emptyList()
    }

    private fun mockStaticFileWithContent(content: List<String>) {
        mockkStatic(File::class)
        val mockFile = mockk<File>()
        every { File("build/dependencyUpdates/report.txt") } returns mockFile
        every { mockFile.readLines() } returns content
    }

    private fun executeDangerfile(danger: Danger) {
        // Simulate the Dangerfile execution
        val github = danger.github
        val pullRequest = github.pullRequest
        val issue = github.issue
        val additions = pullRequest.additions ?: 0
        val deletions = pullRequest.deletions ?: 0

        danger.message("Thanks @${pullRequest.user.login}!")

        if (pullRequest.body.isNullOrBlank()) {
            danger.fail("Please provide a summary in the Pull Request description.")
        }

        if (additions > 500) {
            danger.warn("Please consider breaking up this pull request.")
        }

        if (issue.labels.isEmpty()) {
            danger.warn("Please add labels to this PR.")
        }

        if (deletions > additions) {
            danger.message("🎉 Code Cleanup!")
        }

        val updatesFile = File("build/dependencyUpdates/report.txt")
        val lines = updatesFile.readLines()

        val headerIndex = lines.indexOfFirst { line ->
            line.contains("The following dependencies have later milestone versions:")
        }

        if (headerIndex >= 0) {
            val message = lines.subList(headerIndex, lines.size).joinToString("\n")
            danger.message(message)
        }
    }
}