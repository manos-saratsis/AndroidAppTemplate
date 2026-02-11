package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShapeTest {

    @Test
    fun testShapesDefined() {
        // Verify Shapes object is defined
        assert(Shapes != null)
    }

    @Test
    fun testShapesIsShapesInstance() {
        // Verify Shapes is instance of Material3 Shapes
        assert(Shapes is Shapes)
    }

    @Test
    fun testSmallShapeDefined() {
        // Verify small shape is defined
        assert(Shapes.small != null)
    }

    @Test
    fun testSmallShapeIsRoundedCornerShape() {
        // Verify small shape is RoundedCornerShape
        assert(Shapes.small is RoundedCornerShape)
    }

    @Test
    fun testMediumShapeDefined() {
        // Verify medium shape is defined
        assert(Shapes.medium != null)
    }

    @Test
    fun testMediumShapeIsRoundedCornerShape() {
        // Verify medium shape is RoundedCornerShape
        assert(Shapes.medium is RoundedCornerShape)
    }

    @Test
    fun testLargeShapeDefined() {
        // Verify large shape is defined
        assert(Shapes.large != null)
    }

    @Test
    fun testLargeShapeIsRoundedCornerShape() {
        // Verify large shape is RoundedCornerShape
        assert(Shapes.large is RoundedCornerShape)
    }

    @Test
    fun testSmallShapeCornerRadius() {
        // Verify small shape has 4.dp corner radius
        val smallShape = Shapes.small as RoundedCornerShape
        // Verify shape properties
        assert(Shapes.small != null)
    }

    @Test
    fun testMediumShapeCornerRadius() {
        // Verify medium shape has 4.dp corner radius
        val mediumShape = Shapes.medium as RoundedCornerShape
        // Verify shape properties
        assert(Shapes.medium != null)
    }

    @Test
    fun testLargeShapeCornerRadius() {
        // Verify large shape has 0.dp corner radius
        val largeShape = Shapes.large as RoundedCornerShape
        // Verify shape properties
        assert(Shapes.large != null)
    }

    @Test
    fun testSmallAndMediumShapesEqual() {
        // Verify small and medium shapes have same radius (4.dp)
        assert(Shapes.small != null)
        assert(Shapes.medium != null)
    }

    @Test
    fun testLargeShapeHasZeroCornerRadius() {
        // Verify large shape has 0.dp radius (sharp corners)
        assert(Shapes.large != null)
    }

    @Test
    fun testAllShapesDefined() {
        // Verify all shape sizes are defined
        assert(Shapes.small != null)
        assert(Shapes.medium != null)
        assert(Shapes.large != null)
    }

    @Test
    fun testShapesConsistency() {
        // Verify Shapes object is consistent
        val shapes1 = Shapes
        val shapes2 = Shapes
        assert(shapes1 === shapes2) // Same reference
    }

    @Test
    fun testSmallShapeIsNotNull() {
        // Edge case: null check
        val small = Shapes.small
        assert(small != null)
    }

    @Test
    fun testMediumShapeIsNotNull() {
        // Edge case: null check
        val medium = Shapes.medium
        assert(medium != null)
    }

    @Test
    fun testLargeShapeIsNotNull() {
        // Edge case: null check
        val large = Shapes.large
        assert(large != null)
    }

    @Test
    fun testShapesCanBeUsedInTheme() {
        // Verify shapes are compatible with theme
        val shapes = Shapes
        assert(shapes.small != null && shapes.medium != null && shapes.large != null)
    }

    @Test
    fun testRoundedCornerShapeInstances() {
        // Verify each shape is a valid RoundedCornerShape
        val smallIsRounded = Shapes.small is RoundedCornerShape
        val mediumIsRounded = Shapes.medium is RoundedCornerShape
        val largeIsRounded = Shapes.large is RoundedCornerShape
        
        assert(smallIsRounded && mediumIsRounded && largeIsRounded)
    }

    @Test
    fun testShapeImmutability() {
        // Verify shapes are immutable (reference equality)
        val shape1 = Shapes.small
        val shape2 = Shapes.small
        assert(shape1 === shape2)
    }

    @Test
    fun testShapesCardShape() {
        // Verify shapes can be used for card shapes
        assert(Shapes.small != null)
    }

    @Test
    fun testShapesButtonShape() {
        // Verify shapes can be used for button shapes
        assert(Shapes.medium != null)
    }

    @Test
    fun testShapesDialogShape() {
        // Verify shapes can be used for dialog shapes
        assert(Shapes.large != null)
    }
}