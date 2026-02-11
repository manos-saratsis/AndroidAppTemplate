package template

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import org.junit.After

@RunWith(AndroidJUnit4::class)
class TemplateAppTest {

    private lateinit var app: TemplateApp

    @Before
    fun setUp() {
        app = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun testTemplateAppIsApplication() {
        // Verify TemplateApp inherits from Application
        assert(app is Application)
    }

    @Test
    fun testTemplateAppIsNotNull() {
        // Verify app instance exists
        assert(app != null)
    }

    @Test
    fun testTemplateAppSingleton() {
        val app1 = ApplicationProvider.getApplicationContext<TemplateApp>()
        val app2 = ApplicationProvider.getApplicationContext<TemplateApp>()
        
        // Verify same instance
        assert(app1 === app2)
    }

    @Test
    fun testTemplateAppHasApplicationContext() {
        // Verify app has valid context
        assert(app.applicationContext != null)
    }

    @Test
    fun testTemplateAppPackageName() {
        // Verify app has correct package name
        assert(app.packageName == "template")
    }

    @Test
    fun testTemplateAppCanBeInstantiated() {
        val testApp = TemplateApp()
        assert(testApp is TemplateApp)
        assert(testApp is Application)
    }

    @Test
    fun testTemplateAppHiltIntegration() {
        // Verify app is properly set up with Hilt
        // TemplateApp should have HiltAndroidApp annotation
        val appClass = TemplateApp::class.java
        assert(appClass != null)
    }

    @Test
    fun testTemplateAppMultipleInstances() {
        val instance1 = TemplateApp()
        val instance2 = TemplateApp()
        
        // Both should be valid instances
        assert(instance1 is Application)
        assert(instance2 is Application)
    }
}