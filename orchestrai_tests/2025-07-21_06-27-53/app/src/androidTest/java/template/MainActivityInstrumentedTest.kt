package template

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun mainActivityDisplaysGreetingCorrectly() {
        // Verify that the greeting is displayed on the actual device/emulator
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }

    @Test
    fun mainActivityLaunchesSuccessfully() {
        // Verify that the activity launches without crashing
        val activity = composeTestRule.activity
        assert(activity != null)
        assert(!activity.isFinishing)
        assert(!activity.isDestroyed)
    }

    @Test
    fun templateThemeIsAppliedCorrectly() {
        // Verify that the theme is applied and content is visible
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
        
        // Wait for any animations or compositions to complete
        composeTestRule.waitForIdle()
    }
}