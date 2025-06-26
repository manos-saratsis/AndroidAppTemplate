```kotlin
package template.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class ThemeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test TemplateAppTheme composition`() {
        composeTestRule.setContent {
            TemplateAppTheme {
                TestContent()
            }
        }
        // Verify theme is applied
        composeTestRule.onRoot().assertExists()
    }

    @Composable
    private fun TestContent() {
        MaterialTheme {
            // Test content
        }
    }
}
```