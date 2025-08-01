```kotlin
package template.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
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
    fun testColorSchemeContrast() {
        // Test that light and dark schemes have different primary colors
        assertNotEquals(lightColors.primary, darkColors.primary)
        assertNotEquals(lightColors.secondary, darkColors.secondary)
        assertNotEquals(lightColors.tertiary, darkColors.tertiary)
    }

    @Test
    fun testThemeComposition() {
        var themeApplied = false
        
        composeTestRule.setContent {
            TemplateTheme {
                themeApplied = true
            }
        }
        
        composeTestRule.waitForIdle()
        assertTrue("Theme should be applied", themeApplied)
    }

    @Test
    fun testDarkThemeComposition() {
        var darkThemeApplied = false
        
        composeTestRule.setContent {
            TemplateTheme(dark