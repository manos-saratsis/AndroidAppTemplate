```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ColorTest {

    @Before
    fun setUp() {
        // Setup any required initialization
    }

    @Test
    fun testPurple80Color() {
        val purple80 = Color(0xFFD0BCFF)
        assertNotNull(purple80)
        assertEquals(0xFFD0BCFF.toInt(), purple80.toArgb())
    }

    @Test
    fun testPurpleGrey80Color() {
        val purpleGrey80 = Color(0xFFCCC2DC)
        assertNotNull(purpleGrey80)
        assertEquals(0xFFCCC2DC.toInt(), purpleGrey80.toArgb())
    }

    @Test
    fun testPink80Color() {
        val pink80 = Color(0xFFEFB8C8)
        assertNotNull(pink80)
        assertEquals(0xFFEFB8C8.toInt(), pink80.toArgb())
    }

    @Test
    fun testPurple40Color() {
        val purple40 = Color(0xFF6650a4)
        assertNotNull(purple40)
        assertEquals(0xFF6650a4.toInt(), purple40.toArgb())
    }

    @Test
    fun testPurpleGrey40Color() {
        val purpleGrey40 = Color(0xFF625b71)
        assertNotNull(purpleGrey40)
        assertEquals(0xFF625b71.toInt(), purpleGrey40.toArgb())
    }

    @Test
    fun testPink40Color() {
        val pink40 = Color(0xFF7D5260)
        assertNotNull(pink40)
        assertEquals(0xFF7D5260.toInt(), pink40.toArgb())
    }

    @Test
    fun testColorTransparency() {
        val transparentColor = Color(0x80FF0000) // 50% transparent red
        assertEquals(0.5f, transparentColor.alpha, 0.01f)
    }

    @Test
    fun testColorComponents() {
        val testColor = Color(0xFFFF0000) // Red
        assertEquals(1.0f, testColor.red, 0.01f)
        assertEquals(0.0f, testColor.green, 0.01f)
        assertEquals(0.0f, testColor.blue, 0.01f)
        assertEquals(1.0f, testColor.alpha, 0.01f)
    }

    @Test
    fun testColorEquality() {
        val color1 = Color(0xFFD0BCFF)
        val color2 = Color(0xFFD0BCFF)
        assertEquals(color1, color2)
    }

    @Test
    fun testColorInequality() {
        val color1 = Color(0xFFD0BCFF)
        val color2 = Color(0xFFCCC2DC)
        assertNotEquals(color1, color2)
    }

    @Test
    fun testColorToString() {
        val color = Color(0xFFD0BCFF)
        val colorString = color.toString()
        assertNotNull(colorString)
        assertTrue(colorString.isNotEmpty())
    }

    @Test
    fun testColorCopy() {
        val originalColor = Color(0xFFD0BCFF)
        val copiedColor = originalColor.copy(alpha = 0.5f)
        assertEquals(0.5f, copiedColor.alpha, 0.01f)
        assertEquals(originalColor.red, copiedColor.red, 0.01f)
        assertEquals(originalColor.green, copiedColor.green, 0.01f)
        assertEquals(originalColor.blue, copiedColor.blue, 0.01f)
    }
}
```