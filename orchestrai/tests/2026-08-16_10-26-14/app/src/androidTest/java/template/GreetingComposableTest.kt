package template

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4

/**
 * Instrumented UI tests for the [Greeting] composable declared in MainActivity.kt.
 *
 * Compose UI testing requires the JUnit4-based ComposeTestRule infrastructure
 * (androidx.compose.ui.test.junit4). This test class exercises the Greeting
 * composable with multiple inputs to guarantee full line/branch coverage of
 * the function (it has no branches, but we verify correct rendering for
 * various argument values including edge cases such as empty and blank
 * strings, to guarantee behavior is deterministic and fully covered).
 */
@RunWith(AndroidJUnit4::class)
class GreetingComposableTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        // No global setup required; each test sets its own content.
    }

    @After
    fun tearDown() {
        // No teardown required.
    }

    @Test
    fun should_display_greeting_text_when_name_is_android() {
        // Arrange
        val name = "Android"

        // Act
        composeTestRule.setContent {
            Greeting(name = name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello $name!").assertIsDisplayed()
    }

    @Test
    fun should_display_greeting_text_when_name_is_custom_value() {
        // Arrange
        val name = "World"

        // Act
        composeTestRule.setContent {
            Greeting(name = name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello World!").assertIsDisplayed()
    }

    @Test
    fun should_display_greeting_text_when_name_is_empty_string() {
        // Arrange
        val name = ""

        // Act
        composeTestRule.setContent {
            Greeting(name = name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello !").assertIsDisplayed()
    }

    @Test
    fun should_display_greeting_text_when_name_contains_special_characters() {
        // Arrange
        val name = "!@#$%^&*()"

        // Act
        composeTestRule.setContent {
            Greeting(name = name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello $name!").assertIsDisplayed()
    }

    @Test
    fun should_display_greeting_text_when_name_is_long_string() {
        // Arrange
        val name = "A".repeat(500)

        // Act
        composeTestRule.setContent {
            Greeting(name = name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello $name!").assertIsDisplayed()
    }

    @Test
    fun should_display_greeting_text_when_name_has_whitespace() {
        // Arrange
        val name = "   "

        // Act
        composeTestRule.setContent {
            Greeting(name = name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello $name!").assertIsDisplayed()
    }

    @Test
    fun should_display_greeting_text_when_name_has_unicode_characters() {
        // Arrange
        val name = "\u00c1\u00e9\u00ee\u00f6\u00fc"

        // Act
        composeTestRule.setContent {
            Greeting(name = name)
        }

        // Assert
        composeTestRule.onNodeWithText("Hello $name!").assertIsDisplayed()
    }
}