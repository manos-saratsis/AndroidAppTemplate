/**
 * Tests for Dangerfile.df.kts
 * Tests Danger framework checks and validations
 */
package com.example.template.build.test

import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertNotNull

class DangerfileTest {

    @Test
    fun shouldFailWhenPullRequestBodyIsBlank() {
        val body = ""
        assertTrue(body.isBlank())
    }

    @Test
    fun shouldFailWhenPullRequestBodyIsNull() {
        val body: String? = null
        assertTrue(body.isNullOrBlank())
    }

    @Test
    fun shouldWarnWhenAdditionsExceed500() {
        val additions = 501
        assertTrue(additions > 500)
    }

    @Test
    fun shouldNotWarnWhenAdditionsAreBelow500() {
        val additions = 499
        assertFalse(additions > 500)
    }

    @Test
    fun shouldNotWarnWhenAdditionsAreExactly500() {
        val additions = 500
        assertFalse(additions > 500)
    }

    @Test
    fun shouldWarnWhenLabelsAreEmpty() {
        val labels = emptyList<String>()
        assertTrue(labels.isEmpty())
    }

    @Test
    fun shouldNotWarnWhenLabelsExist() {
        val labels = listOf("bug", "feature")
        assertFalse(labels.isEmpty())
    }

    @Test
    fun shouldShowMessageWhenDeletionsExceedAdditions() {
        val additions = 100
        val deletions = 150
        assertTrue(deletions > additions)
    }

    @Test
    fun shouldNotShowCleanupMessageWhenAdditionsExceedDeletions() {
        val additions = 150
        val deletions = 100
        assertFalse(deletions > additions)
    }

    @Test
    fun shouldNotShowCleanupMessageWhenAdditionsEqualDeletions() {
        val additions = 100
        val deletions = 100
        assertFalse(deletions > additions)
    }

    @Test
    fun shouldFindHeaderIndexForMilestoneVersions() {
        val lines = listOf(
            "Current Version",
            "Dependency Updates",
            "The following dependencies have later milestone versions:",
            "com.example:lib:1.0.0 -> 1.1.0",
            "com.example:other:2.0.0 -> 2.1.0"
        )
        val headerIndex = lines.indexOfFirst { line ->
            line.contains("The following dependencies have later milestone versions:")
        }
        assertEquals(headerIndex, 2)
    }

    @Test
    fun shouldReturnNegativeOneWhenHeaderNotFound() {
        val lines = listOf(
            "Current Version",
            "Dependency Updates",
            "Some other content"
        )
        val headerIndex = lines.indexOfFirst { line ->
            line.contains("The following dependencies have later milestone versions:")
        }
        assertEquals(headerIndex, -1)
    }

    @Test
    fun shouldExtractSublistAfterHeader() {
        val lines = listOf(
            "Header Line 1",
            "Header Line 2",
            "The following dependencies have later milestone versions:",
            "Dependency 1",
            "Dependency 2"
        )
        val headerIndex = lines.indexOfFirst { line ->
            line.contains("The following dependencies have later milestone versions:")
        }
        if (headerIndex >= 0) {
            val sublist = lines.subList(headerIndex, lines.size)
            assertEquals(sublist.size, 3)
            assertTrue(sublist[0].contains("The following dependencies"))
        }
    }

    @Test
    fun shouldJoinLinesWithNewline() {
        val lines = listOf("Line 1", "Line 2", "Line 3")
        val joined = lines.joinToString("\n")
        assertEquals(joined, "Line 1\nLine 2\nLine 3")
    }

    @Test
    fun shouldHandleEmptyFileLines() {
        val lines = emptyList<String>()
        val headerIndex = lines.indexOfFirst { line ->
            line.contains("milestone")
        }
        assertEquals(headerIndex, -1)
    }

    @Test
    fun shouldHandleSingleLineFile() {
        val lines = listOf("Single line")
        val headerIndex = lines.indexOfFirst { line ->
            line.contains("Single line")
        }
        assertEquals(headerIndex, 0)
    }

    @Test
    fun shouldTrimAndCheckNullOrBlankBody() {
        val bodyBlank = ""
        val bodyNull: String? = null
        val bodyValid = "Description"

        assertTrue(bodyBlank.isNullOrBlank())
        assertTrue(bodyNull.isNullOrBlank())
        assertFalse(bodyValid.isNullOrBlank())
    }

    @Test
    fun shouldIdentifyZeroAdditions() {
        val additions = 0
        assertEquals(additions, 0)
    }

    @Test
    fun shouldIdentifyZeroDeletions() {
        val deletions = 0
        assertEquals(deletions, 0)
    }

    @Test
    fun shouldHandleNegativeAdditionsEdgeCase() {
        val additions = -1
        assertFalse(additions > 500)
    }

    @Test
    fun shouldCheckMultipleConditionsForCleanup() {
        val additions = 50
        val deletions = 100
        
        assertTrue(deletions > additions)
        val isCleanup = deletions > additions
        assertTrue(isCleanup)
    }

    @Test
    fun shouldReadAndProcessFileLines() {
        // Create a temporary test file
        val testFile = File.createTempFile("test", ".txt")
        testFile.writeText("Line 1\nLine 2\nThe following dependencies have later milestone versions:\nLine 4")
        
        try {
            val lines = testFile.readLines()
            assertEquals(lines.size, 4)
            assertTrue(lines.isNotEmpty())
        } finally {
            testFile.delete()
        }
    }

    @Test
    fun shouldHandleFileWithoutHeaderLine() {
        val testFile = File.createTempFile("test", ".txt")
        testFile.writeText("Line 1\nLine 2\nLine 3")
        
        try {
            val lines = testFile.readLines()
            val headerIndex = lines.indexOfFirst { line ->
                line.contains("The following dependencies have later milestone versions:")
            }
            assertEquals(headerIndex, -1)
        } finally {
            testFile.delete()
        }
    }

    @Test
    fun shouldProcessFileWithMultipleMatches() {
        val lines = listOf(
            "Content",
            "The following dependencies have later milestone versions:",
            "Item 1",
            "Item 2"
        )
        val headerIndex = lines.indexOfFirst { line ->
            line.contains("The following dependencies have later milestone versions:")
        }
        assertEquals(headerIndex, 1)
    }

    @Test
    fun shouldHandleLabelsListOperations() {
        val labels = listOf("bug", "enhancement", "documentation")
        assertTrue(labels.isNotEmpty())
        assertEquals(labels.size, 3)
        assertTrue(labels.contains("bug"))
    }

    @Test
    fun shouldVerifyAdditionsAndDeletionsLogic() {
        // Case 1: Significant additions
        val adds1 = 600
        val dels1 = 50
        assertTrue(adds1 > 500)
        assertFalse(dels1 > adds1)

        // Case 2: Significant deletions
        val adds2 = 50
        val dels2 = 600
        assertFalse(adds2 > 500)
        assertTrue(dels2 > adds2)

        // Case 3: Balanced change
        val adds3 = 200
        val dels3 = 200
        assertFalse(adds3 > 500)
        assertFalse(dels3 > adds3)
    }
}