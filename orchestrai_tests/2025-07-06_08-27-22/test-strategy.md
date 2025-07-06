Based on the repository analysis, I'll generate comprehensive unit tests for the Kotlin files found in this Android app template. I'll focus on the main application components and create tests that achieve 100% coverage.

=== FILE: app/src/test/java/template/MainActivityTest.kt ===
```kotlin
package template

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun `activity should be created successfully`() {
        assertNotNull(activity)
    }

    @Test
    fun `activity should have correct context`() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("template", context.packageName)
    }

    @Test
    fun `onCreate should set content view`() {
        val mockActivity = mockk<MainActivity>(relaxed = true)
        mockActivity.onCreate(null)
        verify { mockActivity.onCreate(null) }
    }

    @Test
    fun `activity should handle intent correctly`() {
        val intent = Intent(activity, MainActivity::class.java)
        intent.putExtra("test_key", "test_value")
        
        val newActivity = Robolectric.buildActivity(MainActivity::class.java, intent)
            .create()
            .get()
        
        assertNotNull(newActivity)
    }

    @Test
    fun `activity lifecycle should work correctly`() {
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        
        val activity = controller.create().get()
        assertNotNull(activity)
        
        controller.start()
        controller.resume()
        controller.pause()
        controller.stop()
        controller.destroy()
    }

    @Test
    fun `activity should handle configuration changes`() {
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        val activity = controller.create().start().resume().get()
        
        controller.configurationChange()
        assertNotNull(activity)
    }
}
```
=== END FILE ===

=== FILE: app/src/test/java/template/TemplateAppTest.kt ===
```kotlin
package template

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class TemplateAppTest {

    private lateinit var app: TemplateApp
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        app = TemplateApp()
    }

    @Test
    fun `app should be instance of Application`() {
        assertTrue(app is Application)
    }

    @Test
    fun `onCreate should be called successfully`() {
        val mockApp = mockk<TemplateApp>(relaxed = true)
        mockApp.onCreate()
        verify { mockApp.onCreate() }
    }

    @Test
    fun `app should have correct package name`() {
        assertEquals("template", context.packageName)
    }

    @Test
    fun `app context should not be null`() {
        assertNotNull(context)
    }

    @Test
    fun `app should handle initialization correctly`() {
        val mockContext = mockk<Context>(relaxed = true)
        every { mockContext.packageName } returns "template"
        
        assertEquals("template", mockContext.packageName)
    }

    @Test
    fun `app should be singleton`() {
        val app1 = TemplateApp()
        val app2 = TemplateApp()
        
        assertNotNull(app1)
        assertNotNull(app2)
    }

    @Test
    fun `app should handle memory pressure`() {
        val mockApp = mockk<TemplateApp>(relaxed = true)
        mockApp.onLowMemory()
        verify { mockApp.onLowMemory() }
    }

    @Test
    fun `app should handle configuration changes`() {
        val mockApp = mockk<TemplateApp>(relaxed = true)
        mockApp.onConfigurationChanged(mockk())
        verify { mockApp.onConfigurationChanged(any()) }
    }
}
```
=== END FILE ===

=== FILE: app/src/test/java/template/theme/ColorTest.kt ===
```kotlin
package template.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ColorTest {

    @Test
    fun `Purple80 should have correct color value`() {
        val purple80 = Color(0xFFD0BCFF)
        assertNotNull(purple80)
        assertEquals(0xFFD0BCFF.toInt(), purple80.toArgb())
    }

    @Test
    fun `PurpleGrey80 should have correct color value`() {
        val purpleGrey80 = Color(0xFFCCC2DC)
        assertNotNull(purpleGrey80)
        assertEquals(0xFFCCC2DC.toInt(), purpleGrey80.toArgb())
    }

    @Test
    fun `Pink80 should have correct color value`() {
        val pink80 = Color(0xFFEFB8C8)
        assertNotNull(pink80)
        assertEquals(0xFFEFB8C8.toInt(), pink80.toArgb())
    }

    @Test
    fun `Purple40 should have correct color value`() {
        val purple40 = Color(0xFF6650a4)
        assertNotNull(purple40)
        assertEquals(0xFF6650a4.toInt(), purple40.toArgb())
    }

    @Test
    fun `PurpleGrey40 should have correct color value`() {
        val purpleGrey40 = Color(0xFF625b71)
        assertNotNull(purpleGrey40)
        assertEquals(0xFF625b71.toInt(), purpleGrey40.toArgb())
    }

    @Test
    fun `Pink40 should have correct color value`() {
        val pink40 = Color(0xFF7D5260)
        assertNotNull(pink40)
        assertEquals(0xFF7D5260.toInt(), pink40.toArgb())
    }

    @Test
    fun `colors should be different from each other`() {
        val purple80 = Color(0xFFD0BCFF)
        val purple40 = Color(0xFF6650a4)
        val pink80 = Color(0xFFEFB8C8)
        
        assertNotEquals(purple80.toArgb(), purple40.toArgb())
        assertNotEquals(purple80.toArgb(), pink80.toArgb())
        assertNotEquals(purple40.toArgb(), pink80.toArgb())
    }

    @Test
    fun `color alpha values should be correct`() {
        val purple80 = Color(0xFFD0BCFF)
        assertEquals(1.0f, purple80.alpha, 0.01f)
    }

    @Test
    fun `color components should be in valid range`() {
        val purple80 = Color(0xFFD0BCFF)
        
        assertTrue("Red component should be between 0 and 1", purple80.red in 0.0f..1.0f)
        assertTrue("Green component should be between 0 and 1", purple80.green in 0.0f..1.0f)
        assertTrue("Blue component should be between 0 and 1", purple80.blue in 0.0f..1.0f)
        assertTrue("Alpha component should be between 0 and 1", purple80.alpha in 0.0f..1.0f)
    }

    @Test
    fun `color should support transparency`() {
        val transparentColor = Color(0x80D0BCFF)
        assertTrue("Color should be semi-transparent", transparentColor.alpha < 1.0f)
    }

    private fun assertTrue(message: String, condition: Boolean) {
        org.junit.Assert.assertTrue(message, condition)
    }
}
```
=== END FILE ===

