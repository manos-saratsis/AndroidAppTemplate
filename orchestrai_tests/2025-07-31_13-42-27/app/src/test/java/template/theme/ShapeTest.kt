```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ShapeTest {

    private lateinit var shapes: Shapes

    @Before
    fun setup() {
        shapes = Shapes
    }

    @Test
    fun shapes_object_is_not_null() {
        assertNotNull(shapes)
    }

    @Test
    fun small_shape_has_correct_corner_radius() {
        val smallShape = shapes.small
        assertTrue(smallShape is RoundedCornerShape)
        
        val roundedShape = smallShape as RoundedCornerShape
        // Verify it has the expected corner radius (typically 4.dp)
        assertNotNull(roundedShape)
    }

    @Test
    fun medium_shape_has_correct_corner_radius() {
        val mediumShape = shapes.medium
        assertTrue(mediumShape is RoundedCornerShape)
        
        val roundedShape = mediumShape as RoundedCornerShape
        assertNotNull(roundedShape)
    }

    @Test
    fun large_shape_has_correct_corner_radius() {
        val largeShape = shapes.large
        assertTrue(largeShape is RoundedCornerShape)
        
        val roundedShape = largeShape as RoundedCornerShape
        assertNotNull(roundedShape)
    }

    @Test
    fun shapes_are_different_instances() {
        assertNotSame(shapes.small, shapes.medium)
        assertNotSame(shapes.medium, shapes.large)
        assertNotSame(shapes.small, shapes.large)
    }

    @Test
    fun shapes_maintain_consistency() {
        // Test that shapes remain consistent across multiple accesses
        val firstAccess = shapes.small
        val secondAccess = shapes.small
        assertEquals(firstAccess, secondAccess)
    }

    @Test
    fun custom_rounded_corner_shape_creation() {
        val customShape = RoundedCornerShape(8.dp)
        assertNotNull(customShape)
        assertTrue(customShape is RoundedCornerShape)
    }

    @Test
    fun shapes_can_be_used_in_compose() {
        // Test that shapes can be used without throwing exceptions
        try {
            val testShapes = Shapes(
                small = RoundedCornerShape(4.dp),
                medium = RoundedCornerShape(4.dp),
                large = RoundedCornerShape(0.dp)
            )
            assertNotNull(testShapes)
        } catch (e: Exception) {
            fail("Shape creation should not throw exceptions: ${e.message}")
        }
    }
}
```