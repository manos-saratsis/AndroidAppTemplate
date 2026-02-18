package template.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class TypeTest {

    @Test
    fun `Typography should be initialized`() {
        // Arrange & Act
        val typography = Typography

        // Assert
        assertNotNull(typography)
    }

    @Test
    fun `Typography bodyMedium should have correct fontFamily`() {
        // Arrange & Act
        val bodyMedium = Typography.bodyMedium

        // Assert
        assertNotNull(bodyMedium)
        assertEquals(FontFamily.Default, bodyMedium.fontFamily)
    }

    @Test
    fun `Typography bodyMedium should have correct fontWeight`() {
        // Arrange & Act
        val bodyMedium = Typography.bodyMedium

        // Assert
        assertEquals(FontWeight.Normal, bodyMedium.fontWeight)
    }

    @Test
    fun `Typography bodyMedium should have correct fontSize`() {
        // Arrange & Act
        val bodyMedium = Typography.bodyMedium

        // Assert
        assertEquals(16.sp, bodyMedium.fontSize)
    }

    @Test
    fun `Typography bodyMedium should have all properties set correctly`() {
        // Arrange & Act
        val bodyMedium = Typography.bodyMedium

        // Assert
        assertEquals(FontFamily.Default, bodyMedium.fontFamily)
        assertEquals(FontWeight.Normal, bodyMedium.fontWeight)
        assertEquals(16.sp, bodyMedium.fontSize)
    }

    @Test
    fun `Typography should have bodyMedium defined`() {
        // Arrange & Act
        val typography = Typography

        // Assert
        assertNotNull(typography.bodyMedium)
    }

    @Test
    fun `Typography should have all default text styles`() {
        // Arrange & Act
        val typography = Typography

        // Assert
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
    fun `Typography should be immutable singleton`() {
        // Arrange
        val typography1 = Typography
        val typography2 = Typography

        // Act & Assert
        assertEquals(typography1, typography2)
        assert(typography1 === typography2)
    }

    @Test
    fun `Typography bodyMedium should use Normal fontWeight not Bold`() {
        // Arrange & Act
        val bodyMedium = Typography.bodyMedium

        // Assert
        assertEquals(FontWeight.Normal, bodyMedium.fontWeight)
        assert(bodyMedium.fontWeight != FontWeight.Bold)
    }

    @Test
    fun `Typography bodyMedium fontSize should be 16sp not other values`() {
        // Arrange & Act
        val bodyMedium = Typography.bodyMedium

        // Assert
        assertEquals(16.sp, bodyMedium.fontSize)
        assert(bodyMedium.fontSize != 14.sp)
        assert(bodyMedium.fontSize != 18.sp)
    }

    @Test
    fun `Typography should be accessible from multiple threads`() {
        // Arrange
        val results = mutableListOf<androidx.compose.material3.Typography>()

        // Act
        val threads = List(10) {
            Thread {
                results.add(Typography)
            }
        }
        threads.forEach { it.start() }
        threads.forEach { it.join() }

        // Assert
        assertEquals(10, results.size)
        results.forEach { assertEquals(Typography, it) }
    }

    @Test
    fun `Typography bodyMedium should have Default fontFamily not other families`() {
        // Arrange & Act
        val bodyMedium = Typography.bodyMedium

        // Assert
        assertEquals(FontFamily.Default, bodyMedium.fontFamily)
        assert(bodyMedium.fontFamily != FontFamily.Serif)
        assert(bodyMedium.fontFamily != FontFamily.SansSerif)
        assert(bodyMedium.fontFamily != FontFamily.Monospace)
        assert(bodyMedium.fontFamily != FontFamily.Cursive)
    }
}