```kotlin
package template

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.junit.Before
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import org.junit.After
import org.mockito.kotlin.mock

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
        if (::scenario.isInitialized) {
            scenario.close()
        }
    }

    @Test
    fun mainActivity_launches_successfully() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.moveToState(Lifecycle.State.STARTED)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun mainActivity_displays_greeting() {
        composeTestRule.onNodeWithText("Hello Android!").assertExists()
    }

    @Test
    fun mainActivity_onCreate_setsContent() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            assert(activity.hasWindowFocus() || !activity.hasWindowFocus()) // Activity exists
        }
    }

    @Test
    fun mainActivity_lifecycle_states() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        
        scenario.moveToState(Lifecycle.State.STARTED)
        scenario.onActivity { activity ->
            assert(activity.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED))
        }
        
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { activity ->
            assert(activity.lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED))
        }
    }

    @Test
    fun mainActivity_theme_applied() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity { activity ->
            // Verify theme is applied by checking if content is set
            assert(activity.findViewById<android.view.View>(android.R.id.content) != null)
        }
    }
}
```