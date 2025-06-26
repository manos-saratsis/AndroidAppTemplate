```kotlin
package template

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [29])
class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test MainActivity creation`() {
        composeTestRule.setContent {
            MainActivity()
        }
        // Verify compose content is created successfully
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun `test greeting message displayed`() {
        composeTestRule.setContent {
            MainActivity()
        }
        // Add specific UI element verification
    }
}
```