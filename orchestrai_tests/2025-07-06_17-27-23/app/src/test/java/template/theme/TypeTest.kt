```kotlin
package template.theme

import androidx.compose.material.Typography
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
    fun `typography object is not null`() {
        assertNotNull(Typography)
    }

    @Test
    fun `typography has correct default font family`() {
        val typography = Typography()
        assertEquals(FontFamily.Default, typography.defaultFontFamily)
    }

    @Test
    fun `typography h1 has correct properties`() {
        val typography = Typography()
        val h1Style = typography.h1
        
        assertNotNull(h1Style)
        assertEquals(96.sp, h1Style.fontSize)
        assertEquals(FontWeight.Light, h1Style.fontWeight)
    }

    @Test
    fun `typography h2 has correct properties`() {
        val typography = Typography()
        val h2Style = typography.h2
        
        assertNotNull(h2Style)
        assertEquals(60.sp, h2Style.fontSize)
        assertEquals(FontWeight.Light, h2Style.fontWeight)
    }

    @Test
    fun `typography h3 has correct properties`() {
        val typography = Typography()
        val h3Style = typography.h3
        
        assertNotNull(h3Style)
        assertEquals(48.sp, h3Style.fontSize)
        assertEquals(FontWeight.Normal, h3Style.fontWeight)
    }

    @Test
    fun `typography h4 has correct properties`() {
        val typography = Typography()
        val h4Style = typography.h4
        
        assertNotNull(h4Style)
        assertEquals(34.sp