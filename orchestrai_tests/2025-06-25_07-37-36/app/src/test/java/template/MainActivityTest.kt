```kotlin
package template

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test MainActivity onCreate sets up compose content`() {
        composeTestRule.setContent {
            // Test the Composable content
            MainActivityContent()
        }
        
        // Verify compose content is rendered
        composeTestRule.onRoot().assertExists()
    }
}
```