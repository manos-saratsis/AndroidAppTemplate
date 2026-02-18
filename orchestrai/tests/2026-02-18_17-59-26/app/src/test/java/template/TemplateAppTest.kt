package template

import android.app.Application
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class)
class TemplateAppTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private lateinit var application: TemplateApp

    @Before
    fun setup() {
        hiltRule.inject()
        application = TemplateApp()
    }

    @Test
    fun `should create TemplateApp instance`() {
        // Arrange & Act
        val app = TemplateApp()

        // Assert
        assertNotNull(app)
    }

    @Test
    fun `should extend Application class`() {
        // Assert
        assertTrue(application is Application)
    }

    @Test
    fun `should be annotated with HiltAndroidApp`() {
        // Assert
        val annotations = TemplateApp::class.java.annotations
        assertTrue(annotations.any { it.annotationClass.simpleName == "HiltAndroidApp" })
    }

    @Test
    fun `should have no-arg constructor`() {
        // Act
        val app = TemplateApp()

        // Assert
        assertNotNull(app)
        assertTrue(app is TemplateApp)
    }

    @Test
    fun `should be instantiable as Application`() {
        // Act
        val app: Application = TemplateApp()

        // Assert
        assertNotNull(app)
        assertTrue(app is Application)
    }

    @Test
    fun `should inherit Application lifecycle methods`() {
        // Assert - Verify that Application methods are available
        assertNotNull(application)
        // onCreate, onTerminate, etc. are inherited from Application
    }

    @Test
    fun `should support onCreate lifecycle`() {
        // Act
        application.onCreate()

        // Assert - onCreate should execute without throwing exceptions
        assertNotNull(application)
    }

    @Test
    fun `should support onTerminate lifecycle`() {
        // Act
        application.onTerminate()

        // Assert - onTerminate should execute without throwing exceptions
        assertNotNull(application)
    }

    @Test
    fun `should support onLowMemory lifecycle`() {
        // Act
        application.onLowMemory()

        // Assert - onLowMemory should execute without throwing exceptions
        assertNotNull(application)
    }

    @Test
    fun `should support onTrimMemory lifecycle`() {
        // Arrange
        val level = Application.TRIM_MEMORY_RUNNING_LOW

        // Act
        application.onTrimMemory(level)

        // Assert - onTrimMemory should execute without throwing exceptions
        assertNotNull(application)
    }

    @Test
    fun `should support onTrimMemory with TRIM_MEMORY_MODERATE`() {
        // Arrange
        val level = Application.TRIM_MEMORY_MODERATE

        // Act
        application.onTrimMemory(level)

        // Assert
        assertNotNull(application)
    }

    @Test
    fun `should support onTrimMemory with TRIM_MEMORY_COMPLETE`() {
        // Arrange
        val level = Application.TRIM_MEMORY_COMPLETE

        // Act
        application.onTrimMemory(level)

        // Assert
        assertNotNull(application)
    }

    @Test
    fun `should support onTrimMemory with TRIM_MEMORY_RUNNING_CRITICAL`() {
        // Arrange
        val level = Application.TRIM_MEMORY_RUNNING_CRITICAL

        // Act
        application.onTrimMemory(level)

        // Assert
        assertNotNull(application)
    }

    @Test
    fun `should support onTrimMemory with TRIM_MEMORY_UI_HIDDEN`() {
        // Arrange
        val level = Application.TRIM_MEMORY_UI_HIDDEN

        // Act
        application.onTrimMemory(level)

        // Assert
        assertNotNull(application)
    }

    @Test
    fun `should support onTrimMemory with TRIM_MEMORY_BACKGROUND`() {
        // Arrange
        val level = Application.TRIM_MEMORY_BACKGROUND

        // Act
        application.onTrimMemory(level)

        // Assert
        assertNotNull(application)
    }

    @Test
    fun `should handle multiple onCreate calls`() {
        // Act
        application.onCreate()
        application.onCreate()

        // Assert
        assertNotNull(application)
    }

    @Test
    fun `should handle onCreate followed by onTerminate`() {
        // Act
        application.onCreate()
        application.onTerminate()

        // Assert
        assertNotNull(application)
    }

    @Test
    fun `should handle full lifecycle sequence`() {
        // Act
        application.onCreate()
        application.onLowMemory()
        application.onTrimMemory(Application.TRIM_MEMORY_RUNNING_LOW)
        application.onTerminate()

        // Assert
        assertNotNull(application)
    }

    @Test
    fun `should be a valid Hilt application`() {
        // Assert - Verify Hilt annotation is present
        val hiltAnnotation = TemplateApp::class.java.getAnnotation(
            Class.forName("dagger.hilt.android.HiltAndroidApp").asSubclass(Annotation::class.java)
        )
        assertNotNull("HiltAndroidApp annotation should be present", hiltAnnotation)
    }
}