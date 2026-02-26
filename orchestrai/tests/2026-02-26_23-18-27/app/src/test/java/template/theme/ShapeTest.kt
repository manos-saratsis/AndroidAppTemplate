package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ShapeTest {

    @Test
    fun testShapesIsNotNull() {
        assertNotNull(Shapes)
    }

    @Test
    fun testShapesIsShapesInstance() {
        assert(Shapes is Shapes)
    }

    @Test
    fun testSmallShapeIsNotNull() {
        assertNotNull(Shapes.small)
    }

    @Test
    fun testSmallShapeIsRoundedCornerShape() {
        assert(Shapes.small is RoundedCornerShape)
    }

    @Test
    fun testMediumShapeIsNotNull() {
        assertNotNull(Shapes.medium)
    }

    @Test
    fun testMediumShapeIsRoundedCornerShape() {
        assert(Shapes.medium is RoundedCornerShape)
    }

    @Test
    fun testLargeShapeIsNotNull() {
        assertNotNull(Shapes.large)
    }

    @Test
    fun testLargeShapeIsRoundedCornerShape() {
        assert(Shapes.large is RoundedCornerShape)
    }

    @Test
    fun testSmallShapeCornerRadius() {
        // Small shape should have 4.dp corner radius
        val small = RoundedCornerShape(4.dp)
        assertEquals(small.topStart, Shapes.small.topStart)
    }

    @Test
    fun testMediumShapeCornerRadius() {
        // Medium shape should have 4.dp corner radius
        val medium = RoundedCornerShape(4.dp)
        assertEquals(medium.topStart, Shapes.medium.topStart)
    }

    @Test
    fun testLargeShapeCornerRadius() {
        // Large shape should have 0.dp corner radius (no rounding)
        val large = RoundedCornerShape(0.dp)
        assertEquals(large.topStart, Shapes.large.topStart)
    }

    @Test
    fun testSmallAndMediumShapesAreEqual() {
        // Both should have 4.dp
        assertEquals(Shapes.small.topStart, Shapes.medium.topStart)
    }

    @Test
    fun testLargeShapeHasNoRounding() {
        val noRoundingShape = RoundedCornerShape(0.dp)
        assertEquals(noRoundingShape.topStart, Shapes.large.topStart)
    }

    @Test
    fun testSmallShapeHasRounding() {
        val roundedShape = RoundedCornerShape(4.dp)
        assertEquals(roundedShape.topStart, Shapes.small.topStart)
    }

    @Test
    fun testAllShapesAreDefined() {
        assertNotNull(Shapes.small)
        assertNotNull(Shapes.medium)
        assertNotNull(Shapes.large)
    }

    @Test
    fun testSmallShapeAllCornersEqual() {
        // RoundedCornerShape with single value applies to all corners
        assert(Shapes.small.topStart == Shapes.small.topEnd)
        assert(Shapes.small.bottomStart == Shapes.small.bottomEnd)
    }

    @Test
    fun testMediumShapeAllCornersEqual() {
        assert(Shapes.medium.topStart == Shapes.medium.topEnd)
        assert(Shapes.medium.bottomStart == Shapes.medium.bottomEnd)
    }

    @Test
    fun testLargeShapeAllCornersEqual() {
        assert(Shapes.large.topStart == Shapes.large.topEnd)
        assert(Shapes.large.bottomStart == Shapes.large.bottomEnd)
    }

    @Test
    fun testShapesImmutability() {
        val shapes1 = Shapes
        val shapes2 = Shapes
        assertEquals(shapes1.small, shapes2.small)
        assertEquals(shapes1.medium, shapes2.medium)
        assertEquals(shapes1.large, shapes2.large)
    }

    @Test
    fun testSmallShapeCornerRadiusIs4dp() {
        val expectedShape = RoundedCornerShape(4.dp)
        assertEquals(expectedShape.topStart, Shapes.small.topStart)
    }

    @Test
    fun testMediumShapeCornerRadiusIs4dp() {
        val expectedShape = RoundedCornerShape(4.dp)
        assertEquals(expectedShape.topStart, Shapes.medium.topStart)
    }

    @Test
    fun testLargeShapeCornerRadiusIs0dp() {
        val expectedShape = RoundedCornerShape(0.dp)
        assertEquals(expectedShape.topStart, Shapes.large.topStart)
    }

    @Test
    fun testSmallShapeTopStartCorner() {
        val expectedRadius = RoundedCornerShape(4.dp).topStart
        assertEquals(expectedRadius, Shapes.small.topStart)
    }

    @Test
    fun testMediumShapeTopStartCorner() {
        val expectedRadius = RoundedCornerShape(4.dp).topStart
        assertEquals(expectedRadius, Shapes.medium.topStart)
    }

    @Test
    fun testLargeShapeTopStartCorner() {
        val expectedRadius = RoundedCornerShape(0.dp).topStart
        assertEquals(expectedRadius, Shapes.large.topStart)
    }

    @Test
    fun testSmallShapeBottomEndCorner() {
        val expectedRadius = RoundedCornerShape(4.dp).bottomEnd
        assertEquals(expectedRadius, Shapes.small.bottomEnd)
    }

    @Test
    fun testMediumShapeBottomEndCorner() {
        val expectedRadius = RoundedCornerShape(4.dp).bottomEnd
        assertEquals(expectedRadius, Shapes.medium.bottomEnd)
    }

    @Test
    fun testLargeShapeBottomEndCorner() {
        val expectedRadius = RoundedCornerShape(0.dp).bottomEnd
        assertEquals(expectedRadius, Shapes.large.bottomEnd)
    }

    @Test
    fun testShapesConsistency() {
        // Verify that multiple accesses return consistent values
        val small1 = Shapes.small
        val small2 = Shapes.small
        assertEquals(small1.topStart, small2.topStart)
    }

    @Test
    fun testShapePropertyAccessibility() {
        // Verify all shapes are accessible
        val smallAccessible = Shapes.small != null
        val mediumAccessible = Shapes.medium != null
        val largeAccessible = Shapes.large != null
        
        assert(smallAccessible && mediumAccessible && largeAccessible)
    }
}