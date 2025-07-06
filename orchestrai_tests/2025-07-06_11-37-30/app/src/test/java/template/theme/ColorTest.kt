```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ColorTest {

    @Before
    fun setUp() {
        // Setup any required test data
    }

    @Test
    fun purple200_color_value() {
        val expectedArgb = 0xFFBB86FC.toInt()
        assertEquals(expectedArgb, Purple200.toArgb())
    }

    @Test
    fun purple500_color_value() {
        val expectedArgb = 0xFF6200EE.toInt()
        assertEquals(expectedArgb, Purple500.toArgb())
    }

    @Test
    fun purple700_color_value() {
        val expectedArgb = 0xFF3700B3.toInt()
        assertEquals(expectedArgb, Purple700.toArgb())
    }

    @Test
    fun teal200_color_value() {
        val expectedArgb = 0xFF03DAC5.toInt()
        assertEquals(expectedArgb, Teal200.toArgb())
    }

    @Test
    fun colors_are_not_null() {
        assertNotNull(Purple200)
        assertNotNull(Purple500)
        assertNotNull(Purple700)
        assertNotNull(Teal200)
    }

    @Test
    fun colors_are_different() {
        assertNotEquals(Purple200, Purple500)
        assertNotEquals(Purple500, Purple700)
        assertNotEquals(Purple700, Teal200)
        assertNotEquals(Purple200, Teal200)
    }

    @Test
    fun color_alpha_values() {
        assertEquals(1.0f, Purple200.alpha, 0.01f)
        assertEquals(1.0f, Purple500.alpha, 0.01f)
        assertEquals(1.0f, Purple700.alpha, 0.01f)
        assertEquals(1.0f, Teal200.alpha, 0.01f)
    }

    @Test
    fun color_components_within_range() {
        assertTrue("Purple200 red component", Purple200.red in 0.0f..1.0f)
        assertTrue("Purple200 green component", Purple200.green in 0.0f..1.0f)
        assertTrue("Purple200 blue component", Purple200.blue in 0.0f..1.0f)
        
        assertTrue("Purple500 red component", Purple500.red in 0.0f..1.0f)
        assertTrue("Purple500 green component", Purple500.green in 0.0f..1.0f)
        assertTrue("Purple500 blue component", Purple500.blue in 0.0f..1.0f)
        
        assertTrue("Purple700 red component", Purple700.red in 0.0f..1.0f)
        assertTrue("Purple700 green component", Purple700.green in 0.0f..1.0f)
        assertTrue("Purple700 blue component", Purple700.blue in 0.0f..1.0f)
        
        assertTrue("Teal200 red component", Teal200.red in 0.0f..1.0f)
        assertTrue("Teal200 green component", Teal200.green in 0.0f..1.0f)
        assertTrue("Teal200 blue component", Teal200.blue in 0.0f..1.0f)
    }

    @Test
    fun color_string_representation() {
        assertTrue(Purple200.toString().contains("Color"))
        assertTrue(Purple500.toString().contains("Color"))
        assertTrue(Purple700.toString().contains("Color"))
        assertTrue(Teal200.toString().contains("Color"))
    }
}
```