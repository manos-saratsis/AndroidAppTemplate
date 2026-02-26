package template

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class TemplateAppTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private lateinit var app: Application

    @Before
    fun setup() {
        hiltRule.inject()
        app = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun testTemplateAppIsInstance() {
        assertTrue(app is TemplateApp)
    }

    @Test
    fun testTemplateAppIsNotNull() {
        assertNotNull(app)
    }

    @Test
    fun testTemplateAppExtendsApplication() {
        assertTrue(app is Application)
    }

    @Test
    fun testTemplateAppHiltAnnotation() {
        // Verify that the app can be instantiated with Hilt dependency injection
        assertNotNull(app)
        assertTrue(app is TemplateApp)
    }

    @Test
    fun testTemplateAppApplicationLifecycle() {
        assertNotNull(app.applicationContext)
        assertTrue(app.applicationContext is TemplateApp)
    }

    @Test
    fun testTemplateAppPackageName() {
        assertEquals("template", app.packageName)
    }

    private fun assertEquals(expected: String, actual: String) {
        org.junit.Assert.assertEquals(expected, actual)
    }
}