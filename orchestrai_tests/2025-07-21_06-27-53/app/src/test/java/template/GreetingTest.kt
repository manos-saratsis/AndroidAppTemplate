package template

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import template.theme.TemplateTheme

@RunWith(AndroidJUnit4::class)
class GreetingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `greeting displays correct text with given name`() {
        // Given
        val testName = "Android"
        
        // When
        composeTestRule.setContent {
            TemplateTheme {
                Greeting(name = testName)
            }
        }
        
        // Then
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }

    @Test
    fun `greeting displays correct text with custom name`() {
        // Given
        val testName = "World"
        
        // When
        composeTestRule.setContent {
            TemplateTheme {
                Greeting(name = testName)
            }
        }
        
        // Then
        composeTestRule.onNodeWithText("Hello World!").assertIsDisplayed()
    }

    @Test
    fun `greeting displays correct text with empty name`() {
        // Given
        val testName = ""
        
        // When
        composeTestRule.setContent {
            TemplateTheme {
                Greeting(name = testName)
            }
        }
        
        // Then
        composeTestRule.onNodeWithText("Hello !").assertIsDisplayed()
    }

    @Test
    fun `greeting displays correct text with special characters`() {
        // Given
        val testName = "Test@123"
        
        // When
        composeTestRule.setContent {
            TemplateTheme {
                Greeting(name = testName)
            }
        }
        
        // Then
        composeTestRule.onNodeWithText("Hello Test@123!").assertIsDisplayed()
    }

    @Test
    fun `greeting displays correct text with long name`() {
        // Given
        val testName = "Very Long Name That Should Still Work Correctly"
        
        // When
        composeTestRule.setContent {
            TemplateTheme {
                Greeting(name = testName)
            }
        }
        
        // Then
        composeTestRule.onNodeWithText("Hello Very Long Name That Should Still Work Correctly!").assertIsDisplayed()
    }

    @Test
    fun `greeting displays correct text with unicode characters`() {
        // Given
        val testName = "世界"
        
        // When
        composeTestRule.setContent {
            TemplateTheme {
                Greeting(name = testName)
            }
        }
        
        // Then
        composeTestRule.onNodeWithText("Hello 世界!").assertIsDisplayed()
    }
}