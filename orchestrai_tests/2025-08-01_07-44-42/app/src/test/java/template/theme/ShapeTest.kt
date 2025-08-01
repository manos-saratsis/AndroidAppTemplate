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
        shapes = Shapes
    }

    @Test
    fun testShapesNotNull() {
        assertNotNull(shapes)
        assertNotNull(shapes.extraSmall)
        assertNotNull(shapes.small)
        assertNotNull(shapes.medium)
        assertNotNull(shapes.large)
        assertNotNull(shapes.extraLarge)
    }

    @Test
    fun testShapeTypes() {
        // Test that shapes are RoundedCornerShape instances
        assertTrue(shapes.extraSmall is RoundedCornerShape)
        assertTrue(shapes.small is RoundedCornerShape)
        assertTrue(shapes.medium is RoundedCornerShape)
        assertTrue(shapes.large is RoundedCornerShape)
        assertTrue(shapes.extraLarge is RoundedCornerShape)
    }

    @Test
    fun testShapeProgression() {
        // Test that shapes have logical progression in corner radius
        val extraSmallRadius = (shapes.extraSmall as RoundedCornerShape).topStart
        val smallRadius = (shapes.small as RoundedCornerShape).topStart
        val mediumRadius = (shapes.medium as RoundedCornerShape).topStart
        val largeRadius = (shapes.large as RoundedCornerShape).topStart
        val extraLargeRadius = (shapes.extraLarge as RoundedCornerShape).topStart

        // Verify progression (each should be >= previous)
        assertTrue("Small should be >= ExtraSmall", smallRadius >= extraSmallRadius)
        assertTrue("Medium should be >= Small", mediumRadius >= smallRadius)
        assertTrue("Large should be >= Medium", largeRadius >= mediumRadius)
        assertTrue("ExtraLarge should be >= Large", extraLargeRadius >= largeRadius)
    }

    @Test
    fun testShapeEquality() {
        val shapes1 = Shapes
        val shapes2 = Shapes
        
        assertEquals(shapes1.extraSmall, shapes2.extraSmall)
        assertEquals(shapes1.small, shapes2.small)
        assertEquals(shapes1.medium, shapes2.medium)
        assertEquals(shapes1.large, shapes2.large)
        assertEquals(shapes1.extraLarge, shapes2.extraLarge)
    }

    @Test
    fun testRoundedCornerShapeProperties() {
        val roundedShape = RoundedCornerShape(8.dp)
        
        assertNotNull(roundedShape)
        assertEquals(8.dp, roundedShape.topStart)
        assertEquals(8.dp, roundedShape.topEnd)
        assertEquals(8.dp, roundedShape.bottomStart)
        assertEquals(8.dp, roundedShape.bottomEnd)
    }

    @Test
    fun testCustomShapeCreation() {
        val customShape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 8.dp,
            bottomStart = 12.dp,
            bottomEnd = 16.dp
        )
        
        assertEquals(4.dp, customShape.topStart)
        assertEquals(8.dp, customShape.topEnd)
        assertEquals(12.dp, customShape.bottomStart)
        assertEquals(16.dp, customShape.bottomEnd)
    }

    @Test
    fun testShapeImmutability() {
        val originalShapes = Shapes
        val newShapes = Shapes
        
        // Shapes should be consistent across instances
        assertEquals(originalShapes.small, newShapes.small)
        assertEquals(originalShapes.medium, newShapes.medium)
        assertEquals(originalShapes.large, newShapes.large)
    }
}
```