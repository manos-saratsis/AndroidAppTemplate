package template.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class TypeTest {

    @Test
    fun testTypographyIsNotNull() {
        assertNotNull(Typography)
    }

    @Test
    fun testTypographyIsTypographyInstance() {
        assert(Typography is Typography)
    }

    @Test
    fun testBodyMediumIsNotNull() {
        assertNotNull(Typography.bodyMedium)
    }

    @Test
    fun testBodyMediumFontFamily() {
        assertEquals(FontFamily.Default, Typography.bodyMedium.fontFamily)
    }

    @Test
    fun testBodyMediumFontWeight() {
        assertEquals(FontWeight.Normal, Typography.bodyMedium.fontWeight)
    }

    @Test
    fun testBodyMediumFontSize() {
        assertEquals(16.sp, Typography.bodyMedium.fontSize)
    }

    @Test
    fun testBodyMediumTextStyle() {
        assert(Typography.bodyMedium is TextStyle)
    }

    @Test
    fun testBodyMediumFontSizeValue() {
        // Verify fontSize is 16.sp
        assertEquals(16.sp.value, Typography.bodyMedium.fontSize?.value ?: 0f, 0.01f)
    }

    @Test
    fun testBodyMediumFontWeightNormal() {
        // Normal weight is 400
        assertEquals(FontWeight.Normal.weight, Typography.bodyMedium.fontWeight?.weight)
    }

    @Test
    fun testTypographyConfiguration() {
        val expectedBodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        )
        assertEquals(expectedBodyMedium.fontFamily, Typography.bodyMedium.fontFamily)
        assertEquals(expectedBodyMedium.fontWeight, Typography.bodyMedium.fontWeight)
        assertEquals(expectedBodyMedium.fontSize, Typography.bodyMedium.fontSize)
    }

    @Test
    fun testBodyMediumLetterSpacing() {
        // Verify letter spacing is not null or has default value
        assertNotNull(Typography.bodyMedium.letterSpacing)
    }

    @Test
    fun testBodyMediumLineHeight() {
        // Line height should be set (either explicitly or by default)
        assertNotNull(Typography.bodyMedium.lineHeight)
    }

    @Test
    fun testBodyMediumNotBold() {
        assert(Typography.bodyMedium.fontWeight != FontWeight.Bold)
    }

    @Test
    fun testBodyMediumNotLight() {
        assert(Typography.bodyMedium.fontWeight != FontWeight.Light)
    }

    @Test
    fun testTypographyImmutability() {
        val typography1 = Typography
        val typography2 = Typography
        assertEquals(typography1.bodyMedium, typography2.bodyMedium)
    }

    @Test
    fun testBodyMediumIsDefaultFontFamily() {
        assertEquals(FontFamily.Default, Typography.bodyMedium.fontFamily)
    }

    @Test
    fun testBodyMediumFontWeightIsNormal() {
        assertEquals(FontWeight.Normal, Typography.bodyMedium.fontWeight)
    }

    @Test
    fun testBodyMediumFontSizeIs16sp() {
        assertEquals(16.sp, Typography.bodyMedium.fontSize)
    }

    @Test
    fun testTypographyHasBodyMedium() {
        assert(Typography.bodyMedium != null)
    }

    @Test
    fun testBodyMediumCompleteStyle() {
        val style = Typography.bodyMedium
        assertNotNull(style.fontFamily)
        assertNotNull(style.fontWeight)
        assertNotNull(style.fontSize)
    }

    @Test
    fun testBodyMediumFontSizeIsNotZero() {
        assert((Typography.bodyMedium.fontSize?.value ?: 0f) > 0)
    }

    @Test
    fun testMultipleAccessToTypographyReturnsConsistentValue() {
        val access1 = Typography.bodyMedium
        val access2 = Typography.bodyMedium
        assertEquals(access1.fontFamily, access2.fontFamily)
        assertEquals(access1.fontWeight, access2.fontWeight)
        assertEquals(access1.fontSize, access2.fontSize)
    }
}