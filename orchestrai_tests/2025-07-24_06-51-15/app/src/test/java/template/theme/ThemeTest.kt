```kotlin
package template.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var lightColors: ColorScheme
    private lateinit var darkColors: ColorScheme

    @Before
    fun setUp() {
        lightColors = lightColorScheme(
            primary = Purple40,
            secondary = PurpleGrey40,
            tertiary = Pink40
        )
        
        darkColors = darkColorScheme(
            primary = Purple80,
            secondary = PurpleGrey80,
            tertiary = Pink80
        )
    }

    @Test
    fun testLightColorScheme() {
        assertNotNull(lightColors)
        assertEquals(Purple40, lightColors.primary)
        assertEquals(PurpleGrey40, lightColors.secondary)
        assertEquals(Pink40, lightColors.tertiary)
    }

    @Test
    fun testDarkColorScheme() {
        assertNotNull(darkColors)
        assertEquals(Purple80, darkColors.primary)
        assertEquals(PurpleGrey80, darkColors.secondary)
        assertEquals(Pink80, darkColors.tertiary)
    }

    @Test
    fun testThemeComposition() {
        composeTestRule.setContent {
            TemplateTheme {
                // Test that theme is applied without errors
                val currentColors = MaterialTheme.colorScheme
                assertNotNull(currentColors)
                
                val currentTypography = MaterialTheme.typography
                assertNotNull(currentTypography)
                
                val currentShapes = MaterialTheme.shapes
                assertNotNull(currentShapes)
            }
        }
    }

    @Test
    fun testLightTheme() {
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false) {
                val colors = MaterialTheme.colorScheme
                // In light theme, we expect lighter colors
                assertNotNull(colors.primary)
                assertNotNull(colors.background)
                assertNotNull(colors.surface)
            }
        }
    }

    @Test
    fun testDarkTheme() {
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true) {
                val colors = MaterialTheme.colorScheme
                // In dark theme, we expect darker colors
                assertNotNull(colors.primary)
                assertNotNull(colors.background)
                assertNotNull(colors.surface)
            }
        }
    }

    @Test
    fun testDynamicColorSupport() {
        // Test that dynamic color parameter works
        composeTestRule.setContent {
            TemplateTheme(
                darkTheme = false,
                dynamicColor = true
            ) {
                val colors = MaterialTheme.colorScheme
                assertNotNull(colors)
            }
        }
    }

    @Test
    fun testThemeTypography() {
        composeTestRule.setContent {
            TemplateTheme {
                val typography = MaterialTheme.typography
                assertNotNull(typography.displayLarge)
                assertNotNull(typography.headlineLarge)
                assertNotNull(typography.bodyLarge)
                assertNotNull(typography.labelLarge)
            }
        }
    }

    @Test
    fun testThemeShapes() {
        composeTestRule.setContent {
            TemplateTheme {
                val shapes = MaterialTheme.shapes
                assertNotNull(shapes.small)
                assertNotNull(shapes.medium)
                assertNotNull(shapes.large)
            }
        }
    }
}
```