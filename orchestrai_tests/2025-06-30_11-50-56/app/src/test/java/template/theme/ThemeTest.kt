```kotlin
package template.theme

import androidx.compose.material3.MaterialTheme
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
    fun `TemplateAppTheme applies correct colors in light mode`() {
        composeTestRule.setContent {
            TemplateAppTheme(darkTheme = false) {
                assertThemeColors(darkTheme = false)
            }
        }
    }

    @Test
    fun `TemplateAppTheme applies correct colors in dark mode`() {
        composeTestRule.setContent {
            TemplateAppTheme(darkTheme = true) {
                assertThemeColors(darkTheme = true)
            }
        }
    }

    @Composable
    private fun assertThemeColors(darkTheme: Boolean) {
        val colors = MaterialTheme.colorScheme
        if (darkTheme) {
            assert(colors.primary == DarkColorScheme.primary)
            assert(colors.secondary == DarkColorScheme.secondary)
        } else {
            assert(colors.primary == LightColorScheme.primary)
            assert(colors.secondary == LightColorScheme.secondary)
        }
    }
}
```

3. Let's test the TemplateApp class: