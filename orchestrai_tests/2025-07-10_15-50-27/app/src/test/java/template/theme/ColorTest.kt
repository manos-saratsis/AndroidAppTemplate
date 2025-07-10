```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ColorTest {

    @Before
    fun setUp() {
        // Setup any required test data
    }

    @Test
    fun purple200_has_correct_value() {
        val expectedColor = Color(0xFFBB86FC)
        assertEquals("Purple200 should have correct color value", expectedColor, Purple200)
    }

    @Test
    fun purple500_has_correct_value() {
        val expectedColor = Color(0xFF6200EE)
        assertEquals("Purple500 should have correct color value", expectedColor, Purple500)
    }

    @Test
    fun purple700_has_correct_value() {
        val expectedColor = Color(0xFF3700B3)
        assertEquals("Purple700 should have correct color value", expectedColor, Purple700)
    }

    @Test
    fun teal200_has_correct_value() {
        val expectedColor = Color(0xFF03DAC5)
        assertEquals("Teal200 should have correct color value", expectedColor, Teal200)
    }

    @Test
    fun colors_are_not_null() {
        assertNotNull("Purple200 should not be null", Purple200)
        assertNotNull("Purple500 should not be null", Purple500)
        assertNotNull("Purple700 should not be null", Purple700)
        assertNotNull("Teal200 should not be null", Teal200)
    }

    @Test
    fun colors_have_alpha_channel() {
        assertTrue("Purple200 should have alpha channel", Purple200.alpha > 0f)
        assertTrue("Purple500 should have alpha channel", Purple500.alpha > 0f)
        assertTrue("Purple700 should have alpha channel", Purple700.alpha > 0f)
        assertTrue("Teal200 should have alpha channel", Teal200.alpha > 0f)
    }

    @Test
    fun colors_are_opaque() {
        assertEquals("Purple200 should be opaque", 1.0f, Purple200.alpha, 0.01f)
        assertEquals("Purple500 should be opaque", 1.0f, Purple500.alpha, 0.01f)
        assertEquals("Purple700 should be opaque", 1.0f, Purple700.alpha, 0.01f)
        assertEquals("Teal200 should be opaque", 1.0f, Teal200.alpha, 0.01f)
    }

    @Test
    fun purple_colors_have_different_values() {
        assertNotEquals("Purple200 and Purple500 should be different", Purple200, Purple500)
        assertNotEquals("Purple500 and Purple700 should be different", Purple500, Purple700)
        assertNotEquals("Purple200 and Purple700 should be different", Purple200, Purple700)
    }

    @Test
    fun teal_and_purple_colors_are_different() {
        assertNotEquals("Teal200 and Purple200 should be different", Teal200, Purple200)
        assertNotEquals("Teal200 and Purple500 should be different", Teal200, Purple500)
        assertNotEquals("Teal200 and Purple700 should be different", Teal200, Purple700)
    }
}
```