```kotlin
package template.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ThemeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test theme colors`() {
        composeTestRule.setContent {
            TemplateTheme {
                // Verify theme colors are applied correctly
                assert(MaterialTheme.colors.primary == Purple200)
                assert(MaterialTheme.colors.primaryVariant == Purple700)
                assert(MaterialTheme.colors.secondary == Teal200)
            }
        }
    }

    @Test
    fun `test dark theme colors`() {
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true) {
                // Verify dark theme colors
                assert(MaterialTheme.colors.isLight == false)
            }
        }
    }
}
```