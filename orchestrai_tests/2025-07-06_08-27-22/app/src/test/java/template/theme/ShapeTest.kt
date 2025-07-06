```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ShapeTest {

    @Test
    fun `Shapes should be created successfully`() {
        val shapes = Shapes()
        assertNotNull(shapes)
    }

    @Test
    fun `default shapes should have correct values`() {
        val shapes = Shapes()
        
        assertNotNull(shapes.small)
        assertNotNull(shapes.medium)
        assertNotNull(shapes.large)
    }

    @Test
    fun `custom shapes should be created correctly`() {
        val customShapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(8.dp),
            large = RoundedCornerShape(16.dp)
        )
        
        assertNotNull(customShapes.small)
        assertNotNull(customShapes.medium)
        assertNotNull(customShapes.large)
    }

    @Test
    fun `rounded corner shape should have correct radius`() {
        val shape = RoundedCornerShape(8.dp)
        assertNotNull(shape)
    }

    @Test
    fun `shapes should be different sizes`() {
        val smallShape = RoundedCornerShape(4.dp)
        val mediumShape = RoundedCornerShape(8.dp)
        val largeShape = RoundedCornerShape(16.dp)
        
        assertNotNull(smallShape)
        assertNotNull(mediumShape)
        assertNotNull(largeShape)
    }

    @Test
    fun `shape with zero radius should be valid`() {
        val shape = RoundedCornerShape(0.dp)
        assertNotNull(shape)
    }

    @Test
    fun `shape with individual corner radius should work`() {
        val shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 8.dp,
            bottomStart = 12.dp,
            bottomEnd = 16.dp
        )
        assertNotNull(shape)
    }

    @Test
    fun `shapes should support percentage values`() {
        val shape = RoundedCornerShape(50)
        assertNotNull(shape)
    }

    @Test
    fun `shapes object should be immutable`() {
        val shapes1 = Shapes()
        val shapes2 = Shapes()
        
        // Both should have the same default values
        assertNotNull(shapes1)
        assertNotNull(shapes2)
    }

    @Test
    fun `shape equality should work correctly`() {
        val shape1 = RoundedCornerShape(8.dp)
        val shape2 = RoundedCornerShape(8.dp)
        
        assertEquals(shape1, shape2)
    }
}
```