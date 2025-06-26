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