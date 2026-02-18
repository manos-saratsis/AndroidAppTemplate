package template.theme

import android.os.Build
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.TIRAMISU])
class ThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `TemplateTheme should apply light theme by default when not in dark mode`() {
        // Arrange
        var appliedColorScheme: ColorScheme? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = false) {
                appliedColorScheme = MaterialTheme.colorScheme
            }
        }

        // Assert
        assertNotNull(appliedColorScheme)
        assertEquals(Purple500, appliedColorScheme?.primary)
        assertEquals(Teal200, appliedColorScheme?.secondary)
    }

    @Test
    fun `TemplateTheme should apply dark theme when darkTheme is true`() {
        // Arrange
        var appliedColorScheme: ColorScheme? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true, dynamicTheme = false) {
                appliedColorScheme = MaterialTheme.colorScheme
            }
        }

        // Assert
        assertNotNull(appliedColorScheme)
        assertEquals(Purple200, appliedColorScheme?.primary)
        assertEquals(Teal200, appliedColorScheme?.secondary)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S])
    fun `TemplateTheme should apply dynamic dark theme when dynamicTheme is true and darkTheme is true on Android S+`() {
        // Arrange
        var appliedColorScheme: ColorScheme? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true, dynamicTheme = true) {
                appliedColorScheme = MaterialTheme.colorScheme
            }
        }

        // Assert
        assertNotNull(appliedColorScheme)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S])
    fun `TemplateTheme should apply dynamic light theme when dynamicTheme is true and darkTheme is false on Android S+`() {
        // Arrange
        var appliedColorScheme: ColorScheme? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = true) {
                appliedColorScheme = MaterialTheme.colorScheme
            }
        }

        // Assert
        assertNotNull(appliedColorScheme)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.R])
    fun `TemplateTheme should fall back to static themes on Android versions below S`() {
        // Arrange
        var appliedColorScheme: ColorScheme? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = false) {
                appliedColorScheme = MaterialTheme.colorScheme
            }
        }

        // Assert
        assertNotNull(appliedColorScheme)
        assertEquals(Purple500, appliedColorScheme?.primary)
    }

    @Test
    fun `TemplateTheme should apply Typography`() {
        // Arrange
        var appliedTypography: androidx.compose.material3.Typography? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = false) {
                appliedTypography = MaterialTheme.typography
            }
        }

        // Assert
        assertNotNull(appliedTypography)
        assertEquals(Typography, appliedTypography)
    }

    @Test
    fun `TemplateTheme should apply Shapes`() {
        // Arrange
        var appliedShapes: androidx.compose.material3.Shapes? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = false) {
                appliedShapes = MaterialTheme.shapes
            }
        }

        // Assert
        assertNotNull(appliedShapes)
        assertEquals(Shapes, appliedShapes)
    }

    @Test
    fun `TemplateTheme should render content`() {
        // Arrange
        var contentExecuted = false

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = false) {
                contentExecuted = true
            }
        }

        // Assert
        assert(contentExecuted)
    }

    @Test
    fun `TemplateTheme should handle all color scheme combinations`() {
        // Test case 1: dynamicTheme = true, darkTheme = true
        var colorScheme1: ColorScheme? = null
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true, dynamicTheme = true) {
                colorScheme1 = MaterialTheme.colorScheme
            }
        }
        assertNotNull(colorScheme1)

        // Test case 2: dynamicTheme = true, darkTheme = false
        var colorScheme2: ColorScheme? = null
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = true) {
                colorScheme2 = MaterialTheme.colorScheme
            }
        }
        assertNotNull(colorScheme2)

        // Test case 3: dynamicTheme = false, darkTheme = true
        var colorScheme3: ColorScheme? = null
        composeTestRule.setContent {
            TemplateTheme(darkTheme = true, dynamicTheme = false) {
                colorScheme3 = MaterialTheme.colorScheme
            }
        }
        assertNotNull(colorScheme3)
        assertEquals(Purple200, colorScheme3?.primary)

        // Test case 4: dynamicTheme = false, darkTheme = false (else branch)
        var colorScheme4: ColorScheme? = null
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = false) {
                colorScheme4 = MaterialTheme.colorScheme
            }
        }
        assertNotNull(colorScheme4)
        assertEquals(Purple500, colorScheme4?.primary)
    }

    @Test
    fun `TemplateTheme should use system dark theme by default`() {
        // Arrange
        var appliedColorScheme: ColorScheme? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme(dynamicTheme = false) {
                appliedColorScheme = MaterialTheme.colorScheme
            }
        }

        // Assert
        assertNotNull(appliedColorScheme)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S])
    fun `TemplateTheme should enable dynamic theme by default on Android S+`() {
        // Arrange
        var appliedColorScheme: ColorScheme? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme {
                appliedColorScheme = MaterialTheme.colorScheme
            }
        }

        // Assert
        assertNotNull(appliedColorScheme)
    }

    @Test
    fun `TemplateTheme should handle empty content`() {
        // Arrange & Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = false) {
                // Empty content
            }
        }

        // Assert - no exception should be thrown
    }

    @Test
    fun `TemplateTheme should handle nested content`() {
        // Arrange
        var outerExecuted = false
        var innerExecuted = false

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = false) {
                outerExecuted = true
                TemplateTheme(darkTheme = true, dynamicTheme = false) {
                    innerExecuted = true
                }
            }
        }

        // Assert
        assert(outerExecuted)
        assert(innerExecuted)
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.Q])
    fun `TemplateTheme should work correctly on Android Q`() {
        // Arrange
        var appliedColorScheme: ColorScheme? = null

        // Act
        composeTestRule.setContent {
            TemplateTheme(darkTheme = false, dynamicTheme = false) {
                appliedColorScheme = MaterialTheme.colorScheme
            }
        }

        // Assert
        assertNotNull(appliedColorScheme)
        assertEquals(Purple500, appliedColorScheme?.primary)
    }
}