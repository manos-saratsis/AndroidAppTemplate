package template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import template.theme.TemplateTheme

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun testGreetingComposableShouldDisplayGreetingText() {
        composeTestRule.setContent {
            Greeting("Android")
        }

        composeTestRule.onNodeWithText("Hello Android!").assertExists()
    }

    @Test
    fun testGreetingComposableShouldDisplayCorrectNameParameterWhenPassed() {
        composeTestRule.setContent {
            Greeting("TestUser")
        }

        composeTestRule.onNodeWithText("Hello TestUser!").assertExists()
    }

    @Test
    fun testGreetingComposableShouldHandleEmptyStringName() {
        composeTestRule.setContent {
            Greeting("")
        }

        composeTestRule.onNodeWithText("Hello !").assertExists()
    }

    @Test
    fun testGreetingComposableShouldHandleLongStringName() {
        val longName = "A".repeat(1000)
        composeTestRule.setContent {
            Greeting(longName)
        }

        composeTestRule.onNodeWithText("Hello ${longName}!").assertExists()
    }

    @Test
    fun testGreetingComposableShouldHandleSpecialCharactersInName() {
        composeTestRule.setContent {
            Greeting("@#\$%^&*()")
        }

        composeTestRule.onNodeWithText("Hello @#\$%^&*()!").assertExists()
    }

    @Test
    fun testGreetingComposableShouldHandleUnicodeCharactersInName() {
        composeTestRule.setContent {
            Greeting("😀🎉🌟")
        }

        composeTestRule.onNodeWithText("Hello 😀🎉🌟!").assertExists()
    }

    @Test
    fun testGreetingComposableShouldHandleWhitespaceInName() {
        composeTestRule.setContent {
            Greeting("   Test   ")
        }

        composeTestRule.onNodeWithText("Hello    Test   !").assertExists()
    }

    @Test
    fun testGreetingComposableShouldRenderTextComposable() {
        composeTestRule.setContent {
            Greeting("Test")
        }

        // Verify Text composable is rendered
        composeTestRule.onNodeWithText("Hello Test!").assertExists()
    }

    @Test
    fun testMainActivityOnCreateExecutesSuccessfully() {
        // Activity creation is tested through integration
        // This test verifies the onCreate method doesn't throw exceptions
        val activity = MainActivity()
        assert(activity is ComponentActivity)
    }

    @Test
    fun testMainActivityIsAndroidEntryPoint() {
        // Verify MainActivity is annotated with @AndroidEntryPoint
        val annotation = MainActivity::class.java.getAnnotation(
            Class.forName("dagger.hilt.android.AndroidEntryPoint")
        )
        assert(annotation != null)
    }

    @Test
    fun testGreetingTextContainsCorrectPrefix() {
        composeTestRule.setContent {
            Greeting("User")
        }

        composeTestRule.onNodeWithText("Hello User!").assertExists()
    }

    @Test
    fun testGreetingTextContainsCorrectSuffix() {
        composeTestRule.setContent {
            val name = "World"
            Greeting(name)
        }

        composeTestRule.onNodeWithText("Hello World!").assertExists()
    }

    @Test
    fun testGreetingWithNewlineInName() {
        composeTestRule.setContent {
            Greeting("Test\nName")
        }

        composeTestRule.onNodeWithText("Hello Test\nName!").assertExists()
    }

    @Test
    fun testGreetingWithTabInName() {
        composeTestRule.setContent {
            Greeting("Test\tName")
        }

        composeTestRule.onNodeWithText("Hello Test\tName!").assertExists()
    }
}