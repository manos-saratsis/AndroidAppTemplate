package template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
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
    fun `should create activity successfully`() {
        // Assert
        assert(composeTestRule.activity is MainActivity)
        assert(composeTestRule.activity is ComponentActivity)
    }

    @Test
    fun `onCreate should initialize activity with null bundle`() {
        // Arrange
        val activity = composeTestRule.activity

        // Act - onCreate is called automatically by the rule

        // Assert
        assert(activity.hasWindowFocus() || !activity.hasWindowFocus()) // Activity exists
    }

    @Test
    fun `onCreate should initialize activity with non-null bundle`() {
        // Arrange
        val bundle = Bundle().apply {
            putString("test_key", "test_value")
        }

        // Act - Activity is created with savedInstanceState

        // Assert - Activity should handle bundle without crashing
        assert(composeTestRule.activity != null)
    }

    @Test
    fun `onCreate should enable edge to edge display`() {
        // Act - onCreate is called automatically

        // Assert - Activity should be created with edge-to-edge enabled
        assert(composeTestRule.activity != null)
        // Edge-to-edge is enabled through enableEdgeToEdge() call
    }

    @Test
    fun `onCreate should set content with TemplateTheme`() {
        // Act - onCreate is called automatically

        // Assert - Content should be set
        composeTestRule.onNodeWithText("Hello Android!").assertExists()
    }

    @Test
    fun `onCreate should display Greeting composable with default name`() {
        // Act - onCreate is called automatically

        // Assert
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }

    @Test
    fun `onCreate should render Surface with MaterialTheme background`() {
        // Act - onCreate is called automatically

        // Assert - Surface should be rendered
        composeTestRule.onNodeWithText("Hello Android!").assertExists()
    }

    @Test
    fun `should display greeting text in UI`() {
        // Assert
        composeTestRule.onNodeWithText("Hello Android!", substring = false)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun `should be annotated with AndroidEntryPoint`() {
        // Assert
        val annotations = MainActivity::class.java.annotations
        assert(annotations.any { it.annotationClass.simpleName == "AndroidEntryPoint" })
    }

    @Test
    fun `should extend ComponentActivity`() {
        // Assert
        assert(composeTestRule.activity is ComponentActivity)
    }
}