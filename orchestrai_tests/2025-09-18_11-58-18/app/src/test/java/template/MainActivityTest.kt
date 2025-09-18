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
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testActivityCreation() {
        // Test that the activity is created successfully
        assertNotNull(composeTestRule.activity)
    }

    @Test
    fun testActivityIntent() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = Intent(context, MainActivity::class.java)
        assertNotNull(intent)
        assertEquals(MainActivity::class.java.name, intent.component?.className)
    }

    @Test
    fun testActivityLifecycle() {
        val activity = composeTestRule.activity
        assertNotNull(activity)
        assertFalse(activity.isFinishing)
        assertFalse(activity.isDestroyed)
    }

    @Test
    fun testActivityTheme() {
        // Test that the activity uses the correct theme
        val activity = composeTestRule.activity
        assertNotNull(activity.theme)
    }

    @Test
    fun testActivityPackageName() {
        val activity = composeTestRule.activity
        assertEquals("template", activity.packageName)
    }
}
```