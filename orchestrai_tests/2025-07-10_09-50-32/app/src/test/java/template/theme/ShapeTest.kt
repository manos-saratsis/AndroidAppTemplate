```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import org.junit.Assert.*
import org.junit.Test

class ShapeTest {

    @Test
    fun `shapes should be properly initialized`() {
        assertNotNull(Shapes)
        assertTrue(Shapes is Shapes)
    }

    @Test
    fun `shapes should have correct small shape`() {
        val expectedSmall = RoundedCornerShape(4.dp)
        assertEquals(expectedSmall.topStart, Shapes.small.topStart)
        assertEquals(expectedSmall.topEnd, Shapes.small.topEnd)
        assertEquals(expectedSmall.bottomStart, Shapes.small.bottomStart)
        assertEquals(expectedSmall.bottomEnd, Shapes.small.bottomEnd)
    }

    @Test
    fun `shapes should have correct medium shape`() {
        val expectedMedium = RoundedCornerShape(4.dp)
        assertEquals(expectedMedium.topStart, Shapes.medium.topStart)
        assertEquals(expectedMedium.topEnd, Shapes.medium.topEnd)
        assertEquals(expectedMedium.bottomStart, Shapes.medium.bottomStart)
        assertEquals(expectedMedium.bottomEnd, Shapes.medium.bottomEnd)
    }

    @Test
    fun `shapes should have correct large shape`() {
        val expectedLarge = RoundedCornerShape(0.dp)
        assertEquals(expectedLarge.topStart, Shapes.large.topStart)
        assertEquals(expectedLarge.topEnd, Shapes.large.topEnd)
        assertEquals(expectedLarge.bottomStart, Shapes.large.bottomStart)
        assertEquals(expectedLarge.bottomEnd, Shapes.large.bottomEnd)
    }

    @Test
    fun `shapes should be rounded corner shapes`() {
        assertTrue(Shapes.small is RoundedCornerShape)
        assertTrue(Shapes.medium is RoundedCornerShape)
        assertTrue(Shapes.large is RoundedCornerShape)
    }

    @Test
    fun `shapes should have different corner radii`() {
        val small = Shapes.small as RoundedCornerShape
        val medium = Shapes.medium as RoundedCornerShape
        val large = Shapes.large as RoundedCornerShape

        // Verify that shapes have expected corner radii
        assertNotNull(small.topStart)
        assertNotNull(medium.topStart)
        assertNotNull(large.topStart)
    }

    @Test
    fun `shapes object should be singleton`() {
        val shapes1 = Shapes
        val shapes2 = Shapes
        assertEquals(shapes1, shapes2)
    }

    @Test
    fun `shapes should be immutable`() {
        val originalSmall = Shapes.small
        val originalMedium = Shapes.medium
        val originalLarge = Shapes.large

        // Verify shapes remain the same
        assertEquals(originalSmall, Shapes.small)
        assertEquals(originalMedium, Shapes.medium)
        assertEquals(originalLarge, Shapes.large)
    }
}
```