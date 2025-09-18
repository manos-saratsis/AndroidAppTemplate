```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import org.junit.Assert.*
import org.junit.Test

class ShapeTest {

    @Test
    fun testShapesNotNull() {
        assertNotNull(Shapes)
        assertTrue(Shapes is Shapes)
    }

    @Test
    fun testDefaultShapeProperties() {
        val shapes = Shapes()
        
        // Test that default shapes are properly initialized
        assertNotNull(shapes.extraSmall)
        assertNotNull(shapes.small)
        assertNotNull(shapes.medium)
        assertNotNull(shapes.large)
        assertNotNull(shapes.extraLarge)
    }

    @Test
    fun testRoundedCornerShapes() {
        // Test creating rounded corner shapes with different radii
        val smallShape = RoundedCornerShape(4)
        val mediumShape = RoundedCornerShape(8)
        val largeShape = RoundedCornerShape(16)
        
        assertNotNull(smallShape)
        assertNotNull(mediumShape)
        assertNotNull(largeShape)
        
        // Test that shapes are different
        assertNotEquals(smallShape, mediumShape)
        assertNotEquals(mediumShape, largeShape)
    }

    @Test
    fun testShapeEquality() {
        val shape1 = RoundedCornerShape(8)
        val shape2 = RoundedCornerShape(8)
        val shape3 = RoundedCornerShape(12)
        
        assertEquals(shape1, shape2)
        assertNotEquals(shape1, shape3)
    }

    @Test
    fun testShapeCornerRadius() {
        val cornerRadius = 16
        val shape = RoundedCornerShape(cornerRadius)
        
        assertNotNull(shape)
        // Test that the shape can be created with various corner radii
        val shapes = listOf(
            RoundedCornerShape(0),
            RoundedCornerShape(4),
            RoundedCornerShape(8),
            RoundedCornerShape(16),
            RoundedCornerShape(24)
        )
        
        shapes.forEach { shape ->
            assertNotNull(shape)
        }
    }
}
```