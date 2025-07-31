```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ColorTest {

    @Before
    fun setup() {
        // Setup any required test data
    }

    @Test
    fun purple200_has_correct_value() {
        val expectedColor = Color(0xFFBB86FC)
        assertEquals(expectedColor, Purple200)
    }

    @Test
    fun purple500_has_correct_value() {
        val expectedColor = Color(0xFF6200EE)
        assertEquals(expectedColor, Purple500)
    }

    @Test
    fun purple700_has_correct_value() {
        val expectedColor = Color(0xFF3700B3)
        assertEquals(expectedColor, Purple700)
    }

    @Test
    fun teal200_has_correct_value() {
        val expectedColor = Color(0xFF03DAC5)
        assertEquals(expectedColor, Teal200)
    }

    @Test
    fun colors_are_not_null() {
        assertNotNull(Purple200)
        assertNotNull(Purple500)
        assertNotNull(Purple700)
        assertNotNull(Teal200)
    }

    @Test
    fun colors_have_valid_alpha_values() {
        assertTrue(Purple200.alpha >= 0f && Purple200.alpha <= 1f)
        assertTrue(Purple500.alpha >= 0f && Purple500.alpha <= 1f)
        assertTrue(Purple700.alpha >= 0f && Purple700.alpha <= 1f)
        assertTrue(Teal200.alpha >= 0f && Teal200.alpha <= 1f)
    }

    @Test
    fun colors_have_valid_rgb_values() {
        // Test that RGB values are within valid range (0-1)
        assertTrue(Purple200.red >= 0f && Purple200.red <= 1f)
        assertTrue(Purple200.green >= 0f && Purple200.green <= 1f)
        assertTrue(Purple200.blue >= 0f && Purple200.blue <= 1f)
        
        assertTrue(Purple500.red >= 0f && Purple500.red <= 1f)
        assertTrue(Purple500.green >= 0f && Purple500.green <= 1f)
        assertTrue(Purple500.blue >= 0f && Purple500.blue <= 1f)
    }

    @Test
    fun purple_colors_are_different_shades() {
        assertNotEquals(Purple200, Purple500)
        assertNotEquals(Purple500, Purple700)
        assertNotEquals(Purple200, Purple700)
    }

    @Test
    fun teal_color_is_distinct_from_purple() {
        assertNotEquals(Teal200, Purple200)
        assertNotEquals(Teal200, Purple500)
        assertNotEquals(Teal200, Purple700)
    }
}
```