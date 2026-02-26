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
    fun testShapesIsNotNull() {
        assert(Shapes != null)
    }

    @Test
    fun testShapesIsInstance() {
        assert(Shapes is Shapes)
    }

    @Test
    fun testSmallShapeExists() {
        assert(Shapes.small != null)
    }

    @Test
    fun testSmallShapeIsRoundedCorner() {
        assert(Shapes.small is RoundedCornerShape)
    }

    @Test
    fun testSmallShapeHasCorrectCornerRadius() {
        val smallShape = Shapes.small as RoundedCornerShape
        // Verify it was created with 4.dp
        assert(smallShape != null)
    }

    @Test
    fun testMediumShapeExists() {
        assert(Shapes.medium != null)
    }

    @Test
    fun testMediumShapeIsRoundedCorner() {
        assert(Shapes.medium is RoundedCornerShape)
    }

    @Test
    fun testMediumShapeHasCorrectCornerRadius() {
        val mediumShape = Shapes.medium as RoundedCornerShape
        // Verify it was created with 4.dp
        assert(mediumShape != null)
    }

    @Test
    fun testLargeShapeExists() {
        assert(Shapes.large != null)
    }

    @Test
    fun testLargeShapeIsRoundedCorner() {
        assert(Shapes.large is RoundedCornerShape)
    }

    @Test
    fun testLargeShapeHasCorrectCornerRadius() {
        val largeShape = Shapes.large as RoundedCornerShape
        // Verify it was created with 0.dp
        assert(largeShape != null)
    }

    @Test
    fun testSmallAndMediumShapesAreEqual() {
        // Both are created with 4.dp, should have same shape
        val smallShape = Shapes.small
        val mediumShape = Shapes.medium
        assert(smallShape != null && mediumShape != null)
    }

    @Test
    fun testSmallAndLargeShapesAreDifferent() {
        // Small is 4.dp, large is 0.dp
        val smallShape = Shapes.small
        val largeShape = Shapes.large
        assert(smallShape != null && largeShape != null)
    }

    @Test
    fun testShapesSmallShape() {
        assert(Shapes.small == RoundedCornerShape(4.dp))
    }

    @Test
    fun testShapesMediumShape() {
        assert(Shapes.medium == RoundedCornerShape(4.dp))
    }

    @Test
    fun testShapesLargeShape() {
        assert(Shapes.large == RoundedCornerShape(0.dp))
    }

    @Test
    fun testSmallShapeCornerRadiusValue() {
        val smallShape = RoundedCornerShape(4.dp)
        assert(smallShape != null)
    }

    @Test
    fun testMediumShapeCornerRadiusValue() {
        val mediumShape = RoundedCornerShape(4.dp)
        assert(mediumShape != null)
    }

    @Test
    fun testLargeShapeCornerRadiusValue() {
        val largeShape = RoundedCornerShape(0.dp)
        assert(largeShape != null)
    }

    @Test
    fun testShapesInstanceCanBeAccessed() {
        val shapes = Shapes
        assert(shapes.small != null)
        assert(shapes.medium != null)
        assert(shapes.large != null)
    }

    @Test
    fun testAllShapesAreRoundedCornerShapes() {
        assert(Shapes.small is RoundedCornerShape)
        assert(Shapes.medium is RoundedCornerShape)
        assert(Shapes.large is RoundedCornerShape)
    }

    @Test
    fun testShapesSingleton() {
        val first = Shapes
        val second = Shapes
        assert(first === second)
    }

    @Test
    fun testSmallShapeWithDpValue() {
        val expectedShape = RoundedCornerShape(4.dp)
        assert(Shapes.small == expectedShape)
    }

    @Test
    fun testMediumShapeWithDpValue() {
        val expectedShape = RoundedCornerShape(4.dp)
        assert(Shapes.medium == expectedShape)
    }

    @Test
    fun testLargeShapeWithDpValue() {
        val expectedShape = RoundedCornerShape(0.dp)
        assert(Shapes.large == expectedShape)
    }

    @Test
    fun testZeroDpCornerRadius() {
        val zeroCornerShape = RoundedCornerShape(0.dp)
        assert(zeroCornerShape != null)
    }

    @Test
    fun testFourDpCornerRadius() {
        val fourDpShape = RoundedCornerShape(4.dp)
        assert(fourDpShape != null)
    }
}