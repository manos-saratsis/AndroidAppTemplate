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
    fun testShapesExist() {
        // Test that Shapes object exists and is accessible
        assertNotNull(Shapes)
    }

    @Test
    fun testSmallShape() {
        // Test small shape properties
        val smallShape = Shapes.small
        assertNotNull(smallShape)
        assertTrue(smallShape is RoundedCornerShape)
    }

    @Test
    fun testMediumShape() {
        // Test medium shape properties
        val mediumShape = Shapes.medium
        assertNotNull(mediumShape)
        assertTrue(mediumShape is RoundedCornerShape)
    }

    @Test
    fun testLargeShape() {
        // Test large shape properties
        val largeShape = Shapes.large
        assertNotNull(largeShape)
        assertTrue(largeShape is RoundedCornerShape)
    }

    @Test
    fun testShapeHierarchy() {
        // Test that shapes have different corner radii
        val small = Shapes.small as RoundedCornerShape
        val medium = Shapes.medium as RoundedCornerShape
        val large = Shapes.large as RoundedCornerShape
        
        assertNotEquals(small, medium)
        assertNotEquals(medium, large)
        assertNotEquals(small, large)
    }

    @Test
    fun testCustomRoundedCornerShape() {
        // Test creating custom rounded corner shapes
        val customShape = RoundedCornerShape(8.dp)
        assertNotNull(customShape)
        assertTrue(customShape is RoundedCornerShape)
    }

    @Test
    fun testShapeCornerRadius() {
        // Test that corner radius values are reasonable
        val testShape = RoundedCornerShape(4.dp)
        assertNotNull(testShape)
        
        val zeroShape = RoundedCornerShape(0.dp)
        assertNotNull(zeroShape)
        
        val largeRadiusShape = RoundedCornerShape(16.dp)
        assertNotNull(largeRadiusShape)
    }
}
```