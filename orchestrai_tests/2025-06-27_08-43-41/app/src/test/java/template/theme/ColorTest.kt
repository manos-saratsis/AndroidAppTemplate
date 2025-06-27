```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test
import kotlin.test.assertEquals

class ColorTest {
    @Test
    fun `test color values are correctly defined`() {
        assertEquals(Purple80, Color(0xFFD0BCFF))
        assertEquals(PurpleGrey80, Color(0xFFCCC2DC))
        assertEquals(Pink80, Color(0xFFEFB8C8))
        
        assertEquals(Purple40, Color(0xFF6650a4))
        assertEquals(PurpleGrey40, Color(0xFF625b71))
        assertEquals(Pink40, Color(0xFF7D5260))
    }
}
```