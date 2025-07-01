```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test

class ColorTest {
    @Test
    fun `color values are correctly defined`() {
        assert(Purple200 == Color(0xFFBB86FC))
        assert(Purple500 == Color(0xFF6200EE))
        assert(Purple700 == Color(0xFF3700B3))
        assert(Teal200 == Color(0xFF03DAC5))
    }
}
```