```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ColorTest {

    @Test
    fun `purple200 has correct color value`() {
        val expectedColor = Color(0xFFBB86FC)
        assertEquals(expectedColor, Purple200)
    }

    @Test
    fun `purple500 has correct color value`() {
        val expectedColor = Color(0xFF6200EE)
        assertEquals(expectedColor, Purple500)
    }

    @Test
    fun `purple700 has correct color value`() {
        val expectedColor = Color(0xFF3700B3)
        assertEquals(expectedColor, Purple700)
    }

    @Test
    fun `teal200 has correct color value`() {
        val expectedColor = Color(0xFF03DAC5)
        assertEquals(expectedColor, Teal200)
    }

    @Test
    fun `all colors are not null`() {
        assertNotNull(Purple200)
        assertNotNull(Purple500)
        assertNotNull(Purple700)
        assertNotNull(Teal200)
    }

    @Test
    fun `colors have valid alpha values`() {
        assertTrue(Purple200.alpha >= 0f && Purple200.alpha <= 1f)
        assertTrue(Purple500.alpha >= 0f && Purple500.alpha <= 1f)
        assertTrue(Purple700.alpha >= 0f && Purple700.alpha <= 1f)
        assertTrue(Teal200.alpha >= 0f && Teal200.alpha <= 1f)
    }

    @Test
    fun `colors have valid RGB values`() {
        // Test that RGB values are within valid range [0, 1]
        listOf(Purple200, Purple500, Purple700, Teal200).forEach { color ->
            assertTrue(color.red >= 0f && color.red <= 1f)
            assertTrue(color.green >= 0f && color.green <= 1f)
            assertTrue(color.blue >= 0f && color.blue <= 1f)
        }
    }

    @Test
    fun `purple colors form a proper gradient`() {
        // Test that purple colors form a logical gradient (darker to lighter)
        assertTrue(Purple700.luminance() < Purple500.luminance())
        assertTrue(Purple500.luminance() < Purple200.luminance())
    }

    @Test
    fun `colors are distinct`() {
        val colors = listOf(Purple200, Purple500, Purple700, Teal200)
        val uniqueColors = colors.distinct()
        assertEquals(colors.size, uniqueColors.size)
    }
}
```