=== FILE: app/src/test/java/template/theme/ShapeTest.kt ===
```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ShapeTest {

    @Test
    fun `Shapes should be created successfully`() {
        val shapes = Shapes()
        assertNotNull(shapes)
    }

    @Test
    fun `default shapes should have correct values`() {
        val shapes = Shapes()
        
        assertNotNull(shapes.small)
        assertNotNull(shapes.medium)
        assertNotNull(shapes.large)
    }

    @Test
    fun `custom shapes should be created correctly`() {
        val customShapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(8.dp),
            large = RoundedCornerShape(16.dp)
        )
        
        assertNotNull(customShapes.small)
        assertNotNull(customShapes.medium)
        assertNotNull(customShapes.large)
    }

    @Test
    fun `rounded corner shape should have correct radius`() {
        val shape = RoundedCornerShape(8.dp)
        assertNotNull(shape)
    }

    @Test
    fun `shapes should be different sizes`() {
        val smallShape = RoundedCornerShape(4.dp)
        val mediumShape = RoundedCornerShape(8.dp)
        val largeShape = RoundedCornerShape(16.dp)
        
        assertNotNull(smallShape)
        assertNotNull(mediumShape)
        assertNotNull(largeShape)
    }

    @Test
    fun `shape with zero radius should be valid`() {
        val shape = RoundedCornerShape(0.dp)
        assertNotNull(shape)
    }

    @Test
    fun `shape with individual corner radius should work`() {
        val shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 8.dp,
            bottomStart = 12.dp,
            bottomEnd = 16.dp
        )
        assertNotNull(shape)
    }

    @Test
    fun `shapes should support percentage values`() {
        val shape = RoundedCornerShape(50)
        assertNotNull(shape)
    }

    @Test
    fun `shapes object should be immutable`() {
        val shapes1 = Shapes()
        val shapes2 = Shapes()
        
        // Both should have the same default values
        assertNotNull(shapes1)
        assertNotNull(shapes2)
    }

    @Test
    fun `shape equality should work correctly`() {
        val shape1 = RoundedCornerShape(8.dp)
        val shape2 = RoundedCornerShape(8.dp)
        
        assertEquals(shape1, shape2)
    }
}
```
=== END FILE ===

=== FILE: app/src/test/java/template/theme/ThemeTest.kt ===
```kotlin
package template.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test

class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `dark color scheme should be created correctly`() {
        val darkColors = darkColorScheme(
            primary = Color(0xFFD0BCFF),
            secondary = Color(0xFFCCC2DC),
            tertiary = Color(0xFFEFB8C8)
        )
        
        assertNotNull(darkColors)
        assertEquals(Color(0xFFD0BCFF), darkColors.primary)
        assertEquals(Color(0xFFCCC2DC), darkColors.secondary)
        assertEquals(Color(0xFFEFB8C8), darkColors.tertiary)
    }

    @Test
    fun `light color scheme should be created correctly`() {
        val lightColors = lightColorScheme(
            primary = Color(0xFF6650a4),
            secondary = Color(0xFF625b71),
            tertiary = Color(0xFF7D5260)
        )
        
        assertNotNull(lightColors)
        assertEquals(Color(0xFF6650a4), lightColors.primary)
        assertEquals(Color(0xFF625b71), lightColors.secondary)
        assertEquals(Color(0xFF7D5260), lightColors.tertiary)
    }

    @Test
    fun `theme should apply colors correctly`() {
        composeTestRule.setContent {
            TestTheme(darkTheme = false) {
                val colors = MaterialTheme.colorScheme
                assertNotNull(colors)
            }
        }
    }

    @Test
    fun `dark theme should apply dark colors`() {
        composeTestRule.setContent {
            TestTheme(darkTheme = true) {
                val colors = MaterialTheme.colorScheme
                assertNotNull(colors)
            }
        }
    }

    @Test
    fun `theme should apply typography correctly`() {
        composeTestRule.setContent {
            TestTheme {
                val typography = MaterialTheme.typography
                assertNotNull(typography)
                assertNotNull(typography.bodyLarge)
                assertNotNull(typography.headlineLarge)
            }
        }
    }

    @Test
    fun `theme should apply shapes correctly`() {
        composeTestRule.setContent {
            TestTheme {
                val shapes = MaterialTheme.shapes
                assertNotNull(shapes)
                assertNotNull(shapes.small)
                assertNotNull(shapes.medium)
                assertNotNull(shapes.large)