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
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var lightColorScheme: ColorScheme
    private lateinit var darkColorScheme: ColorScheme

    @Before
    fun setUp() {
        lightColorScheme = lightColorScheme(
            primary = Color(0xFF6650a4),
            onPrimary = Color.White,
            secondary = Color(0xFF625b71),
            onSecondary = Color.White
        )

        darkColorScheme = darkColorScheme(
            primary = Color(0xFFD0BCFF),
            onPrimary = Color(0xFF381E72),
            secondary = Color(0xFFCCC2DC),
            onSecondary = Color(0xFF332D41)
        )
    }

    @Test
    fun testLightColorSchemeCreation() {
        assertNotNull(lightColorScheme)
        assertEquals(Color