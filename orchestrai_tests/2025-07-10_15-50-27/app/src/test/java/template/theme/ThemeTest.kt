```kotlin
package template.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        // Setup any required test data
    }

    @Test
    fun templateTheme_light_colors() {
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false) {
                val colors = MaterialTheme.colors
                assertFalse("Should use light colors", colors.isLight.not())
            }
        }
    }

    @Test
    fun templateTheme_dark_colors() {
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true) {
                val colors = MaterialTheme.colors
                assertTrue("Should use dark colors", colors.isLight.not())
            }
        }
    }

    @Test
    fun templateTheme_applies_custom_colors() {
        composeTestRule.setContent {
            TemplateTheme {
                val colors = MaterialTheme.colors
                assertNotNull("Colors should not be null", colors)
                assertNotNull("Primary color should not be null", colors.primary)
                assertNotNull("Secondary color should not be null", colors.secondary)
            }
        }
    }

    @Test
    fun templateTheme_applies_typography() {
        composeTestRule.setContent {
            TemplateTheme {
                val typography = MaterialTheme.typography
                assertNotNull("Typography should not be null", typography)
                assertNotNull("Body1 should not be null", typography.body1)
                assertNotNull("H1 should not be null", typography.h1)
            }
        }
    }

    @Test
    fun templateTheme_applies_shapes() {
        composeTestRule.setContent {
            TemplateTheme {
                val shapes = MaterialTheme.shapes
                assertNotNull("Shapes should not be null", shapes)
                assertNotNull("Small shape should not be null", shapes.small)
                assertNotNull("Medium shape should not be null", shapes.medium)
                assertNotNull("Large shape should not be null", shapes.large)
            }
        }
    }

    @Test
    fun light_colors_configuration() {
        val lightColors = lightColors(
            primary = Purple500,
            primaryVariant = Purple700,
            secondary = Teal200
        )
        
        assertEquals("Primary should be Purple500", Purple500, lightColors.primary)
        assertEquals("Primary variant should be Purple700", Purple700, lightColors.primaryVariant)
        assertEquals("Secondary should be Teal200", Teal200, lightColors.secondary)
    }

    @Test
    fun dark_colors_configuration() {
        val darkColors = darkColors(
            primary = Purple200,
            primaryVariant = Purple700,
            secondary = Teal200
        )
        
        assertEquals("Primary should be Purple200", Purple200, darkColors.primary)
        assertEquals("Primary variant should be Purple700", Purple700, darkColors.primaryVariant)
        assertEquals("Secondary should be Teal200", Teal200, darkColors.secondary)
    }

    @Test
    fun templateTheme_content_execution() {
        var contentExecuted = false
        
        composeTestRule.setContent {
            TemplateTheme {
                contentExecuted = true
            }
        }
        
        assertTrue("Theme content should be executed", contentExecuted)
    }

    @Test
    fun templateTheme_material_theme_wrapper() {
        composeTestRule.setContent {
            TemplateTheme {
                // Verify MaterialTheme is properly applied
                val currentColors = MaterialTheme.colors
                val currentTypography = MaterialTheme.typography
                val currentShapes = MaterialTheme.shapes
                
                assertNotNull("MaterialTheme colors should be available", currentColors)
                assertNotNull("MaterialTheme typography should be available", currentTypography)
                assertNotNull("MaterialTheme shapes should be available", current