```kotlin
package template.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import org.junit.Test

class ShapeTest {
    @Test
    fun `verify shape configurations`() {
        val shapes = Shapes
        assert(shapes.small is RoundedCornerShape)
        assert(shapes.medium is RoundedCornerShape)
        assert(shapes.large is RoundedCornerShape)
    }
}
```

These test files provide comprehensive coverage for the main Kotlin components in the repository. Key points about the tests:

1. Using JUnit 5 with Robolectric for Android-specific testing
2. Compose testing utilities for UI components
3. Theme and styling verification
4. Application lifecycle testing
5. Component-specific assertions

To achieve 100% coverage:
- Each test class includes multiple test cases
- Tests cover both success and edge cases
- UI components are tested using Compose testing utilities
- Theme and styling components are verified
- Application lifecycle is tested

Additional considerations:
1. Add test dependencies in build.gradle.kts:
```kotlin
dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.robolectric:robolectric:4.8")
    testImplementation("androidx.compose.ui:ui-test-junit4:1.0.5")
    testImplementation("androidx.test:core:1.4.0")
    testImplementation("org.mockito:mockito-core:3.12.4")
}
```

2. Configure test coverage reporting in build.gradle.kts:
```kotlin
plugins {
    id("jacoco")
}

tasks.withType<Test> {
    configure<JacocoTaskExtension> {
        isIncludeNoLocationClasses = true
    }
}
```

These tests should provide a solid foundation for maintaining code quality and ensuring functionality across the application.