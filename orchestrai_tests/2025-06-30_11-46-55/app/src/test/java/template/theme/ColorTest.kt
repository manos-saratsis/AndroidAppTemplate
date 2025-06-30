```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test
import kotlin.test.assertEquals

class ColorTest {
    @Test
    fun `verify color values`() {
        assertEquals(Color(0xFF6200EE), Purple200)
        assertEquals(Color(0xFF3700B3), Purple500)
        assertEquals(Color(0xFF03DAC5), Purple700)
        assertEquals(Color(0xFF03DAC5), Teal200)
    }
}
```