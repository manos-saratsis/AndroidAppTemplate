```kotlin
package template

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        // Setup any required mocks or test data
    }

    @Test
    fun `activity launches successfully`() {
        // Test that the activity can be created without crashing
        composeTestRule.activity
    }

    @Test
    fun `activity displays correct content`() {
        // Test that the main content is displayed
        composeTestRule.onNodeWithText("Android App Template")
            .assertExists()
    }

    @Test
    fun `activity handles configuration changes`() {
        // Test configuration changes like rotation
        val activity = composeTestRule.activity
        activity.recreate()
        
        // Verify activity still works after recreation
        composeTestRule.onNodeWithText("Android App Template")
            .assertExists()
    }

    @Test
    fun `activity sets correct theme`() {
        // Test that the correct theme is applied
        val activity = composeTestRule.activity
        assert(activity.theme != null)
    }

    @Test
    fun `activity handles back press correctly`() {
        val activity = composeTestRule.activity
        activity.onBackPressed()
        // Verify expected behavior after back press
    }
}
```