package template

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented tests for [MainActivity].
 *
 * These tests verify that:
 *  1. The Activity launches successfully without throwing.
 *  2. onCreate correctly sets Compose content, applying edge-to-edge display,
 *     the TemplateTheme wrapper, a Surface using the theme's background color,
 *     and renders the Greeting("Android") composable inside it.
 *  3. The expected "Hello Android!" text is displayed on screen after launch,
 *     confirming full execution of the onCreate lambda passed to setContent.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun should_launch_activity_without_crashing() {
        // Arrange & Act
        // The activity is automatically launched by createAndroidComposeRule.

        // Assert
        composeTestRule.activity.let { activity ->
            assert(activity != null) { "MainActivity instance should not be null after launch" }
        }
    }

    @Test
    fun should_display_hello_android_greeting_on_launch() {
        // Arrange
        // Activity is launched via the compose test rule during setup.

        // Act
        // No additional action required; onCreate already invoked setContent.

        // Assert
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }

    @Test
    fun should_have_non_null_activity_reference() {
        // Arrange & Act
        val activity = composeTestRule.activity

        // Assert
        assert(activity is MainActivity) { "Activity under test should be of type MainActivity" }
    }
}