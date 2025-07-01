```kotlin
package template.theme

import androidx.compose.material.Typography
import org.junit.Test

class TypeTest {
    @Test
    fun `typography is correctly configured`() {
        assert(Typography is androidx.compose.material.Typography)
        // Verify specific font settings
        assert(Typography.h1 == androidx.compose.material.Typography().h1)
        assert(Typography.body1 == androidx.compose.material.Typography().body1)
    }
}
```