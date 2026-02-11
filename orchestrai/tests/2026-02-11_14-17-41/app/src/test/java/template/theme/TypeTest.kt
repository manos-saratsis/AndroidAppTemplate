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
    fun testTypographyDefined() {
        // Verify Typography is defined
        assert(Typography != null)
    }

    @Test
    fun testTypographyIsTypographyInstance() {
        // Verify Typography is instance of Material3 Typography
        assert(Typography is Typography)
    }

    @Test
    fun testBodyMediumDefined() {
        // Verify bodyMedium style is defined in Typography
        assert(Typography.bodyMedium != null)
    }

    @Test
    fun testBodyMediumIsTextStyle() {
        // Verify bodyMedium is a TextStyle
        assert(Typography.bodyMedium is TextStyle)
    }

    @Test
    fun testBodyMediumFontFamily() {
        // Verify bodyMedium uses default font family
        assert(Typography.bodyMedium.fontFamily == FontFamily.Default)
    }

    @Test
    fun testBodyMediumFontWeight() {
        // Verify bodyMedium has normal font weight
        assert(Typography.bodyMedium.fontWeight == FontWeight.Normal)
    }

    @Test
    fun testBodyMediumFontSize() {
        // Verify bodyMedium has 16sp font size
        assert(Typography.bodyMedium.fontSize == 16.sp)
    }

    @Test
    fun testBodyMediumFontSizeValue() {
        // Verify exact font size value
        val expectedSize = 16.sp
        assert(Typography.bodyMedium.fontSize == expectedSize)
    }

    @Test
    fun testBodyMediumProperties() {
        val bodyMedium = Typography.bodyMedium
        
        // Verify all properties in one test
        assert(bodyMedium.fontFamily == FontFamily.Default)
        assert(bodyMedium.fontWeight == FontWeight.Normal)
        assert(bodyMedium.fontSize == 16.sp)
    }

    @Test
    fun testTypographyDisplayLarge() {
        // Verify other typography styles exist (inherited from Material3)
        assert(Typography.displayLarge != null)
    }

    @Test
    fun testTypographyDisplayMedium() {
        // Verify displayMedium exists
        assert(Typography.displayMedium != null)
    }

    @Test
    fun testTypographyDisplaySmall() {
        // Verify displaySmall exists
        assert(Typography.displaySmall != null)
    }

    @Test
    fun testTypographyHeadlineLarge() {
        // Verify headlineLarge exists
        assert(Typography.headlineLarge != null)
    }

    @Test
    fun testTypographyHeadlineMedium() {
        // Verify headlineMedium exists
        assert(Typography.headlineMedium != null)
    }

    @Test
    fun testTypographyHeadlineSmall() {
        // Verify headlineSmall exists
        assert(Typography.headlineSmall != null)
    }

    @Test
    fun testTypographyTitleLarge() {
        // Verify titleLarge exists
        assert(Typography.titleLarge != null)
    }

    @Test
    fun testTypographyTitleMedium() {
        // Verify titleMedium exists
        assert(Typography.titleMedium != null)
    }

    @Test
    fun testTypographyTitleSmall() {
        // Verify titleSmall exists
        assert(Typography.titleSmall != null)
    }

    @Test
    fun testTypographyBodyLarge() {
        // Verify bodyLarge exists
        assert(Typography.bodyLarge != null)
    }

    @Test
    fun testTypographyBodySmall() {
        // Verify bodySmall exists
        assert(Typography.bodySmall != null)
    }

    @Test
    fun testTypographyLabelLarge() {
        // Verify labelLarge exists
        assert(Typography.labelLarge != null)
    }

    @Test
    fun testTypographyLabelMedium() {
        // Verify labelMedium exists
        assert(Typography.labelMedium != null)
    }

    @Test
    fun testTypographyLabelSmall() {
        // Verify labelSmall exists
        assert(Typography.labelSmall != null)
    }

    @Test
    fun testTypographyConstistency() {
        // Verify Typography object is consistent across calls
        val type1 = Typography
        val type2 = Typography
        assert(type1 === type2) // Same reference
    }

    @Test
    fun testBodyMediumFontWeightIsNormal() {
        // Verify font weight is specifically Normal, not Bold or other
        val fontWeight = Typography.bodyMedium.fontWeight
        assert(fontWeight == FontWeight.Normal)
    }

    @Test
    fun testBodyMediumFontSizeIsPositive() {
        // Verify font size is positive
        assert(Typography.bodyMedium.fontSize.value > 0)
    }

    @Test
    fun testTypographyAllStylesNonNull() {
        // Verify all typography styles are defined
        val allStyles = listOf(
            Typography.displayLarge,
            Typography.displayMedium,
            Typography.displaySmall,
            Typography.headlineLarge,
            Typography.headlineMedium,
            Typography.headlineSmall,
            Typography.titleLarge,
            Typography.titleMedium,
            Typography.titleSmall,
            Typography.bodyLarge,
            Typography.bodyMedium,
            Typography.bodySmall,
            Typography.labelLarge,
            Typography.labelMedium,
            Typography.labelSmall
        )
        
        assert(allStyles.all { it != null })
    }
}