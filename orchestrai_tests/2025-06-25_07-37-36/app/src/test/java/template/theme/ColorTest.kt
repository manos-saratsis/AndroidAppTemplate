```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test
import kotlin.test.assertEquals

class ColorTest {
    @Test
    fun `verify color values`() {
        assertEquals(Purple200, Color(0xFFBB86FC))
        assertEquals(Purple500, Color(0xFF6200EE))
        assertEquals(Purple700, Color(0xFF3700B3))
        assertEquals(Teal200, Color(0xFF03DAC5))
    }
}
```