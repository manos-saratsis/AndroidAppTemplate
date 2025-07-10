```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ShapeTest {

    @Before
    fun setUp() {
        // Setup any required test data
    }

    @Test
    fun shapes_object_exists() {
        assertNotNull("Shapes object should exist", Shapes)
    }

    @Test
    fun shapes_small_is_rounded_corner() {
        assertTrue("Small shape should be RoundedCornerShape", 
                  Shapes.small is RoundedCornerShape)
    }

    @Test
    fun shapes_medium_is_rounded_corner() {
        assertTrue("Medium shape should be RoundedCornerShape", 
                  Shapes.medium is RoundedCornerShape)
    }

    @Test
    fun shapes_large_is_rounded_corner() {
        assertTrue("Large shape should be RoundedCornerShape", 
                  Shapes.large is RoundedCornerShape)
    }

    @Test
    fun shapes_small_has_correct_radius() {
        val expectedShape = RoundedCornerShape(4.dp)
        assertEquals("Small shape should have 4dp radius", expectedShape, Shapes.small)
    }

    @Test
    fun shapes_medium_has_correct_radius() {
        val expectedShape = RoundedCornerShape(4.dp)
        assertEquals("Medium shape should have 4dp radius", expectedShape, Shapes.medium)
    }

    @Test
    fun shapes_large_has_correct_radius() {
        val expectedShape = RoundedCornerShape(0.dp)
        assertEquals("Large shape should have 0dp radius", expectedShape, Shapes.large)
    }

    @Test
    fun shapes_are_not_null() {
        assertNotNull("Small shape should not be null", Shapes.small)
        assertNotNull("Medium shape should not be null", Shapes.medium)
        assertNotNull("Large shape should not be null", Shapes.large)
    }

    @Test
    fun shapes_small_and_medium_are_same() {
        assertEquals("Small and medium shapes should be the same", Shapes.small, Shapes.medium)
    }

    @Test
    fun shapes_large_is_different_from_small() {
        assertNotEquals("Large shape should be different from small", Shapes.large, Shapes.small)
    }

    @Test
    fun custom_rounded_corner_shape_creation() {
        val customShape = RoundedCornerShape(8.dp)
        assertNotNull("Custom shape should not be null", customShape)
        assertTrue("Custom shape should be RoundedCornerShape", customShape is RoundedCornerShape)
    }
}
```