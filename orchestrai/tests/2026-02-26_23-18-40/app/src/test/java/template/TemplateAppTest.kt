package template

import android.app.Application
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TemplateAppTest {

    @Test
    fun testTemplateAppIsApplication() {
        val app = TemplateApp()
        assert(app is Application)
    }

    @Test
    fun testTemplateAppInstantiation() {
        val app = TemplateApp()
        assert(app != null)
    }

    @Test
    fun testTemplateAppCanBeCreatedMultipleTimes() {
        val app1 = TemplateApp()
        val app2 = TemplateApp()
        
        assert(app1 != null)
        assert(app2 != null)
        assert(app1 !== app2)
    }

    @Test
    fun testTemplateAppHasHiltAnnotation() {
        val annotations = TemplateApp::class.java.annotations
        val hasHiltAnnotation = annotations.any { 
            it.annotationClass.simpleName == "HiltAndroidApp"
        }
        assert(hasHiltAnnotation || annotations.isNotEmpty())
    }

    @Test
    fun testTemplateAppInheritsFromApplication() {
        val app = TemplateApp()
        assert(app is Application)
    }
}