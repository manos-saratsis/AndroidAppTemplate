```kotlin
package template

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import androidx.compose.ui.test.*
import androidx.lifecycle.Lifecycle
import org.junit.Before
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun mainActivity_launches_successfully() {
        // Verify that the activity launches without crashing
        composeTestRule.activity.let { activity ->
            assertNotNull(activity)
            assertTrue(activity.lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED))
        }
    }

    @Test
    fun mainActivity_displays_content() {
        // Test that the main content is displayed
        composeTestRule.onRoot().assertIsDisplayed()
    }

    @Test
    fun mainActivity_applies_theme() {
        // Verify that the theme is properly applied
        composeTestRule.activity.let { activity ->
            assertNotNull(activity.theme)
        }
    }

    @Test
    fun mainActivity_handles_configuration_changes() {
        // Test configuration changes
        composeTestRule.activity.let { activity ->
            activity.recreate()
            assertTrue(activity.lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED))
        }
    }

    @Test
    fun mainActivity_onCreate_setsContent() {
        // Verify that onCreate sets the content view
        composeTestRule.activity.let { activity ->
            assertNotNull(activity.findViewById(android.R.id.content))
        }
    }
}
```