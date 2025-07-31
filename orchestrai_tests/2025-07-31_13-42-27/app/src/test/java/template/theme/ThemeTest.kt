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
    fun setup() {
        // Setup test environment
    }

    @Test
    fun templateTheme_applies_light_colors_when_dark_theme_false() {
        var capturedColors: androidx.compose.material.Colors? = null
        
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false) {
                capturedColors = MaterialTheme.colors
            }
        }
        
        composeTestRule.runOnIdle {
            assertNotNull(capturedColors)
            assertFalse(capturedColors!!.isLight.not()) // Should be light theme
        }
    }

    @Test
    fun templateTheme_applies_dark_colors_when_dark_theme_true() {
        var capturedColors: androidx.compose.material.Colors? = null
        
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true) {
                capturedColors = MaterialTheme.colors
            }
        }
        
        composeTestRule.runOnIdle {
            assertNotNull(capturedColors)
            assertFalse(capturedColors!!.isLight) // Should be dark theme
        }
    }

    @Test
    fun templateTheme_applies_typography() {
        var capturedTypography: androidx.compose.material.Typography? = null
        
        composeTestRule.setContent {
            TemplateTheme {
                capturedTypography = MaterialTheme.typography
            }
        }
        
        composeTestRule.runOnIdle {
            assertNotNull(capturedTypography)
            assertEquals(Typography, capturedTypography)
        }
    }

    @Test
    fun templateTheme_applies_shapes() {
        var capturedShapes: androidx.compose.material.Shapes? = null
        
        composeTestRule.setContent {
            TemplateTheme {
                capturedShapes = MaterialTheme.shapes
            }
        }
        
        composeTestRule.runOnIdle {
            assertNotNull(capturedShapes)
            assertEquals(Shapes, capturedShapes)
        }
    }

    @Test
    fun templateTheme_content_is_executed() {
        var contentExecuted = false
        
        composeTestRule.setContent {
            TemplateTheme {
                contentExecuted = true
            }
        }
        
        composeTestRule.runOnIdle {
            assertTrue(contentExecuted)
        }
    }

    @Test
    fun dark_colors_configuration() {
        val darkColors = darkColors(
            primary = Purple200,
            primaryVariant = Purple700,
            secondary = Teal200
        )
        
        assertEquals(Purple200, darkColors.primary)
        assertEquals(Purple700, darkColors.primaryVariant)
        assertEquals(Teal200, darkColors.secondary)
        assertFalse(darkColors.isLight)
    }

    @Test
    fun light_colors_configuration() {
        val lightColors = lightColors(
            primary = Purple500,
            primaryVariant = Purple700,
            secondary = Teal200
        )
        
        assertEquals(Purple500, lightColors.primary)
        assertEquals(Purple700, lightColors.primaryVariant)
        assertEquals(Teal200, lightColors.secondary)
        assertTrue(lightColors.isLight)
    }

    @Test
    fun theme_provides_material_theme_access() {
        var materialThemeAccessed = false
        
        composeTestRule.setContent {
            TemplateTheme {
                // Access MaterialTheme to verify it's available
                val colors = MaterialTheme.colors
                val typography = MaterialTheme.typography
                val shapes = MaterialTheme.shapes
                
                assertNotNull(colors)
                assertNotNull(typography)
                assertNotNull(shapes)
                materialThemeAccessed = true
            }
        }
        
        composeTestRule.runOnIdle {
            assertTrue(materialThemeAccessed)
        }
    }
}
```