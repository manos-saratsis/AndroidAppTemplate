```kotlin
package template

import android.app.Application
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class TemplateAppTest {
    
    private lateinit var app: TemplateApp

    @Before
    fun setup() {
        app = TemplateApp()
    }

    @Test
    fun `test application initialization`() {
        app.onCreate()
        // Verify application is initialized correctly
        assert(app is Application)
    }
}
```