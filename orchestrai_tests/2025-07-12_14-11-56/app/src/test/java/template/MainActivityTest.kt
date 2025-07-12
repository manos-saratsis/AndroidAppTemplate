```kotlin
package template

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Mock
    private lateinit var mockContext: Context

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testActivityCreation() {
        scenario.onActivity { activity ->
            assertNotNull(activity)
            assertTrue(activity is ComponentActivity)
        }
    }

    @Test
    fun testActivityLifecycle() {
        scenario.moveToState(Lifecycle.State.CREATED)
        scenario.onActivity { activity ->
            assertEquals(Lifecycle.State.CREATED, activity.lifecycle.currentState)
        }

        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { activity ->
            assertEquals(Lifecycle.State.RESUMED, activity.lifecycle.currentState)
        }
    }

    @Test
    fun testComposeContentIsDisplayed() {
        composeTestRule.onNodeWithText("Android App Template")
            .assertIsDisplayed()
    }

    @Test
    fun testThemeApplication() {
        scenario.onActivity { activity ->
            val context = InstrumentationRegistry.getInstrumentation().targetContext
            assertNotNull(context.theme)
        }
    }

    @Test
    fun testActivityRecreation() {
        scenario.recreate()
        scenario.onActivity { activity ->
            assertNotNull(activity)
            assertEquals(Lifecycle.State.RESUMED, activity.lifecycle.currentState)
        }
    }

    @Test
    fun testActivityFinish() {
        scenario.onActivity { activity ->
            activity.finish()
        }
        assertEquals(Lifecycle.State.DESTROYED, scenario.state)
    }
}
```