```kotlin
package template

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.junit.Before
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import org.junit.After
import org.junit.Assert.*

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
        
        scenario.onActivity { activity ->
            assertNotNull(activity)
            assertTrue(activity is ComponentActivity)
        }
    }

    @Test
    fun mainActivity_displays_greeting_text() {
        composeTestRule.onNodeWithText("Hello Android!")
            .assertIsDisplayed()
    }

    @Test
    fun mainActivity_displays_template_content() {
        composeTestRule.onNodeWithText("Android App Template")
            .assertIsDisplayed()
    }

    @Test
    fun mainActivity_theme_is_applied() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        
        scenario.onActivity { activity ->
            assertNotNull(activity.theme)
        }
    }

    @Test
    fun mainActivity_handles_configuration_changes() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        
        scenario.recreate()
        
        scenario.onActivity { activity ->
            assertNotNull(activity)
            assertEquals(Lifecycle.State.RESUMED, scenario.state)
        }
    }

    @Test
    fun mainActivity_onCreate_sets_content() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        
        scenario.onActivity { activity ->
            assertNotNull(activity.findViewById(android.R.id.content))
        }
    }

    @Test
    fun mainActivity_lifecycle_states() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        
        assertEquals(Lifecycle.State.RESUMED, scenario.state)
        
        scenario.moveToState(Lifecycle.State.STARTED)
        assertEquals(Lifecycle.State.STARTED, scenario.state)
        
        scenario.moveToState(Lifecycle.State.CREATED)
        assertEquals(Lifecycle.State.CREATED, scenario.state)
    }
}
```