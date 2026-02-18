package template

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class GreetingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `Greeting should display text with given name`() {
        // Arrange
        val name = "Android"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with custom name`() {
        // Arrange
        val name = "World"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello World!").assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with empty name`() {
        // Arrange
        val name = ""

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello !").assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with single character name`() {
        // Arrange
        val name = "A"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello A!").assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with long name`() {
        // Arrange
        val name = "Very Long Name With Multiple Words"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello Very Long Name With Multiple Words!")
            .assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with special characters in name`() {
        // Arrange
        val name = "Test@123#"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello Test@123#!").assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with unicode characters in name`() {
        // Arrange
        val name = "世界"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello 世界!").assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with numeric name`() {
        // Arrange
        val name = "12345"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello 12345!").assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with whitespace name`() {
        // Arrange
        val name = "   "

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello    !").assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with newline in name`() {
        // Arrange
        val name = "Line1\nLine2"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello Line1\nLine2!").assertIsDisplayed()
    }

    @Test
    fun `Greeting should display text with tab character in name`() {
        // Arrange
        val name = "Name\tWith\tTabs"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello Name\tWith\tTabs!").assertIsDisplayed()
    }

    @Test
    fun `Greeting should properly format text with name parameter`() {
        // Arrange
        val name = "Kotlin"

        // Act
        composeTestRule.setContent {
            Greeting(name)
        }

        // Assert - Verify the exact text format
        composeTestRule.onNodeWithText("Hello Kotlin!", substring = false)
            .assertExists()
            .assertIsDisplayed()
    }
}