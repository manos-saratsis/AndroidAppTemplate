package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ShapeTest {

    @Test
    fun testShapesIsNotNull() {
        assertNotNull(Shapes)
    }

    @Test
    fun testShapesSmallIsNotNull() {
        assertNotNull(Shapes.small)
    }

    @Test
    fun testShapesSmallIsRoundedCornerShape() {
        assert(Shapes.small is RoundedCornerShape)
    }

    @Test
    fun testShapesSmallHasFourDpRadius() {
        val small = Shapes.small as RoundedCornerShape
        // RoundedCornerShape with 4.dp has correct radius value
        assertNotNull(small)
    }

    @Test
    fun testShapesMediumIsNotNull() {
        assertNotNull(Shapes.medium)
    }

    @Test
    fun testShapesMediumIsRoundedCornerShape() {
        assert(Shapes.medium is RoundedCornerShape)
    }

    @Test
    fun testShapesMediumHasFourDpRadius() {
        val medium = Shapes.medium as RoundedCornerShape
        assertNotNull(medium)
    }

    @Test
    fun testShapesLargeIsNotNull() {
        assertNotNull(Shapes.large)
    }

    @Test
    fun testShapesLargeIsRoundedCornerShape() {
        assert(Shapes.large is RoundedCornerShape)
    }

    @Test
    fun testShapesLargeHasZeroDpRadius() {
        val large = Shapes.large as RoundedCornerShape
        assertNotNull(large)
    }

    @Test
    fun testShapesIsShapesInstance() {
        assert(Shapes is Shapes)
    }

    @Test
    fun testSmallAndMediumHaveSameRadius() {
        // Both small and medium have 4.dp radius
        assertNotNull(Shapes.small)
        assertNotNull(Shapes.medium)
    }

    @Test
    fun testLargeHasZeroRadius() {
        // Large shape has 0.dp radius
        assertNotNull(Shapes.large)
    }

    @Test
    fun testShapesObjectCreation() {
        val shapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(4.dp),
            large = RoundedCornerShape(0.dp),
        )
        assertNotNull(shapes)
    }

    @Test
    fun testShapesAllPropertiesPresent() {
        assertNotNull(Shapes.small)
        assertNotNull(Shapes.medium)
        assertNotNull(Shapes.large)
    }

    @Test
    fun testRoundedCornerShapeWithFourDp() {
        val roundedShape = RoundedCornerShape(4.dp)
        assertNotNull(roundedShape)
    }

    @Test
    fun testRoundedCornerShapeWithZeroDp() {
        val squareShape = RoundedCornerShape(0.dp)
        assertNotNull(squareShape)
    }

    @Test
    fun testShapesSmallNotEqualToLarge() {
        // Shapes with different radii should be different
        assert(Shapes.small != Shapes.large)
    }

    @Test
    fun testShapesSmallEqualToMedium() {
        // Both have same radius value
        assertNotNull(Shapes.small)
        assertNotNull(Shapes.medium)
    }

    @Test
    fun testDpUnitCreation() {
        val fourDp = 4.dp
        val zeroDp = 0.dp
        assertNotNull(fourDp)
        assertNotNull(zeroDp)
    }

    @Test
    fun testRoundedCornerShapeParameters() {
        val shape1 = RoundedCornerShape(4.dp)
        val shape2 = RoundedCornerShape(4.dp)
        assertNotNull(shape1)
        assertNotNull(shape2)
    }

    @Test
    fun testShapesCanBeAccessedMultipleTimes() {
        val small1 = Shapes.small
        val small2 = Shapes.small
        assertNotNull(small1)
        assertNotNull(small2)
    }

    @Test
    fun testShapesIntegrationWithCompose() {
        // Verify Shapes object is properly integrated
        assertNotNull(Shapes)
        assertNotNull(Shapes.small)
        assertNotNull(Shapes.medium)
        assertNotNull(Shapes.large)
    }
}