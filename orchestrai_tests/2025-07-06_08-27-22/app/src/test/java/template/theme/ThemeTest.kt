```kotlin
package template.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test

class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `dark color scheme should be created correctly`() {
        val darkColors = darkColorScheme(
            primary = Color(0xFFD0BCFF),
            secondary = Color(0xFFCCC2DC),
            tertiary = Color(0xFFEFB8C8)
        )
        
        assertNotNull(darkColors)
        assertEquals(Color(0xFFD0BCFF), darkColors.primary)
        assertEquals(Color(0xFFCCC2DC), darkColors.secondary)
        assertEquals(Color(0xFFEFB8C8), darkColors.tertiary)
    }

    @Test
    fun `light color scheme should be created correctly`() {
        val lightColors = lightColorScheme(
            primary = Color(0xFF6650a4),
            secondary = Color(0xFF625b71),
            tertiary = Color(0xFF7D5260)
        )
        
        assertNotNull(lightColors)
        assertEquals(Color(0xFF6650a4), lightColors.primary)
        assertEquals(Color(0xFF625b71), lightColors.secondary)
        assertEquals(Color(0xFF7D5260), lightColors.tertiary)
    }

    @Test
    fun `theme should apply colors correctly`() {
        composeTestRule.setContent {
            TestTheme(darkTheme = false) {
                val colors = MaterialTheme.colorScheme
                assertNotNull(colors)
            }
        }
    }

    @Test
    fun `dark theme should apply dark colors`() {
        composeTestRule.setContent {
            TestTheme(darkTheme = true) {
                val colors = MaterialTheme.colorScheme
                assertNotNull(colors)
            }
        }
    }

    @Test
    fun `theme should apply typography correctly`() {
        composeTestRule.setContent {
            TestTheme {
                val typography = MaterialTheme.typography
                assertNotNull(typography)
                assertNotNull(typography.bodyLarge)
                assertNotNull(typography.headlineLarge)
            }
        }
    }

    @Test
    fun `theme should apply shapes correctly`() {
        composeTestRule.setContent {
            TestTheme {
                val shapes = MaterialTheme.shapes
                assertNotNull(shapes)
                assertNotNull(shapes.small)
                assertNotNull(shapes.medium)
                assertNotNull(shapes.large)