```kotlin
package template.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ThemeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test TemplateTheme applies correct theme`() {
        composeTestRule.setContent {
            TemplateTheme {
                // Verify theme properties
                assertThemeProperties()
            }
        }
    }

    @Composable
    private fun assertThemeProperties() {
        val colors = MaterialTheme.colors
        val typography = MaterialTheme.typography
        val shapes = MaterialTheme.shapes
        
        // Add specific assertions for theme properties
    }
}
```