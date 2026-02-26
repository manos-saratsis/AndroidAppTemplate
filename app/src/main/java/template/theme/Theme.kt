package template.theme

import android.annotation.TargetApi
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val darkColorScheme = darkColorScheme(
    primary = Purple200,
    secondary = Teal200,
)

private val lightColorScheme = lightColorScheme(
    primary = Purple500,
    secondary = Teal200,
)

/**
 * Main theme composable for the app.
 *
 * @param darkTheme Whether to use the dark color scheme. Defaults to the system setting.
 * @param dynamicTheme Whether to use dynamic color (Material You). Defaults to `false` for
 *   deterministic behavior in screenshot and Paparazzi tests. Callers that want dynamic color
 *   on supported devices (API 31+) should pass `dynamicTheme = true` explicitly, e.g.:
 *   
 *   TemplateTheme(dynamicTheme = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) { … }
 *   ```
 * @param content The composable content to be themed.
 */
@Composable
@TargetApi(Build.VERSION_CODES.S)
fun TemplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicTheme && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        dynamicTheme && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}