```kotlin
package template.theme

import org.junit.Test

class ColorTest {
    @Test
    fun `verify color values`() {
        assert(Purple200.value != 0L)
        assert(Purple500.value != 0L)
        assert(Purple700.value != 0L)
        assert(Teal200.value != 0L)
    }
}
```