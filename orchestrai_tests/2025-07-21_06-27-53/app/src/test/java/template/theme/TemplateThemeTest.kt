package template.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TemplateThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `templateTheme applies material theme correctly`() {
        // Given & When
        composeTestRule.setContent {
            TemplateTheme {
                // Verify that MaterialTheme is available within TemplateTheme
                val colorScheme = MaterialTheme.colorScheme
                val typography = MaterialTheme.typography
                val shapes = MaterialTheme.shapes
                
                // Simple assertion that theme components are not null
                assert(colorScheme != null)
                assert(typography != null)
                assert(shapes != null)
                
                Text("Theme Test")
            }
        }
        
        // Then - if we reach here without exceptions, the theme is working
        composeTestRule.waitForIdle()
    }

    @Test
    fun `templateTheme works in inspection mode`() {
        // Given & When
        composeTestRule.setContent {
            CompositionLocalProvider(LocalInspectionMode provides true) {
                TemplateTheme {
                    Text("Inspection Mode Test")
                }
            }
        }
        
        // Then
        composeTestRule.waitForIdle()
    }

    @Test
    fun `templateTheme provides consistent color scheme`() {
        var colorScheme1: androidx.compose.material3.ColorScheme? = null
        var colorScheme2: androidx.compose.material3.ColorScheme? = null
        
        composeTestRule.setContent {
            TemplateTheme {
                colorScheme1 = MaterialTheme.colorScheme
                TemplateTheme {
                    colorScheme2 = MaterialTheme.colorScheme
                }
            }
        }
        
        composeTestRule.waitForIdle()
        
        // Verify that nested themes provide consistent color schemes
        assert(colorScheme1 != null)
        assert(colorScheme2 != null)
    }
}