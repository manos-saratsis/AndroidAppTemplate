```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test

class ColorTest {
    @Test
    fun `verify color values are correctly defined`() {
        assert(Purple80 == Color(0xFFD0BCFF))
        assert(PurpleGrey80 == Color(0xFFCCC2DC))
        assert(Pink80 == Color(0xFFEFB8C8))
        
        assert(Purple40 == Color(0xFF6650a4))
        assert(PurpleGrey40 == Color(0xFF625b71))
        assert(Pink40 == Color(0xFF7D5260))
    }

    @Test
    fun `verify light color scheme is correctly configured`() {
        with(LightColorScheme) {
            assert(primary == Purple40)
            assert(secondary == PurpleGrey40)
            assert(tertiary == Pink40)
        }
    }

    @Test
    fun `verify dark color scheme is correctly configured`() {
        with(DarkColorScheme) {
            assert(primary == Purple80)
            assert(secondary == PurpleGrey80)
            assert(tertiary == Pink80)
        }
    }
}
```

5. Let's test the Typography definitions: