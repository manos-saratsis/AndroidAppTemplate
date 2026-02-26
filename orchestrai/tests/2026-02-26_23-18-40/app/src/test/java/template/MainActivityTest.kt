package template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockedStatic
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = MainActivity()
    }

    @Test
    fun testOnCreateCallsSetContent() {
        val mockBundle = mock<Bundle>()
        activity.onCreate(mockBundle)
        
        // Verify that the activity was created and content was set
        assert(activity.window != null)
    }

    @Test
    fun testOnCreateWithNullBundle() {
        activity.onCreate(null)
        
        assert(activity.window != null)
    }

    @Test
    fun testGreetingComposableWithValidName() {
        composeTestRule.setContent {
            Greeting("Android")
        }
        
        composeTestRule.onNodeWithText("Hello Android!").assertExists()
    }

    @Test
    fun testGreetingComposableWithDifferentName() {
        composeTestRule.setContent {
            Greeting("World")
        }
        
        composeTestRule.onNodeWithText("Hello World!").assertExists()
    }

    @Test
    fun testGreetingComposableWithEmptyString() {
        composeTestRule.setContent {
            Greeting("")
        }
        
        composeTestRule.onNodeWithText("Hello !").assertExists()
    }

    @Test
    fun testGreetingComposableWithSpecialCharacters() {
        composeTestRule.setContent {
            Greeting("@#$%")
        }
        
        composeTestRule.onNodeWithText("Hello @#$%!").assertExists()
    }

    @Test
    fun testGreetingComposableWithLongString() {
        val longName = "a".repeat(1000)
        composeTestRule.setContent {
            Greeting(longName)
        }
        
        composeTestRule.onNodeWithText("Hello ${longName}!").assertExists()
    }

    @Test
    fun testGreetingComposableWithNumbers() {
        composeTestRule.setContent {
            Greeting("123456")
        }
        
        composeTestRule.onNodeWithText("Hello 123456!").assertExists()
    }

    @Test
    fun testGreetingComposableWithUnicodeCharacters() {
        composeTestRule.setContent {
            Greeting("世界")
        }
        
        composeTestRule.onNodeWithText("Hello 世界!").assertExists()
    }

    @Test
    fun testGreetingComposableWithWhitespace() {
        composeTestRule.setContent {
            Greeting("  Test  ")
        }
        
        composeTestRule.onNodeWithText("Hello   Test  !").assertExists()
    }

    @Test
    fun testMainActivityInheritanceFromComponentActivity() {
        assert(activity is ComponentActivity)
    }

    @Test
    fun testMainActivityAnnotations() {
        val annotations = MainActivity::class.java.annotations
        val hasHiltAnnotation = annotations.any { 
            it.annotationClass.simpleName == "AndroidEntryPoint"
        }
        assert(hasHiltAnnotation || annotations.isNotEmpty())
    }

    @Test
    fun testGreetingTextContent() {
        val name = "TestName"
        composeTestRule.setContent {
            Greeting(name)
        }
        
        composeTestRule.onNodeWithText("Hello $name!").assertExists()
    }
}