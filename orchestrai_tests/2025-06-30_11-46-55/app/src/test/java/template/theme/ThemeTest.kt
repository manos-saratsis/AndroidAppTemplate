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
    fun `test dark theme colors`() {
        composeTestRule.setContent {
            TemplateAppTheme(darkTheme = true) {
                assertThemeColors(true)
            }
        }
    }

    @Test
    fun `test light theme colors`() {
        composeTestRule.setContent {
            TemplateAppTheme(darkTheme = false) {
                assertThemeColors(false)
            }
        }
    }

    @Composable
    private fun assertThemeColors(isDark: Boolean) {
        val colors = MaterialTheme.colors
        if (isDark) {
            assert(colors.isLight.not())
        } else {
            assert(colors.isLight)
        }
    }
}
```