package template.theme

import androidx.compose.ui.graphics.Color
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ColorTest {

    @Test
    fun testPurple200ColorValue() {
        val expectedColor = Color(0xFFBB86FC)
        assert(Purple200 == expectedColor)
    }

    @Test
    fun testPurple200IsValidColor() {
        assert(Purple200 != null)
        assert(Purple200.red > 0)
        assert(Purple200.green > 0)
        assert(Purple200.blue > 0)
        assert(Purple200.alpha > 0)
    }

    @Test
    fun testPurple500ColorValue() {
        val expectedColor = Color(0xFF6200EE)
        assert(Purple500 == expectedColor)
    }

    @Test
    fun testPurple500IsValidColor() {
        assert(Purple500 != null)
        assert(Purple500.red > 0)
        assert(Purple500.green == 0)
        assert(Purple500.blue > 0)
        assert(Purple500.alpha > 0)
    }

    @Test
    fun testTeal200ColorValue() {
        val expectedColor = Color(0xFF03DAC5)
        assert(Teal200 == expectedColor)
    }

    @Test
    fun testTeal200IsValidColor() {
        assert(Teal200 != null)
        assert(Teal200.red > 0)
        assert(Teal200.green > 0)
        assert(Teal200.blue > 0)
        assert(Teal200.alpha > 0)
    }

    @Test
    fun testPurple200AndPurple500AreNotEqual() {
        assert(Purple200 != Purple500)
    }

    @Test
    fun testPurple200AndTeal200AreNotEqual() {
        assert(Purple200 != Teal200)
    }

    @Test
    fun testPurple500AndTeal200AreNotEqual() {
        assert(Purple500 != Teal200)
    }

    @Test
    fun testAllColorsHaveFullAlpha() {
        assert(Purple200.alpha == 1.0f)
        assert(Purple500.alpha == 1.0f)
        assert(Teal200.alpha == 1.0f)
    }

    @Test
    fun testPurple200HexValue() {
        // 0xFFBB86FC in ARGB: FF=alpha, BB=red, 86=green, FC=blue
        val expectedRed = 0xBB.toFloat() / 255.0f
        val expectedGreen = 0x86.toFloat() / 255.0f
        val expectedBlue = 0xFC.toFloat() / 255.0f
        
        assert(Purple200.red > expectedRed - 0.01f && Purple200.red < expectedRed + 0.01f)
        assert(Purple200.green > expectedGreen - 0.01f && Purple200.green < expectedGreen + 0.01f)
        assert(Purple200.blue > expectedBlue - 0.01f && Purple200.blue < expectedBlue + 0.01f)
    }

    @Test
    fun testPurple500HexValue() {
        // 0xFF6200EE in ARGB: FF=alpha, 62=red, 00=green, EE=blue
        val expectedRed = 0x62.toFloat() / 255.0f
        val expectedGreen = 0x00.toFloat() / 255.0f
        val expectedBlue = 0xEE.toFloat() / 255.0f
        
        assert(Purple500.red > expectedRed - 0.01f && Purple500.red < expectedRed + 0.01f)
        assert(Purple500.green == expectedGreen)
        assert(Purple500.blue > expectedBlue - 0.01f && Purple500.blue < expectedBlue + 0.01f)
    }

    @Test
    fun testTeal200HexValue() {
        // 0xFF03DAC5 in ARGB: FF=alpha, 03=red, DA=green, C5=blue
        val expectedRed = 0x03.toFloat() / 255.0f
        val expectedGreen = 0xDA.toFloat() / 255.0f
        val expectedBlue = 0xC5.toFloat() / 255.0f
        
        assert(Teal200.red > expectedRed - 0.01f && Teal200.red < expectedRed + 0.01f)
        assert(Teal200.green > expectedGreen - 0.01f && Teal200.green < expectedGreen + 0.01f)
        assert(Teal200.blue > expectedBlue - 0.01f && Teal200.blue < expectedBlue + 0.01f)
    }

    @Test
    fun testColorComponentRanges() {
        // All color components should be between 0.0 and 1.0
        assert(Purple200.red in 0.0f..1.0f)
        assert(Purple200.green in 0.0f..1.0f)
        assert(Purple200.blue in 0.0f..1.0f)
        assert(Purple200.alpha in 0.0f..1.0f)

        assert(Purple500.red in 0.0f..1.0f)
        assert(Purple500.green in 0.0f..1.0f)
        assert(Purple500.blue in 0.0f..1.0f)
        assert(Purple500.alpha in 0.0f..1.0f)

        assert(Teal200.red in 0.0f..1.0f)
        assert(Teal200.green in 0.0f..1.0f)
        assert(Teal200.blue in 0.0f..1.0f)
        assert(Teal200.alpha in 0.0f..1.0f)
    }
}