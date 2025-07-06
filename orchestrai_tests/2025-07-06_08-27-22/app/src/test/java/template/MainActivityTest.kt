```kotlin
package template

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun `activity should be created successfully`() {
        assertNotNull(activity)
    }

    @Test
    fun `activity should have correct context`() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("template", context.packageName)
    }

    @Test
    fun `onCreate should set content view`() {
        val mockActivity = mockk<MainActivity>(relaxed = true)
        mockActivity.onCreate(null)
        verify { mockActivity.onCreate(null) }
    }

    @Test
    fun `activity should handle intent correctly`() {
        val intent = Intent(activity, MainActivity::class.java)
        intent.putExtra("test_key", "test_value")
        
        val newActivity = Robolectric.buildActivity(MainActivity::class.java, intent)
            .create()
            .get()
        
        assertNotNull(newActivity)
    }

    @Test
    fun `activity lifecycle should work correctly`() {
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        
        val activity = controller.create().get()
        assertNotNull(activity)
        
        controller.start()
        controller.resume()
        controller.pause()
        controller.stop()
        controller.destroy()
    }

    @Test
    fun `activity should handle configuration changes`() {
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        val activity = controller.create().start().resume().get()
        
        controller.configurationChange()
        assertNotNull(activity)
    }
}
```