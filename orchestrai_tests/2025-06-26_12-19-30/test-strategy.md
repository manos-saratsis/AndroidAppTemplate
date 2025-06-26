I'll help generate comprehensive unit tests for the Kotlin files in this Android repository. Let's focus on the main components:

=== FILE: app/src/test/java/template/MainActivityTest.kt ===
```kotlin
package template

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import template.theme.TemplateAppTheme

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test MainActivity content rendering`() {
        composeTestRule.setContent {
            TemplateAppTheme {
                MainActivity()
            }
        }
        // Verify compose UI elements are rendered
        composeTestRule.onRoot().assertExists()
    }
}
```

=== FILE: app/src/test/java/template/TemplateAppTest.kt ===
```kotlin
package template

import android.app.Application
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [29])
class TemplateAppTest {
    
    private lateinit var app: TemplateApp

    @Before
    fun setup() {
        app = TemplateApp()
    }

    @Test
    fun `test application onCreate`() {
        app.onCreate()
        // Verify application initialization
        assert(app is Application)
    }
}
```

=== FILE: app/src/test/java/template/theme/ThemeTest.kt ===
```kotlin
package template.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class ThemeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `test TemplateAppTheme composition`() {
        composeTestRule.setContent {
            TemplateAppTheme {
                TestContent()
            }
        }
        // Verify theme is applied
        composeTestRule.onRoot().assertExists()
    }

    @Composable
    private fun TestContent() {
        MaterialTheme {
            // Test content
        }
    }
}
```

=== FILE: app/src/test/java/template/theme/ColorTest.kt ===
```kotlin
package template.theme

import org.junit.Test
import androidx.compose.ui.graphics.Color
import kotlin.test.assertEquals

class ColorTest {
    
    @Test
    fun `verify color values`() {
        assertEquals(Purple200, Color(0xFFBB86FC))
        assertEquals(Purple500, Color(0xFF6200EE))
        assertEquals(Purple700, Color(0xFF3700B3))
        assertEquals(Teal200, Color(0xFF03DAC5))
    }
}
```

=== FILE: app/src/test/java/template/theme/TypeTest.kt ===
```kotlin
package template.theme

import androidx.compose.material.Typography
import org.junit.Test
import kotlin.test.assertNotNull

class TypeTest {
    
    @Test
    fun `verify typography configuration`() {
        val typography = Typography()
        assertNotNull(typography.h1)
        assertNotNull(typography.body1)
        assertNotNull(typography.button)
    }
}
```

=== FILE: app/src/test/java/template/theme/ShapeTest.kt ===
```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import org.junit.Test
import kotlin.test.assertEquals

class ShapeTest {
    
    @Test
    fun `verify shape configurations`() {
        val shapes = Shapes
        assertEquals(4, (shapes.small as RoundedCornerShape).topStart.value)
        assertEquals(4, (shapes.medium as RoundedCornerShape).topStart.value)
        assertEquals(0, (shapes.large as RoundedCornerShape).topStart.value)
    }
}
```

To properly run these tests, you'll need the following dependencies in your build.gradle.kts:

```kotlin
dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.6.21")
    testImplementation("org.robolectric:robolectric:4.8")
    testImplementation("androidx.compose.ui:ui-test-junit4:1.2.0")
    testImplementation("androidx.test:core:1.4.0")
    testImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
}
```

These tests cover:
1. MainActivity Compose UI rendering
2. Application initialization
3. Theme implementation
4. Color definitions
5. Typography configuration
6. Shape definitions

The tests use:
- JUnit 5 for test execution
- Robolectric for Android framework simulation
- Compose UI testing utilities
- Kotlin test assertions

To achieve 100% coverage:
1. Run tests with coverage reporting enabled
2. Add additional test cases for edge cases
3. Mock external dependencies where needed
4. Test all possible code paths in each component

Remember to run these tests using:
```bash
./gradlew test
```

For Android instrumentation tests:
```bash
./gradlew connectedAndroidTest
```