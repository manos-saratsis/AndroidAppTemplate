package template

import android.app.Application
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class TemplateAppTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private lateinit var app: TemplateApp

    @Before
    fun setup() {
        hiltRule.inject()
        app = TemplateApp()
    }

    @Test
    fun testTemplateAppIsApplicationSubclass() {
        assert(app is Application)
    }

    @Test
    fun testTemplateAppCanBeInstantiated() {
        val templateApp = TemplateApp()
        assert(templateApp != null)
    }

    @Test
    fun testTemplateAppIsHiltAndroidApp() {
        // Verify TemplateApp is annotated with @HiltAndroidApp
        val annotation = TemplateApp::class.java.getAnnotation(
            Class.forName("dagger.hilt.android.HiltAndroidApp")
        )
        assert(annotation != null)
    }

    @Test
    fun testTemplateAppExtendsApplication() {
        val superclass = TemplateApp::class.java.superclass
        assert(superclass == Application::class.java)
    }

    @Test
    fun testTemplateAppInheritsApplicationBehavior() {
        val templateApp = TemplateApp()
        // Should have access to Application methods
        assert(templateApp is Application)
    }

    @Test
    fun testTemplateAppMultipleInstantiations() {
        val app1 = TemplateApp()
        val app2 = TemplateApp()
        assert(app1 != app2)
    }

    @Test
    fun testTemplateAppNotNull() {
        val templateApp = TemplateApp()
        assert(templateApp != null)
    }
}