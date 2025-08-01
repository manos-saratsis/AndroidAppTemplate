```kotlin
package template

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import org.junit.Before
import org.junit.After

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
        if (::activityScenario.isInitialized) {
            activityScenario.close()
        }
    }

    @Test
    fun testActivityCreation() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity { activity ->
            assertNotNull(activity)
            assertTrue(activity is MainActivity)
        }
    }

    @Test
    fun testActivityLifecycleStates() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        
        // Test CREATED state
        assertEquals(Lifecycle.State.RESUMED, activityScenario.state)
        
        // Test pause
        activityScenario.moveToState(Lifecycle.State.STARTED)
        assertEquals(Lifecycle.State.STARTED, activityScenario.state)
        
        // Test resume
        activityScenario.moveToState(Lifecycle.State.RESUMED)
        assertEquals(Lifecycle.State.RESUMED, activityScenario.state)
    }

    @Test
    fun testActivityDestroy() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.moveToState(Lifecycle.State.DESTROYED)
        assertEquals(Lifecycle.State.DESTROYED, activityScenario.state)
    }

    @Test
    fun testActivityRecreation() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.recreate()
        
        activityScenario.onActivity { activity ->
            assertNotNull(activity)
            assertEquals(Lifecycle.State.RESUMED, activityScenario.state)
        }
    }

    @Test
    fun testComposeContent() {
        composeTestRule.onRoot().assertExists()
    }
}
```