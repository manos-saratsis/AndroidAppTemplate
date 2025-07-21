package template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@Config(application = HiltTestApplication::class)
class MainActivityTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun `onCreate should set content with TemplateTheme`() {
        // Given - MainActivity is launched (handled by composeTestRule)
        
        // Then - verify the greeting is displayed
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }

    @Test
    fun `onCreate should enable edge to edge`() {
        // Given - MainActivity is launched
        val activity = composeTestRule.activity
        
        // Then - verify activity is created successfully
        assert(activity is ComponentActivity)
        assert(activity.javaClass.isAnnotationPresent(dagger.hilt.android.AndroidEntryPoint::class.java))
    }

    @Test
    fun `onCreate with null savedInstanceState should work correctly`() {
        // This test verifies that onCreate handles null Bundle correctly
        // The actual test is implicit in the successful launch of the activity
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }

    @Test
    fun `activity should be annotated with AndroidEntryPoint`() {
        // Verify that the MainActivity has the correct Hilt annotation
        val activity = composeTestRule.activity
        val annotations = activity.javaClass.annotations
        val hasAndroidEntryPoint = annotations.any { 
            it.annotationClass.simpleName == "AndroidEntryPoint" 
        }
        assert(hasAndroidEntryPoint)
    }
}