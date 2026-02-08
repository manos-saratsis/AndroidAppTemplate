package template.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class TypeTest {

    @Test
    fun testTypographyIsNotNull() {
        assertNotNull(Typography)
    }

    @Test
    fun testTypographyBodyMediumIsNotNull() {
        assertNotNull(Typography.bodyMedium)
    }

    @Test
    fun testTypographyBodyMediumHasDefaultFontFamily() {
        assertEquals(FontFamily.Default, Typography.bodyMedium.fontFamily)
    }

    @Test
    fun testTypographyBodyMediumHasNormalFontWeight() {
        assertEquals(FontWeight.Normal, Typography.bodyMedium.fontWeight)
    }

    @Test
    fun testTypographyBodyMediumHasSixteenSpFontSize() {
        assertEquals(16.sp, Typography.bodyMedium.fontSize)
    }

    @Test
    fun testTypographyBodyMediumFontSizeIsCorrectValue() {
        // Verify font size value is exactly 16
        assertEquals(16, Typography.bodyMedium.fontSize.value.toInt())
    }

    @Test
    fun testTypographyBodyMediumIsTextStyle() {
        assert(Typography.bodyMedium is TextStyle)
    }

    @Test
    fun testTypographyIsTypographyInstance() {
        assert(Typography is Typography)
    }

    @Test
    fun testBodyMediumFontWeightIsNotBold() {
        assert(Typography.bodyMedium.fontWeight != FontWeight.Bold)
    }

    @Test
    fun testBodyMediumFontWeightValue() {
        // FontWeight.Normal has value 400
        assertEquals(400, Typography.bodyMedium.fontWeight?.weight)
    }

    @Test
    fun testBodyMediumFontSizeUnit() {
        // Font size is in SP (scale-independent pixels)
        assert(Typography.bodyMedium.fontSize.toString().contains("sp"))
    }

    @Test
    fun testTypographyObjectCreation() {
        val typography = Typography(
            bodyMedium = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            ),
        )
        assertNotNull(typography)
    }

    @Test
    fun testTypographyDefaultBodyMediumTextStyle() {
        val textStyle = Typography.bodyMedium
        assertEquals(FontFamily.Default, textStyle.fontFamily)
        assertEquals(FontWeight.Normal, textStyle.fontWeight)
        assertEquals(16.sp, textStyle.fontSize)
    }

    @Test
    fun testBodyMediumFontFamilyIsDefault() {
        // FontFamily.Default should be used
        assert(Typography.bodyMedium.fontFamily == FontFamily.Default)
    }

    @Test
    fun testTypographyBodyMediumFontSizeGreaterThanZero() {
        assert(Typography.bodyMedium.fontSize.value > 0)
    }

    @Test
    fun testTypographyBodyMediumCanBeModified() {
        val modifiedStyle = Typography.bodyMedium.copy(fontSize = 18.sp)
        assertEquals(18.sp, modifiedStyle.fontSize)
    }

    @Test
    fun testTypographyBodyMediumOriginalUnchanged() {
        // Original should remain 16.sp
        assertEquals(16.sp, Typography.bodyMedium.fontSize)
    }

    @Test
    fun testTypographyBodyMediumTextStyleProperties() {
        val style = Typography.bodyMedium
        assertNotNull(style.fontFamily)
        assertNotNull(style.fontWeight)
        assertNotNull(style.fontSize)
    }

    @Test
    fun testTypographyBodyMediumEqualsItself() {
        assertEquals(Typography.bodyMedium, Typography.bodyMedium)
    }

    @Test
    fun testMultipleTypographyInstancesWithSameValues() {
        val typography1 = Typography(
            bodyMedium = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            ),
        )
        val typography2 = Typography(
            bodyMedium = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            ),
        )
        assertEquals(typography1.bodyMedium, typography2.bodyMedium)
    }
}