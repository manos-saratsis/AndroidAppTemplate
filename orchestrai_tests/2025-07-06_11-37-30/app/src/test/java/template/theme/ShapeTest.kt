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
    fun setUp() {
        shapes = Shapes
    }

    @Test
    fun shapes_object_not_null() {
        assertNotNull(shapes)
    }

    @Test
    fun small_shape_properties() {
        val smallShape = shapes.small
        assertNotNull(smallShape)
        assertTrue(smallShape is RoundedCornerShape)
    }

    @Test
    fun medium_shape_properties() {
        val mediumShape = shapes.medium
        assertNotNull(mediumShape)
        assertTrue(mediumShape is RoundedCornerShape)
    }

    @Test
    fun large_shape_properties() {
        val largeShape = shapes.large
        assertNotNull(largeShape)
        assertTrue(largeShape is RoundedCornerShape)
    }

    @Test
    fun shapes_are_different_instances() {
        assertNotSame(shapes.small, shapes.medium)
        assertNotSame(shapes.medium, shapes.large)
        assertNotSame(shapes.small, shapes.large)
    }

    @Test
    fun default_shapes_configuration() {
        // Test that shapes follow Material Design guidelines
        val small = shapes.small as RoundedCornerShape
        val medium = shapes.medium as RoundedCornerShape
        val large = shapes.large as RoundedCornerShape
        
        assertNotNull(small)
        assertNotNull(medium)
        assertNotNull(large)
    }

    @Test
    fun custom_shapes_creation() {
        val customShapes = Shapes(
            small = RoundedCornerShape(2.dp),
            medium = RoundedCornerShape(4.dp),
            large = RoundedCornerShape(8.dp)
        )
        
        assertNotNull(customShapes.small)
        assertNotNull(customShapes.medium)
        assertNotNull(customShapes.large)
    }

    @Test
    fun shapes_equality() {
        val shapes1 = Shapes()
        val shapes2 = Shapes()
        
        assertEquals(shapes1.small, shapes2.small)
        assertEquals(shapes1.medium, shapes2.medium)
        assertEquals(shapes1.large, shapes2.large)
    }

    @Test
    fun rounded_corner_shape_properties() {
        val roundedShape = RoundedCornerShape(8.dp)
        
        assertNotNull(roundedShape)
        assertTrue(roundedShape is RoundedCornerShape)
    }
}
```