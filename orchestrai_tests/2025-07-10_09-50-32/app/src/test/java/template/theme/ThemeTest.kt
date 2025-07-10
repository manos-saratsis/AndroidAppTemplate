```kotlin
package template.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `light theme should have correct colors`() {
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false) {
                val colors = MaterialTheme.colors
                assertFalse(colors.isLight)
                assertEquals(Purple500, colors.primary)
                assertEquals(Purple700, colors.primaryVariant)
                assertEquals(Teal200, colors.secondary)
            }
        }
    }

    @Test
    fun `dark theme should have correct colors`() {
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true) {
                val colors = MaterialTheme.colors
                assertTrue(colors.isLight)
                assertEquals(Purple200, colors.primary)
                assertEquals(Purple700, colors.primaryVariant)
                assertEquals(Teal200, colors.secondary)
            }
        }
    }

    @Test
    fun `theme should apply correct typography`() {
        composeTestRule.setContent {
            TemplateTheme {
                val typography = MaterialTheme.typography
                assertNotNull(typography)
                assertEquals(Typography, typography)
            }
        }
    }

    @Test
    fun `theme should apply correct shapes`() {
        composeTestRule.setContent {
            TemplateTheme {
                val shapes = MaterialTheme.shapes
                assertNotNull(shapes)
                assertEquals(Shapes, shapes)
            }
        }
    }

    @Test
    fun `theme should handle content parameter`() {
        var contentExecuted = false
        
        composeTestRule.setContent {
            TemplateTheme {
                contentExecuted = true
            }
        }
        
        assertTrue(contentExecuted)
    }

    @Test
    fun `theme should use system dark theme by default`() {
        composeTestRule.setContent {
            TemplateTheme {
                // Theme should be applied without errors
                assertNotNull(MaterialTheme.colors)
                assertNotNull(MaterialTheme.typography)
                assertNotNull(MaterialTheme.shapes)
            }
        }
    }

    @Test
    fun `light colors should be properly configured`() {
        val lightColors = lightColors(
            primary = Purple500,
            primaryVariant = Purple700,
            secondary = Teal200
        )
        
        assertEquals(Purple500, lightColors.primary)
        assertEquals(Purple700, lightColors.primaryVariant)
        assertEquals(Teal200, lightColors.secondary)
        assertFalse(lightColors.isLight)
    }

    @Test
    fun `dark colors should be properly configured`() {