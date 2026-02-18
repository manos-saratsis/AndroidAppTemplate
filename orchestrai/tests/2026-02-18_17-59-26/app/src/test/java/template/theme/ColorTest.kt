package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class ColorTest {

    @Test
    fun `Purple200 should be initialized with correct color value`() {
        // Arrange & Act
        val color = Purple200

        // Assert
        assertNotNull(color)
        assertEquals(Color(0xFFBB86FC), color)
    }

    @Test
    fun `Purple200 should have correct ARGB components`() {
        // Arrange & Act
        val color = Purple200

        // Assert
        assertEquals(1.0f, color.alpha, 0.01f)
        assertEquals(0xBB / 255f, color.red, 0.01f)
        assertEquals(0x86 / 255f, color.green, 0.01f)
        assertEquals(0xFC / 255f, color.blue, 0.01f)
    }

    @Test
    fun `Purple500 should be initialized with correct color value`() {
        // Arrange & Act
        val color = Purple500

        // Assert
        assertNotNull(color)
        assertEquals(Color(0xFF6200EE), color)
    }

    @Test
    fun `Purple500 should have correct ARGB components`() {
        // Arrange & Act
        val color = Purple500

        // Assert
        assertEquals(1.0f, color.alpha, 0.01f)
        assertEquals(0x62 / 255f, color.red, 0.01f)
        assertEquals(0x00 / 255f, color.green, 0.01f)
        assertEquals(0xEE / 255f, color.blue, 0.01f)
    }

    @Test
    fun `Teal200 should be initialized with correct color value`() {
        // Arrange & Act
        val color = Teal200

        // Assert
        assertNotNull(color)
        assertEquals(Color(0xFF03DAC5), color)
    }

    @Test
    fun `Teal200 should have correct ARGB components`() {
        // Arrange & Act
        val color = Teal200

        // Assert
        assertEquals(1.0f, color.alpha, 0.01f)
        assertEquals(0x03 / 255f, color.red, 0.01f)
        assertEquals(0xDA / 255f, color.green, 0.01f)
        assertEquals(0xC5 / 255f, color.blue, 0.01f)
    }

    @Test
    fun `all colors should be opaque`() {
        // Arrange & Act & Assert
        assertEquals(1.0f, Purple200.alpha, 0.01f)
        assertEquals(1.0f, Purple500.alpha, 0.01f)
        assertEquals(1.0f, Teal200.alpha, 0.01f)
    }

    @Test
    fun `all colors should be distinct`() {
        // Arrange & Act & Assert
        assert(Purple200 != Purple500)
        assert(Purple200 != Teal200)
        assert(Purple500 != Teal200)
    }

    @Test
    fun `Purple200 should be immutable`() {
        // Arrange
        val color1 = Purple200
        val color2 = Purple200

        // Act & Assert
        assertEquals(color1, color2)
        assert(color1 === color2)
    }

    @Test
    fun `Purple500 should be immutable`() {
        // Arrange
        val color1 = Purple500
        val color2 = Purple500

        // Act & Assert
        assertEquals(color1, color2)
        assert(color1 === color2)
    }

    @Test
    fun `Teal200 should be immutable`() {
        // Arrange
        val color1 = Teal200
        val color2 = Teal200

        // Act & Assert
        assertEquals(color1, color2)
        assert(color1 === color2)
    }
}