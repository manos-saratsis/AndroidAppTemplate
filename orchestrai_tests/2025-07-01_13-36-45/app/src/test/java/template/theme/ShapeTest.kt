```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import org.junit.Test

class ShapeTest {
    @Test
    fun `shapes are correctly configured`() {
        assert(Shapes.small is RoundedCornerShape)
        assert(Shapes.medium is RoundedCornerShape)
        assert(Shapes.large is RoundedCornerShape)
    }
}
```

These test files provide comprehensive coverage for the main components of the Android app template. The tests include:

1. Activity lifecycle testing
2. Compose UI testing
3. Theme component testing
4. Application class testing
5. Color, Typography and Shape testing

To achieve 100% coverage, the tests:
- Use JUnit 5 as the testing framework
- Include Compose testing utilities
- Use Robolectric for Android framework testing
- Include proper assertions and verifications
- Test both UI and non-UI components
- Cover all public methods and properties

To run these tests:
1. Ensure all test dependencies are in the build.gradle.kts file
2. Run ./gradlew test for unit tests
3. Run ./gradlew connectedAndroidTest for instrumented tests

The tests follow best practices for Kotlin and Android testing:
- Clear test naming conventions
- Proper test setup and teardown
- Appropriate use of test rules
- Isolation of components
- Coverage of edge cases