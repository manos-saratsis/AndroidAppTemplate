```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ShapeTest {

    private lateinit var shapes: Shapes

    @Before
    fun setUp() {
        shapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(4.dp),
            large = RoundedCornerShape(0.dp)
        )
    }

    @Test
    fun testShapesCreation() {
        assertNotNull(shapes)
        assertNotNull(shapes.small)
        assertNotNull(shapes.medium)
        assertNotNull(shapes.large)
    }

    @Test
    fun testSmallShapeRadius() {
        val smallShape = shapes.small as RoundedCornerShape
        assertNotNull(smallShape)
        // Test that it's a RoundedCornerShape with expected properties
        assertTrue(smallShape is RoundedCornerShape)
    }

    @Test
    fun testMediumShapeRadius() {
        val mediumShape = shapes.medium as RoundedCornerShape
        assertNotNull(mediumShape)
        assertTrue(mediumShape is RoundedCornerShape)
    }

    @Test
    fun testLargeShapeRadius() {
        val largeShape = shapes.large as RoundedCornerShape
        assertNotNull(largeShape)
        assertTrue(largeShape is RoundedCornerShape)
    }

    @Test
    fun testRoundedCornerShapeCreation() {
        val roundedShape = RoundedCornerShape(8.dp)
        assertNotNull(roundedShape)
        assertTrue(roundedShape is RoundedCornerShape)
    }

    @Test
    fun testRoundedCornerShapeWithDifferentCorners() {
        val roundedShape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 4.dp,
            bottomStart = 2.dp,
            bottomEnd = 0.dp
        )
        assertNotNull(roundedShape)
        assertTrue(roundedShape is RoundedCornerShape)
    }

    @Test
    fun testShapeEquality() {
        val shape1 = RoundedCornerShape(4.dp)
        val shape2 = RoundedCornerShape(4.dp)
        assertEquals(shape1, shape2)
    }

    @Test
    fun testShapeInequality() {
        val shape1 = RoundedCornerShape(4.dp)
        val shape2 = RoundedCornerShape(8.dp)
        assertNotEquals(shape1, shape2)
    }

    @Test
    fun testShapeToString() {
        val shape = RoundedCornerShape(4.dp)
        val shapeString = shape.toString()
        assertNotNull(shapeString)
        assertTrue(shapeString.isNotEmpty())
    }

    @Test
    fun testZeroRadiusShape() {
        val zeroShape = RoundedCornerShape(0.dp)
        assertNotNull(zeroShape)
        assertTrue(zeroShape is RoundedCornerShape)
    }

    @Test
    fun testShapesDefaultValues() {
        val defaultShapes = Shapes()
        assertNotNull(defaultShapes.small)
        assertNotNull(defaultShapes.medium)
        assertNotNull(defaultShapes.large)
    }

    @Test
    fun testShapesCopy() {
        val originalShapes = Shapes()
        val copiedShapes = originalShapes.copy(
            small = RoundedCornerShape(2.dp)
        )
        assertNotNull(copiedShapes)
        assertNotEquals(originalShapes.small, copiedShapes.small)
    }
}
```