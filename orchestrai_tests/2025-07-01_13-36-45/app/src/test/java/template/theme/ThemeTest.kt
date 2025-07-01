```kotlin
package template.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class ThemeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `TemplateTheme applies correct theme colors`() {
        composeTestRule.setContent {
            TemplateTheme {
                MaterialTheme.colors.apply {
                    assert(primary == Purple500)
                    assert(primaryVariant == Purple700)
                    assert(secondary == Teal200)
                }
            }
        }
    }

    @Test
    fun `TemplateTheme applies correct typography`() {
        composeTestRule.setContent {
            TemplateTheme {
                assert(MaterialTheme.typography == Typography)
            }
        }
    }

    @Test
    fun `TemplateTheme applies correct shapes`() {
        composeTestRule.setContent {
            TemplateTheme {
                assert(MaterialTheme.shapes == Shapes)
            }
        }
    }
}
```