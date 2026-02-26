package template

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun testGreetingComposableRendersWithName() {
        composeRule.setContent {
            TemplateTheme {
                Greeting("Android")
            }
        }
        composeRule.onNodeWithText("Hello Android!").assertExists()
    }

    @Test
    fun testGreetingComposableWithDifferentName() {
        composeRule.setContent {
            TemplateTheme {
                Greeting("World")
            }
        }
        composeRule.onNodeWithText("Hello World!").assertExists()
    }

    @Test
    fun testGreetingComposableWithEmptyName() {
        composeRule.setContent {
            TemplateTheme {
                Greeting("")
            }
        }
        composeRule.onNodeWithText("Hello !").assertExists()
    }

    @Test
    fun testGreetingComposableWithSpecialCharacters() {
        composeRule.setContent {
            TemplateTheme {
                Greeting("Test@123!")
            }
        }
        composeRule.onNodeWithText("Hello Test@123!!").assertExists()
    }

    @Test
    fun testGreetingComposableWithLongName() {
        val longName = "A".repeat(1000)
        composeRule.setContent {
            TemplateTheme {
                Greeting(longName)
            }
        }
        composeRule.onNodeWithText("Hello $longName!").assertExists()
    }

    @Test
    fun testGreetingComposableWithUnicodeCharacters() {
        composeRule.setContent {
            TemplateTheme {
                Greeting("你好")
            }
        }
        composeRule.onNodeWithText("Hello 你好!").assertExists()
    }

    @Test
    fun testGreetingComposableWithNumericString() {
        composeRule.setContent {
            TemplateTheme {
                Greeting("12345")
            }
        }
        composeRule.onNodeWithText("Hello 12345!").assertExists()
    }

    @Test
    fun testGreetingComposableWithWhitespace() {
        composeRule.setContent {
            TemplateTheme {
                Greeting("   ")
            }
        }
        composeRule.onNodeWithText("Hello    !").assertExists()
    }

    @Test
    fun testGreetingTextStyleApplied() {
        composeRule.setContent {
            TemplateTheme {
                Greeting("Android")
            }
        }
        composeRule.onNodeWithText("Hello Android!").assertExists()
    }

    @Test
    fun testGreetingIntegrationWithTheme() {
        composeRule.setContent {
            TemplateTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Greeting("Integration")
                }
            }
        }
        composeRule.onNodeWithText("Hello Integration!").assertExists()
    }
}