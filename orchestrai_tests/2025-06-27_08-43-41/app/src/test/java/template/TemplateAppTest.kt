```kotlin
package template

import android.app.Application
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertNotNull

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class TemplateAppTest {
    private lateinit var app: TemplateApp

    @Before
    fun setup() {
        app = TemplateApp()
    }

    @Test
    fun `test application onCreate initializes correctly`() {
        app.onCreate()
        assertNotNull(app)
    }

    @Test
    fun `test application extends Android Application class`() {
        assert(app is Application)
    }
}
```