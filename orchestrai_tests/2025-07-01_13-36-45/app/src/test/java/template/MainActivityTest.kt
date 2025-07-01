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
        
        // Verify the main composable is displayed
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun `activity lifecycle methods work correctly`() {
        val activity = MainActivity()
        activity.onCreate(null)
        activity.onResume()
        activity.onPause()
        activity.onDestroy()
        // No exceptions should be thrown
    }
}
```

Let's create tests for the TemplateApp: