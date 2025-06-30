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
    fun `test theme colors`() {
        composeTestRule.setContent {
            TemplateAppTheme {
                assertThemeColors()
            }
        }
    }

    @Test
    fun `test dark theme colors`() {
        composeTestRule.setContent {
            TemplateAppTheme(darkTheme = true) {
                assertThemeColors()
            }
        }
    }

    @Composable
    private fun assertThemeColors() {
        val colors = MaterialTheme.colors
        assert(colors.primary.value != 0L)
        assert(colors.secondary.value != 0L)
        assert(colors.background.value != 0L)
    }
}
```