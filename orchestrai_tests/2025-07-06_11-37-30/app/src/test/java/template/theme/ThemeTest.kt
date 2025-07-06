```kotlin
package template.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
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

    @Before
    fun setUp() {
        // Setup test environment
    }

    @Test
    fun androidAppTemplateTheme_light_colors() {
        composeTestRule.setContent {
            AndroidAppTemplateTheme(darkTheme = false) {
                val colors = MaterialTheme.colors
                
                assertNotNull(colors)
                assertFalse(colors.isLight.not())
                assertEquals(Purple500, colors.primary)
                assertEquals(Purple700, colors.primaryVariant)
                assertEquals(Teal200, colors.secondary)
            }
        }
    }

    @Test
    fun androidAppTemplateTheme_dark_colors() {
        composeTestRule.setContent {
            AndroidAppTemplateTheme(darkTheme = true) {
                val colors = MaterialTheme.colors
                
                assertNotNull(colors)
                assertTrue(colors.isLight.not())
                assertEquals(Purple200, colors.primary)
                assertEquals(Purple700, colors.primaryVariant)
                assertEquals(Teal200, colors.secondary)
            }
        }
    }

    @Test
    fun androidAppTemplateTheme_typography() {
        composeTestRule.setContent {
            AndroidAppTemplateTheme {
                val typography = MaterialTheme.typography
                
                assertNotNull(typography)
                assertNotNull(typography.h1)
                assertNotNull(typography.h2)
                assertNotNull(typography.body1)
                assertNotNull(typography.body2)
                assertNotNull(typography.button)
                assertNotNull(typography.caption)
            }
        }
    }

    @Test
    fun androidAppTemplateTheme_shapes() {
        composeTestRule.setContent {
            AndroidAppTemplateTheme {
                val shapes = MaterialTheme.shapes
                
                assertNotNull(shapes)
                assertNotNull(shapes.small)
                assertNotNull(shapes.medium)
                assertNotNull(shapes.large)
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
        
        assertEquals(Purple500, lightColors.primary)
        assertEquals(Purple700, lightColors.primaryVariant)
        assertEquals(Teal200, lightColors.secondary)
        assertTrue(lightColors.isLight)
    }

    @Test
    fun dark_colors_configuration() {
        val darkColors = darkColors(
            primary = Purple200,
            primaryVariant = Purple700,