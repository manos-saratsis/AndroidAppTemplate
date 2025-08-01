```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class ColorTest {

    @Before
    fun setUp() {
        // Setup any required test data
    }

    @Test
    fun testPrimaryColorValues() {
        // Test that primary colors are properly defined
        assertNotNull(Purple80)
        assertNotNull(PurpleGrey80)
        assertNotNull(Pink80)
        
        // Test color values are not transparent
        assertNotEquals(Color.Transparent, Purple80)
        assertNotEquals(Color.Transparent, PurpleGrey80)
        assertNotEquals(Color.Transparent, Pink80)
    }

    @Test
    fun testSecondaryColorValues() {
        assertNotNull(Purple40)
        assertNotNull(PurpleGrey40)
        assertNotNull(Pink40)
        
        // Test color values are not transparent
        assertNotEquals(Color.Transparent, Purple40)
        assertNotEquals(Color.Transparent, PurpleGrey40)
        assertNotEquals(Color.Transparent, Pink40)
    }

    @Test
    fun testColorContrast() {
        // Test that light and dark variants are different
        assertNotEquals(Purple80, Purple40)
        assertNotEquals(PurpleGrey80, PurpleGrey40)
        assertNotEquals(Pink80, Pink40)
    }

    @Test
    fun testColorAlphaValues() {
        // Test that colors have full opacity by default
        assertEquals(1.0f, Purple80.alpha, 0.001f)
        assertEquals(1.0f, Purple40.alpha, 0.001f)
        assertEquals(1.0f, PurpleGrey80.alpha, 0.001f)
        assertEquals(1.0f, PurpleGrey40.alpha, 0.001f)
        assertEquals(1.0f, Pink80.alpha, 0.001f)
        assertEquals(1.0f, Pink40.alpha, 0.001f)
    }

    @Test
    fun testColorComponents() {
        // Test that colors have valid RGB components (0.0 to 1.0)
        listOf(Purple80, Purple40, PurpleGrey80, PurpleGrey40, Pink80, Pink40).forEach { color ->
            assertTrue("Red component should be between 0 and 1", color.red in 0.0f..1.0f)
            assertTrue("Green component should be between 0 and 1", color.green in 0.0f..1.0f)
            assertTrue("Blue component should be between 0 and 1", color.blue in 0.0f..1.0f)
            assertTrue("Alpha component should be between 0 and 1", color.alpha in 0.0f..1.0f)
        }
    }

    @Test
    fun testColorEquality() {
        // Test color equality
        assertEquals(Purple80, Purple80)
        assertEquals(Purple40, Purple40)
        assertEquals(PurpleGrey80, PurpleGrey80)
        assertEquals(PurpleGrey40, PurpleGrey40)
        assertEquals(Pink80, Pink80)
        assertEquals(Pink40, Pink40)
    }

    @Test
    fun testColorHashCode() {
        // Test that equal colors have equal hash codes
        assertEquals(Purple80.hashCode(), Purple80.hashCode())
        assertEquals(Purple40.hashCode(), Purple40.hashCode())
        assertEquals(PurpleGrey80.hashCode(), PurpleGrey80.hashCode())
        assertEquals(PurpleGrey40.hashCode(), PurpleGrey40.hashCode())
        assertEquals(Pink80.hashCode(), Pink80.hashCode())
        assertEquals(Pink40.hashCode(), Pink40.hashCode())
    }
}
```