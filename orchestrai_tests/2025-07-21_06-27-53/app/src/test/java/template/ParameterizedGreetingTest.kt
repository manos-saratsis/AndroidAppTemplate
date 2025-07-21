package template

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import template.theme.TemplateTheme
import template.utils.TestUtils

@RunWith(Parameterized::class)
class ParameterizedGreetingTest(
    private val testName: String,
    private val expectedText: String
) {

    @get:Rule
    val composeTestRule = createComposeRule()

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "name={0}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("Android", "Hello Android!"),
                arrayOf("World", "Hello World!"),
                arrayOf("Test", "Hello Test!"),
                arrayOf("", "Hello !"),
                arrayOf("123", "Hello 123!"),
                arrayOf("Special@Chars", "Hello Special@Chars!"),
                arrayOf("世界", "Hello 世界!")
            )
        }
    }

    @Test
    fun `greeting displays correct text for various inputs`() {
        // When
        composeTestRule.setContent {
            TemplateTheme {
                Greeting(name = testName)
            }
        }
        
        // Then
        composeTestRule.onNodeWithText(expectedText).assertIsDisplayed()
    }
}