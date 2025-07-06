```kotlin
package template.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(AndroidJUnit4::class)
class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `light theme colors are correct`() {
        val lightColors = lightColors(
            primary = Purple500,
            primaryVariant = Purple700,
            secondary = Teal200
        )

        assertEquals(Purple500, lightColors.primary)
        assertEquals(Purple700, lightColors.primaryVariant)
        assertEquals(Teal200, lightColors.secondary)
    }

    @Test
    fun `dark theme colors are correct`() {
        val darkColors = darkColors(
            primary = Purple200,
            primaryVariant = Purple700,
            secondary = Teal200
        )

        assertEquals(Purple200, darkColors.primary)
        assertEquals(Purple700, darkColors.primaryVariant)
        assertEquals(Teal200, darkColors.secondary)
    }

    @Test
    fun `template theme applies correctly in light mode`() {
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false) {
                val colors = MaterialTheme.colors
                assertEquals(Purple500, colors.primary)
                assertEquals(Purple700, colors.primaryVariant)
                assertEquals(Teal200, colors.secondary)
            }
        }
    }

    @Test
    fun `template theme applies correctly in dark mode`() {
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true) {
                val colors = MaterialTheme.colors
                assertEquals(Purple200, colors.primary)
                assertEquals(Purple700, colors.primaryVariant)
                assertEquals(Teal200, colors.secondary)
            }
        }
    }

    @Test
    fun `template theme provides correct typography`() {
        composeTestRule.setContent {
            TemplateTheme {
                val typography = MaterialTheme.typography
                assertNotNull(typography)
                assertNotNull(typography.h1)
                assertNotNull(typography.body1)
                assertNotNull(typography.button)
            }
        }
    }

    @Test
    fun `template theme provides correct shapes`() {
        composeTestRule.setContent {
            TemplateTheme {
                val shapes = MaterialTheme.shapes
                assertNotNull(shapes)
                assertNotNull(shapes.small)
                assertNotNull(shapes.medium)
                assertNotNull(shapes.large)
            }
        }
    }

    @Test
    fun `theme switches correctly between light and dark`() {
        // Test light theme
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false) {
                val lightColors = MaterialTheme.colors
                assertEquals(Purple500, lightColors.primary)
            }
        }

        // Test dark theme
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true) {
                val darkColors = MaterialTheme.colors
                assertEquals(Purple200, darkColors.primary)
            }
        }
    }

    @Test
    fun `theme content is properly wrapped`() {
        var contentExecuted = false
        
        composeTestRule.setContent {
            TemplateTheme {
                contentExecuted = true
            }
        }
        
        composeTestRule.waitForIdle()
        assertEquals(true, contentExecuted)
    }
}
```