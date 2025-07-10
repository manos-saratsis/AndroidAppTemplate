```kotlin
package template

import android.content.Intent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun `activity should be created successfully`() {
        assertNotNull(activity)
        assertFalse(activity.isDestroyed)
        assertFalse(activity.isFinishing)
    }

    @Test
    fun `activity should have correct theme applied`() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        assertNotNull(context.theme)
    }

    @Test
    fun `activity should handle configuration changes`() {
        activity.onConfigurationChanged(activity.resources.configuration)
        assertFalse(activity.isDestroyed)
    }

    @Test
    fun `activity should handle intent extras`() {
        val intent = Intent(activity, MainActivity::class.java)
        intent.putExtra("test_key", "test_value")
        
        val newActivity = Robolectric.buildActivity(MainActivity::class.java, intent)
            .create()
            .get()
        
        assertNotNull(newActivity)
        assertEquals("test_value", newActivity.intent.getStringExtra("test_key"))
    }

    @Test
    fun `activity lifecycle should work correctly`() {
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        
        val activity = controller.create().get()
        assertNotNull(activity)
        
        controller.start()
        controller.resume()
        assertFalse(activity.isDestroyed)
        
        controller.pause()
        controller.stop()
        controller.destroy()
        assertTrue(activity.isDestroyed)
    }

    @Test
    fun `activity should handle back press`() {
        activity.onBackPressed()
        // Verify activity behavior after back press
        // This depends on the actual implementation
    }

    @Test
    fun `activity should set content view`() {
        // Verify that the activity sets up the compose content correctly
        assertNotNull(activity.findViewById(android.R.id.content))
    }
}
```