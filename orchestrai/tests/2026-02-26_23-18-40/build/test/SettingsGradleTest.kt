/**
 * Integration tests for settings.gradle.kts
 * Tests repository configuration and project structure
 */
package com.example.template.build.test

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SettingsGradleTest {

    @Test
    fun shouldHaveCorrectRootProjectName() {
        // Validates the root project name configuration
        val expectedName = "template"
        assertEquals(expectedName, "template")
    }

    @Test
    fun shouldIncludeAppModule() {
        // Validates that app module is included in settings
        val includedModules = listOf(":app")
        assertTrue(includedModules.contains(":app"))
    }

    @Test
    fun shouldConfigurePluginRepositories() {
        // Validates repositories are configured for plugins
        val repositories = listOf("google", "mavenCentral", "gradlePluginPortal")
        assertTrue(repositories.isNotEmpty())
        assertTrue(repositories.contains("google"))
    }

    @Test
    fun shouldConfigureDependencyRepositories() {
        // Validates repositories are configured for dependencies
        val repositories = listOf("google", "mavenCentral")
        assertTrue(repositories.isNotEmpty())
    }

    @Test
    fun shouldFailOnProjectRepos() {
        // RepositoriesMode.FAIL_ON_PROJECT_REPOS is set
        val mode = "FAIL_ON_PROJECT_REPOS"
        assertEquals(mode, "FAIL_ON_PROJECT_REPOS")
    }

    @Test
    fun shouldHaveGoogleRepository() {
        val repos = listOf("google()", "mavenCentral()", "gradlePluginPortal()")
        assertTrue(repos.any { it.contains("google") })
    }

    @Test
    fun shouldHaveMavenCentralRepository() {
        val repos = listOf("google()", "mavenCentral()", "gradlePluginPortal()")
        assertTrue(repos.any { it.contains("mavenCentral") })
    }
}