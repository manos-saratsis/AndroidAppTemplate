```kotlin
package template

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import template.theme.TemplateAppTheme

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test MainActivity content rendering`() {
        composeTestRule.setContent {
            TemplateAppTheme {
                MainActivity()
            }
        }
        // Verify compose UI elements are rendered
        composeTestRule.onRoot().assertExists()
    }
}
```