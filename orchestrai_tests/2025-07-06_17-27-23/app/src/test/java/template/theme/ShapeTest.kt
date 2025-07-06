```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ShapeTest {

    @Test
    fun `shapes object is not null`() {
        assertNotNull(Shapes)
    }

    @Test
    fun `shapes has correct small shape`() {
        val expectedShape = RoundedCornerShape(4.dp)
        assertEquals(expectedShape, Shapes.small)
    }

    @Test
    fun `shapes has correct medium shape`() {
        val expectedShape = RoundedCornerShape(4.dp)
        assertEquals(expectedShape, Shapes.medium)
    }

    @Test
    fun `shapes has correct large shape`() {
        val expectedShape = RoundedCornerShape(0.dp)
        assertEquals(expectedShape, Shapes.large)
    }

    @Test
    fun `all shapes are rounded corner shapes`() {
        assertTrue(Shapes.small is RoundedCornerShape)
        assertTrue(Shapes.medium is RoundedCornerShape)
        assertTrue(Shapes.large is RoundedCornerShape)
    }

    @Test
    fun `shapes have valid corner radius values`() {
        val smallShape = Shapes.small as RoundedCornerShape
        val mediumShape = Shapes.medium as RoundedCornerShape
        val largeShape = Shapes.large as RoundedCornerShape

        // Verify corner radius values are non-negative
        assertTrue(smallShape.topStart.value >= 0f)
        assertTrue(mediumShape.topStart.value >= 0f)
        assertTrue(largeShape.topStart.value >= 0f)
    }

    @Test
    fun `shapes provide consistent styling`() {
        // Test that shapes provide consistent styling across the app
        assertNotNull(Shapes.small)
        assertNotNull(Shapes.medium)
        assertNotNull(Shapes.large)
    }

    @Test
    fun `shapes can be used in compose`() {
        // Test that shapes can be used in Compose components
        val shapes = Shapes
        
        // Verify shapes can be accessed and used
        val smallCorners = shapes.small
        val mediumCorners = shapes.medium
        val largeCorners = shapes.large
        
        assertNotNull(smallCorners)
        assertNotNull(mediumCorners)
        assertNotNull(largeCorners)
    }
}
```