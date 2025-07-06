```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ColorTest {

    @Test
    fun `Purple80 should have correct color value`() {
        val purple80 = Color(0xFFD0BCFF)
        assertNotNull(purple80)
        assertEquals(0xFFD0BCFF.toInt(), purple80.toArgb())
    }

    @Test
    fun `PurpleGrey80 should have correct color value`() {
        val purpleGrey80 = Color(0xFFCCC2DC)
        assertNotNull(purpleGrey80)
        assertEquals(0xFFCCC2DC.toInt(), purpleGrey80.toArgb())
    }

    @Test
    fun `Pink80 should have correct color value`() {
        val pink80 = Color(0xFFEFB8C8)
        assertNotNull(pink80)
        assertEquals(0xFFEFB8C8.toInt(), pink80.toArgb())
    }

    @Test
    fun `Purple40 should have correct color value`() {
        val purple40 = Color(0xFF6650a4)
        assertNotNull(purple40)
        assertEquals(0xFF6650a4.toInt(), purple40.toArgb())
    }

    @Test
    fun `PurpleGrey40 should have correct color value`() {
        val purpleGrey40 = Color(0xFF625b71)
        assertNotNull(purpleGrey40)
        assertEquals(0xFF625b71.toInt(), purpleGrey40.toArgb())
    }

    @Test
    fun `Pink40 should have correct color value`() {
        val pink40 = Color(0xFF7D5260)
        assertNotNull(pink40)
        assertEquals(0xFF7D5260.toInt(), pink40.toArgb())
    }

    @Test
    fun `colors should be different from each other`() {
        val purple80 = Color(0xFFD0BCFF)
        val purple40 = Color(0xFF6650a4)
        val pink80 = Color(0xFFEFB8C8)
        
        assertNotEquals(purple80.toArgb(), purple40.toArgb())
        assertNotEquals(purple80.toArgb(), pink80.toArgb())
        assertNotEquals(purple40.toArgb(), pink80.toArgb())
    }

    @Test
    fun `color alpha values should be correct`() {
        val purple80 = Color(0xFFD0BCFF)
        assertEquals(1.0f, purple80.alpha, 0.01f)
    }

    @Test
    fun `color components should be in valid range`() {
        val purple80 = Color(0xFFD0BCFF)
        
        assertTrue("Red component should be between 0 and 1", purple80.red in 0.0f..1.0f)
        assertTrue("Green component should be between 0 and 1", purple80.green in 0.0f..1.0f)
        assertTrue("Blue component should be between 0 and 1", purple80.blue in 0.0f..1.0f)
        assertTrue("Alpha component should be between 0 and 1", purple80.alpha in 0.0f..1.0f)
    }

    @Test
    fun `color should support transparency`() {
        val transparentColor = Color(0x80D0BCFF)
        assertTrue("Color should be semi-transparent", transparentColor.alpha < 1.0f)
    }

    private fun assertTrue(message: String, condition: Boolean) {
        org.junit.Assert.assertTrue(message, condition)
    }
}
```