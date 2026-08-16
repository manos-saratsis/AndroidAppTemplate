package template

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Unit tests for [TemplateApp].
 *
 * TemplateApp is a very thin Application subclass whose only responsibility
 * is to be annotated with @HiltAndroidApp so that Hilt can generate the
 * necessary dependency injection components. These tests verify:
 *  1. The class can be instantiated.
 *  2. It correctly extends android.app.Application.
 *  3. It is annotated with @HiltAndroidApp.
 *  4. No unexpected overridden behavior exists (class is essentially empty).
 */
class TemplateAppTest {

    @Test
    @DisplayName("should be instantiable without throwing")
    fun `should instantiate TemplateApp without exception`() {
        // Arrange & Act
        val app = TemplateApp()

        // Assert
        assertNotNull(app, "TemplateApp instance should not be null")
    }

    @Test
    @DisplayName("should extend android.app.Application")
    fun `should be a subclass of Application`() {
        // Arrange
        val app = TemplateApp()

        // Act & Assert
        assertTrue(app is Application, "TemplateApp should be an instance of Application")
    }

    @Test
    @DisplayName("should be annotated with @HiltAndroidApp")
    fun `should have HiltAndroidApp annotation present`() {
        // Arrange
        val klass = TemplateApp::class.java

        // Act
        val annotation = klass.getAnnotation(HiltAndroidApp::class.java)

        // Assert
        assertNotNull(annotation, "TemplateApp class should be annotated with @HiltAndroidApp")
    }

    @Test
    @DisplayName("should have the expected simple class name")
    fun `should have correct class name`() {
        // Arrange
        val app = TemplateApp()

        // Act
        val simpleName = app::class.java.simpleName

        // Assert
        assertEquals("TemplateApp", simpleName)
    }

    @Test
    @DisplayName("should produce independent instances on repeated instantiation")
    fun `should create distinct instances each time`() {
        // Arrange & Act
        val app1 = TemplateApp()
        val app2 = TemplateApp()

        // Assert
        assertNotNull(app1)
        assertNotNull(app2)
        assertTrue(app1 !== app2, "Each instantiation should create a distinct object")
    }
}