```kotlin
package template.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.junit.Assert.*
import org.junit.Test

class TypeTest {

    @Test
    fun testTypographyNotNull() {
        val typography = Typography()
        assertNotNull(typography)
    }

    @Test
    fun testTypographyStyles() {
        val typography = Typography()
        
        // Test that all typography styles are defined
        assertNotNull(typography.displayLarge)
        assertNotNull(typography.displayMedium)
        assertNotNull(typography.displaySmall)
        assertNotNull(typography.headlineLarge)
        assertNotNull(typography.headlineMedium)
        assertNotNull(typography.headlineSmall)
        assertNotNull(typography.titleLarge)
        assertNotNull(typography.titleMedium)
        assertNotNull(typography.titleSmall)
        assertNotNull(typography.bodyLarge)
        assertNotNull(typography.bodyMedium)
        assertNotNull(typography.bodySmall)
        assertNotNull(typography.labelLarge)
        assertNotNull(typography.labelMedium)
        assertNotNull(typography.labelSmall)
    }

    @Test
    fun testCustomTextStyle() {
        val customStyle = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
        
        assertNotNull(customStyle)
        assertEquals(FontFamily.Default, customStyle.fontFamily)
        assertEquals(FontWeight.Normal, customStyle.fontWeight)
        assertEquals(16.sp, customStyle.fontSize)
    }

    @Test
    fun testFontWeights() {
        val lightStyle = TextStyle(fontWeight = FontWeight.Light)
        val normalStyle = TextStyle(fontWeight = FontWeight.Normal)
        val mediumStyle = TextStyle(fontWeight = FontWeight.Medium)
        val boldStyle = TextStyle(fontWeight = FontWeight.Bold)
        
        assertNotNull(lightStyle)
        assertNotNull(normalStyle)
        assertNotNull(mediumStyle)
        assertNotNull(boldStyle)
        
        assertEquals(FontWeight.Light, lightStyle.fontWeight)
        assertEquals(FontWeight.Normal, normalStyle.fontWeight)
        assertEquals(FontWeight.Medium, mediumStyle.fontWeight)
        assertEquals(FontWeight.Bold, boldStyle.fontWeight)
    }

    @Test
    fun testFontSizes() {
        val smallText = TextStyle(fontSize = 12.sp)