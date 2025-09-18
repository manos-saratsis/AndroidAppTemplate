```kotlin
package template.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ThemeTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testDarkColorScheme() {
        val darkColors = darkColorScheme(
            primary = Purple80,
            secondary = PurpleGrey80,
            tertiary = Pink80
        )
        
        assertNotNull(darkColors)
        assertEquals(Purple80, darkColors.primary)
        assertEquals(PurpleGrey80, darkColors.secondary)
        assertEquals(Pink80, darkColors.tertiary)
    }

    @Test
    fun testLightColorScheme() {
        val lightColors = lightColorScheme(
            primary = Purple40,
            secondary = PurpleGrey40,
            tertiary = Pink40
        )
        
        assertNotNull(lightColors)
        assertEquals(Purple40, lightColors.primary)
        assertEquals(PurpleGrey40, lightColors.secondary)
        assertEquals(Pink40, lightColors.tertiary)
    }

    @Test
    fun testColorSchemeProperties() {
        val lightColors = lightColorScheme()
        val darkColors = darkColorScheme()
        
        // Test that color schemes have all required properties
        assertNotNull(lightColors.primary)
        assertNotNull(lightColors.onPrimary)
        assertNotNull(lightColors.secondary)
        assertNotNull(lightColors.onSecondary)
        assertNotNull(lightColors.background)
        assertNotNull(lightColors.onBackground)
        assertNotNull(lightColors.surface)
        assertNotNull(lightColors.onSurface)
        
        assertNotNull(darkColors.primary)
        assertNotNull(darkColors.onPrimary)
        assertNotNull(darkColors.secondary)
        assertNotNull(darkColors.onSecondary)
        assertNotNull(darkColors.background)
        assertNotNull(darkColors.onBackground)
        assertNotNull(darkColors.surface)
        assertNotNull(darkColors.onSurface)
    }

    @Test
    fun testThemeComposition() {
        composeRule.setContent {
            TemplateTheme {
                // Test that theme can be applied without errors
            }
        }
        
        // If we reach here, the theme was applied successfully
        assertTrue(true)
    }

    @Test
    fun testDarkThemeComposition() {
        composeRule.setContent {
            TemplateTheme(darkTheme = true) {
                // Test that dark theme can be applied without errors
            }
        }
        
        // If we reach here, the dark theme was applied successfully
        assertTrue(true)
    }

    @Test
    fun testLightThemeComposition() {
        composeRule.setContent {
            TemplateTheme(darkTheme = false) {
                // Test that light theme can be applied without errors
            }
        }
        
        // If we reach here, the light theme was applied successfully
        assertTrue(true)
    }

    @Test
    fun testDynamicColorSupport() {
        // Test that theme works with and without dynamic colors
        composeRule.setContent {
            TemplateTheme(dynamicColor = true) {
                // Test dynamic color theme
            }
        }
        
        composeRule.setContent {
            TemplateTheme(dynamicColor = false) {
                // Test static color theme
            }
        }
        
        assertTrue(true)
    }
}
```