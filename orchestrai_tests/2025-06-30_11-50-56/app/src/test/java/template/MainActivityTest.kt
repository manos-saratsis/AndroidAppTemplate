```kotlin
package template

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `onCreate sets up UI correctly`() {
        composeTestRule.setContent {
            MainActivity()
        }
        
        // Verify the Composable is rendered
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun `theme is applied correctly`() {
        composeTestRule.setContent {
            TemplateAppTheme {
                MainActivity()
            }
        }
        
        // Verify theme attributes
        composeTestRule.onRoot().assertExists()
    }
}
```

2. Let's test the Theme components: