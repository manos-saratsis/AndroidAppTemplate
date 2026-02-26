package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Assert.assertEquals
import org.junit.Test

class ColorTest {

    @Test
    fun testPurple200ColorValue() {
        assertEquals(Color(0xFFBB86FC), Purple200)
    }

    @Test
    fun testPurple200IsNotNull() {
        assert(Purple200 != null)
    }

    @Test
    fun testPurple500ColorValue() {
        assertEquals(Color(0xFF6200EE), Purple500)
    }

    @Test
    fun testPurple500IsNotNull() {
        assert(Purple500 != null)
    }

    @Test
    fun testTeal200ColorValue() {
        assertEquals(Color(0xFF03DAC5), Teal200)
    }

    @Test
    fun testTeal200IsNotNull() {
        assert(Teal200 != null)
    }

    @Test
    fun testPurple200AlphaChannel() {
        // 0xFFBB86FC - Alpha channel should be 0xFF (fully opaque)
        assertEquals(1f, Purple200.alpha, 0.001f)
    }

    @Test
    fun testPurple500AlphaChannel() {
        // 0xFF6200EE - Alpha channel should be 0xFF (fully opaque)
        assertEquals(1f, Purple500.alpha, 0.001f)
    }

    @Test
    fun testTeal200AlphaChannel() {
        // 0xFF03DAC5 - Alpha channel should be 0xFF (fully opaque)
        assertEquals(1f, Teal200.alpha, 0.001f)
    }

    @Test
    fun testColorsAreDistinct() {
        assert(Purple200 != Purple500)
        assert(Purple500 != Teal200)
        assert(Purple200 != Teal200)
    }

    @Test
    fun testColorEquality() {
        val purple200Copy = Color(0xFFBB86FC)
        assertEquals(purple200Copy, Purple200)
    }

    @Test
    fun testColorImmutability() {
        val originalColor = Purple200
        val sameColor = Purple200
        assertEquals(originalColor, sameColor)
    }

    @Test
    fun testColorHexValuePurple200() {
        // Verify the exact hex value
        val expectedColor = Color(0xFFBB86FC)
        assertEquals(expectedColor.red, Purple200.red, 0.001f)
        assertEquals(expectedColor.green, Purple200.green, 0.001f)
        assertEquals(expectedColor.blue, Purple200.blue, 0.001f)
    }

    @Test
    fun testColorHexValuePurple500() {
        val expectedColor = Color(0xFF6200EE)
        assertEquals(expectedColor.red, Purple500.red, 0.001f)
        assertEquals(expectedColor.green, Purple500.green, 0.001f)
        assertEquals(expectedColor.blue, Purple500.blue, 0.001f)
    }

    @Test
    fun testColorHexValueTeal200() {
        val expectedColor = Color(0xFF03DAC5)
        assertEquals(expectedColor.red, Teal200.red, 0.001f)
        assertEquals(expectedColor.green, Teal200.green, 0.001f)
        assertEquals(expectedColor.blue, Teal200.blue, 0.001f)
    }

    @Test
    fun testColorComponentsPurple200() {
        // 0xFFBB86FC
        assert(Purple200.red > 0.7f)  // BB hex ≈ 0.73
        assert(Purple200.green < 0.6f) // 86 hex ≈ 0.53
        assert(Purple200.blue > 0.9f)  // FC hex ≈ 0.99
    }

    @Test
    fun testColorComponentsPurple500() {
        // 0xFF6200EE
        assert(Purple500.red > 0.38f)  // 62 hex ≈ 0.38
        assert(Purple500.green < 0.1f) // 00 hex = 0
        assert(Purple500.blue > 0.93f) // EE hex ≈ 0.93
    }

    @Test
    fun testColorComponentsTeal200() {
        // 0xFF03DAC5
        assert(Teal200.red < 0.05f)   // 03 hex ≈ 0.01
        assert(Teal200.green > 0.85f) // DA hex ≈ 0.85
        assert(Teal200.blue > 0.77f)  // C5 hex ≈ 0.77
    }

    @Test
    fun testColorBrightnessPurple200IsBrighter() {
        val brightness200 = Purple200.red + Purple200.green + Purple200.blue
        val brightness500 = Purple500.red + Purple500.green + Purple500.blue
        assert(brightness200 > brightness500)
    }

    @Test
    fun testAllColorsDefined() {
        listOf(Purple200, Purple500, Teal200).forEach {
            assert(it != null)
            assertEquals(1f, it.alpha, 0.001f)
        }
    }
}