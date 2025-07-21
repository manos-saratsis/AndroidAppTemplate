package template.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import template.theme.TemplateTheme

/**
 * Utility functions for testing
 */
object TestUtils {
    
    /**
     * Sets content with TemplateTheme wrapper for consistent testing
     */
    fun ComposeContentTestRule.setContentWithTheme(
        content: @Composable () -> Unit
    ) {
        setContent {
            TemplateTheme {
                content()
            }
        }
    }
    
    /**
     * Validates that a string follows the greeting format
     */
    fun isValidGreetingFormat(text: String, expectedName: String): Boolean {
        return text == "Hello $expectedName!"
    }
    
    /**
     * Generates test names for parameterized tests
     */
    fun generateTestNames(): List<String> {
        return listOf(
            "Android",
            "World",
            "Test",
            "",
            "123",
            "Special@Chars",
            "Very Long Name That Should Work",
            "世界"
        )
    }
}