package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ShapeTest {

    @Test
    fun `Shapes should be initialized`() {
        // Arrange & Act
        val shapes = Shapes

        // Assert
        assertNotNull(shapes)
    }

    @Test
    fun `Shapes small should be RoundedCornerShape with 4dp`() {
        // Arrange & Act
        val small = Shapes.small

        // Assert
        assertNotNull(small)
        assertTrue(small is RoundedCornerShape)
    }

    @Test
    fun `Shapes medium should be RoundedCornerShape with 4dp`() {
        // Arrange & Act
        val medium = Shapes.medium

        // Assert
        assertNotNull(medium)
        assertTrue(medium is RoundedCornerShape)
    }

    @Test
    fun `Shapes large should be RoundedCornerShape with 0dp`() {
        // Arrange & Act
        val large = Shapes.large

        // Assert
        assertNotNull(large)
        assertTrue(large is RoundedCornerShape)
    }

    @Test
    fun `Shapes should have all required shape properties`() {
        // Arrange & Act
        val shapes = Shapes

        // Assert
        assertNotNull(shapes.small)
        assertNotNull(shapes.medium)
        assertNotNull(shapes.large)
        assertNotNull(shapes.extraSmall)
        assertNotNull(shapes.extraLarge)
    }

    @Test
    fun `Shapes should be immutable singleton`() {
        // Arrange
        val shapes1 = Shapes
        val shapes2 = Shapes

        // Act & Assert
        assertEquals(shapes1, shapes2)
        assert(shapes1 === shapes2)
    }

    @Test
    fun `small and medium shapes should be equal`() {
        // Arrange & Act
        val small = Shapes.small
        val medium = Shapes.medium

        // Assert
        assertEquals(small, medium)
    }

    @Test
    fun `small and large shapes should be different`() {
        // Arrange & Act
        val small = Shapes.small
        val large = Shapes.large

        // Assert
        assert(small != large)
    }

    @Test
    fun `Shapes should be accessible from multiple threads`() {
        // Arrange
        val results = mutableListOf<androidx.compose.material3.Shapes>()

        // Act
        val threads = List(10) {
            Thread {
                results.add(Shapes)
            }
        }
        threads.forEach { it.start() }
        threads.forEach { it.join() }

        // Assert
        assertEquals(10, results.size)
        results.forEach { assertEquals(Shapes, it) }
    }
}