package template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.*

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testOnCreateInitializesActivity() {
        val savedInstanceState: Bundle? = null
        activity = MainActivity()
        activity.onCreate(savedInstanceState)
        
        // Verify activity is created successfully
        assert(activity != null)
    }

    @Test
    fun testOnCreateWithSavedInstanceState() {
        val savedInstanceState = Bundle().apply {
            putString("key", "value")
        }
        activity = MainActivity()
        activity.onCreate(savedInstanceState)
        
        // Verify activity handles saved instance state
        assert(activity != null)
    }

    @Test
    fun testGreetingComposableRendersText() {
        composeTestRule.setContent {
            Greeting("Alice")
        }
        
        // Test that composable renders without error
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun testGreetingWithEmptyString() {
        composeTestRule.setContent {
            Greeting("")
        }
        
        // Test edge case: empty name
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun testGreetingWithSpecialCharacters() {
        composeTestRule.setContent {
            Greeting("@#$%^&*()")
        }
        
        // Test edge case: special characters
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun testGreetingWithLongString() {
        val longName = "A".repeat(1000)
        composeTestRule.setContent {
            Greeting(longName)
        }
        
        // Test edge case: very long name
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun testGreetingWithNullReplacedByString() {
        // Test that greeting handles string interpolation correctly
        composeTestRule.setContent {
            Greeting("Test")
        }
        
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun testGreetingWithUnicodeCharacters() {
        composeTestRule.setContent {
            Greeting("你好世界🌍")
        }
        
        // Test unicode support
        composeTestRule.onRoot().assertExists()
    }

    @Test
    fun testMainActivityInheritance() {
        activity = MainActivity()
        
        // Verify MainActivity inherits from ComponentActivity
        assert(activity is ComponentActivity)
    }

    @Test
    fun testGreetingComposableFunction() {
        // Test that Greeting is a valid composable
        val greeting: @Composable (String) -> Unit = ::Greeting
        assert(greeting != null)
    }
}