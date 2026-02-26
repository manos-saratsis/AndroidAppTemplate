package template.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TypeTest {

    @Test
    fun testTypographyIsNotNull() {
        assert(Typography != null)
    }

    @Test
    fun testTypographyIsInstance() {
        assert(Typography is Typography)
    }

    @Test
    fun testBodyMediumStyleExists() {
        assert(Typography.bodyMedium != null)
    }

    @Test
    fun testBodyMediumHasDefaultFontFamily() {
        assert(Typography.bodyMedium.fontFamily == FontFamily.Default)
    }

    @Test
    fun testBodyMediumHasNormalFontWeight() {
        assert(Typography.bodyMedium.fontWeight == FontWeight.Normal)
    }

    @Test
    fun testBodyMediumHasCorrectFontSize() {
        assert(Typography.bodyMedium.fontSize == 16.sp)
    }

    @Test
    fun testBodyMediumFontSizeIsPositive() {
        assert(Typography.bodyMedium.fontSize.value > 0)
    }

    @Test
    fun testBodyMediumFontSizeUnit() {
        assert(Typography.bodyMedium.fontSize.value == 16f)
    }

    @Test
    fun testTypographyBodyMediumTextStyle() {
        val expectedStyle = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        )
        
        assert(Typography.bodyMedium.fontFamily == expectedStyle.fontFamily)
        assert(Typography.bodyMedium.fontWeight == expectedStyle.fontWeight)
        assert(Typography.bodyMedium.fontSize == expectedStyle.fontSize)
    }

    @Test
    fun testBodyMediumHasDefaultLetterSpacing() {
        // TextStyle has default letter spacing
        assert(Typography.bodyMedium.letterSpacing.value == 0.5f)
    }

    @Test
    fun testBodyMediumHasDefaultLineHeight() {
        // TextStyle has default line height
        assert(Typography.bodyMedium.lineHeight.value > 0)
    }

    @Test
    fun testBodyMediumFontWeightIsNot Bold() {
        assert(Typography.bodyMedium.fontWeight != FontWeight.Bold)
    }

    @Test
    fun testBodyMediumFontWeightIsNot SemiBold() {
        assert(Typography.bodyMedium.fontWeight != FontWeight.SemiBold)
    }

    @Test
    fun testBodyMediumFontWeightValue() {
        assert(Typography.bodyMedium.fontWeight == FontWeight.Normal)
        assert(Typography.bodyMedium.fontWeight.weight == 400)
    }

    @Test
    fun testBodyMediumFontSizeEqualityComparison() {
        val fontSize16 = 16.sp
        assert(Typography.bodyMedium.fontSize == fontSize16)
    }

    @Test
    fun testBodyMediumFontFamilyIsDefault() {
        assert(Typography.bodyMedium.fontFamily == FontFamily.Default)
    }

    @Test
    fun testTypographyCanBeReused() {
        val firstRef = Typography
        val secondRef = Typography
        
        assert(firstRef === secondRef)
    }
}