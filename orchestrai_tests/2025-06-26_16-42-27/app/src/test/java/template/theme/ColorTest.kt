```kotlin
package template.theme

import org.junit.Test
import androidx.compose.ui.graphics.Color

class ColorTest {
    @Test
    fun `verify color values`() {
        assert(Purple200 == Color(0xFFBB86FC))
        assert(Purple500 == Color(0xFF6200EE))
        assert(Purple700 == Color(0xFF3700B3))
        assert(Teal200 == Color(0xFF03DAC5))
    }
}
```