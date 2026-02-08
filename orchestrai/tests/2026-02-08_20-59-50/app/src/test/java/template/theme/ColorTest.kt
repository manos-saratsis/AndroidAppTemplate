package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test
import kotlin.test.assertEquals

class ColorTest {

    @Test
    fun testPurple200ColorValue() {
        val expectedColor = Color(0xFFBB86FC)
        assertEquals(expectedColor, Purple200)
    }

    @Test
    fun testPurple200ColorIsNotNull() {
        assert(Purple200 != null)
    }

    @Test
    fun testPurple200HasCorrectAlpha() {
        // Purple200 has full alpha (0xFF)
        assertEquals(255, (Purple200.value shr 24).toInt() and 0xFF)
    }

    @Test
    fun testPurple200HasCorrectRed() {
        // Purple200 red component is 0xBB
        assertEquals(187, (Purple200.value shr 16).toInt() and 0xFF)
    }

    @Test
    fun testPurple200HasCorrectGreen() {
        // Purple200 green component is 0x86
        assertEquals(134, (Purple200.value shr 8).toInt() and 0xFF)
    }

    @Test
    fun testPurple200HasCorrectBlue() {
        // Purple200 blue component is 0xFC
        assertEquals(252, Purple200.value.toInt() and 0xFF)
    }

    @Test
    fun testPurple500ColorValue() {
        val expectedColor = Color(0xFF6200EE)
        assertEquals(expectedColor, Purple500)
    }

    @Test
    fun testPurple500ColorIsNotNull() {
        assert(Purple500 != null)
    }

    @Test
    fun testPurple500HasCorrectAlpha() {
        // Purple500 has full alpha (0xFF)
        assertEquals(255, (Purple500.value shr 24).toInt() and 0xFF)
    }

    @Test
    fun testPurple500HasCorrectRed() {
        // Purple500 red component is 0x62
        assertEquals(98, (Purple500.value shr 16).toInt() and 0xFF)
    }

    @Test
    fun testPurple500HasCorrectGreen() {
        // Purple500 green component is 0x00
        assertEquals(0, (Purple500.value shr 8).toInt() and 0xFF)
    }

    @Test
    fun testPurple500HasCorrectBlue() {
        // Purple500 blue component is 0xEE
        assertEquals(238, Purple500.value.toInt() and 0xFF)
    }

    @Test
    fun testTeal200ColorValue() {
        val expectedColor = Color(0xFF03DAC5)
        assertEquals(expectedColor, Teal200)
    }

    @Test
    fun testTeal200ColorIsNotNull() {
        assert(Teal200 != null)
    }

    @Test
    fun testTeal200HasCorrectAlpha() {
        // Teal200 has full alpha (0xFF)
        assertEquals(255, (Teal200.value shr 24).toInt() and 0xFF)
    }

    @Test
    fun testTeal200HasCorrectRed() {
        // Teal200 red component is 0x03
        assertEquals(3, (Teal200.value shr 16).toInt() and 0xFF)
    }

    @Test
    fun testTeal200HasCorrectGreen() {
        // Teal200 green component is 0xDA
        assertEquals(218, (Teal200.value shr 8).toInt() and 0xFF)
    }

    @Test
    fun testTeal200HasCorrectBlue() {
        // Teal200 blue component is 0xC5
        assertEquals(197, Teal200.value.toInt() and 0xFF)
    }

    @Test
    fun testAllColorsAreDistinct() {
        assert(Purple200 != Purple500)
        assert(Purple200 != Teal200)
        assert(Purple500 != Teal200)
    }

    @Test
    fun testColorsHaveValidHexValues() {
        // Verify all colors have valid hex representations
        assert(Purple200.value != 0L)
        assert(Purple500.value != 0L)
        assert(Teal200.value != 0L)
    }

    @Test
    fun testColorInstantiationWithHexValue() {
        val color1 = Color(0xFFBB86FC)
        val color2 = Purple200
        assertEquals(color1, color2)
    }

    @Test
    fun testPurple200ToString() {
        // Verify color can be converted to string without exception
        assert(Purple200.toString().isNotEmpty())
    }

    @Test
    fun testPurple500ToString() {
        // Verify color can be converted to string without exception
        assert(Purple500.toString().isNotEmpty())
    }

    @Test
    fun testTeal200ToString() {
        // Verify color can be converted to string without exception
        assert(Teal200.toString().isNotEmpty())
    }

    @Test
    fun testColorEqualitySymmetric() {
        val purple200Copy = Purple200
        assertEquals(Purple200, purple200Copy)
        assertEquals(purple200Copy, Purple200)
    }

    @Test
    fun testColorEqualityTransitive() {
        val color1 = Color(0xFFBB86FC)
        val color2 = Purple200
        val color3 = Color(0xFFBB86FC)
        
        assertEquals(color1, color2)
        assertEquals(color2, color3)
        assertEquals(color1, color3)
    }
}