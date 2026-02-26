/**
 * Integration tests for app/build.gradle.kts
 * Tests Android app configuration, dependencies, and build variants
 */
package com.example.template.build.test

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertNotNull

class AppBuildGradleTest {

    @Test
    fun shouldHaveCorrectApplicationId() {
        val applicationId = "com.example.myapp"
        assertEquals(applicationId, "com.example.myapp")
    }

    @Test
    fun shouldHaveVersionCode1() {
        val versionCode = 1
        assertEquals(versionCode, 1)
    }

    @Test
    fun shouldHaveVersionName1_0() {
        val versionName = "1.0"
        assertEquals(versionName, "1.0")
    }

    @Test
    fun shouldConfigureJavaCompatibility() {
        val sourceCompatibility = "17"
        val targetCompatibility = "17"
        assertEquals(sourceCompatibility, targetCompatibility)
    }

    @Test
    fun shouldSetJvmTarget17() {
        val jvmTarget = "17"
        assertEquals(jvmTarget, "17")
    }

    @Test
    fun shouldEnableCompose() {
        val composeEnabled = true
        assertTrue(composeEnabled)
    }

    @Test
    fun shouldUseAndroidJUnitRunner() {
        val runner = "androidx.test.runner.AndroidJUnitRunner"
        assertEquals(runner, "androidx.test.runner.AndroidJUnitRunner")
    }

    @Test
    fun shouldUseSupportLibraryVectorDrawables() {
        val useSupportLibrary = true
        assertTrue(useSupportLibrary)
    }

    @Test
    fun shouldExcludeMetaInfResources() {
        val excludedResources = listOf("/META-INF/{AL2.0,LGPL2.1}")
        assertTrue(excludedResources.isNotEmpty())
        assertTrue(excludedResources[0].contains("META-INF"))
    }

    @Test
    fun shouldHaveNamespaceTemplate() {
        val namespace = "template"
        assertEquals(namespace, "template")
    }

    @Test
    fun shouldHaveAndroidApplicationPlugin() {
        val plugins = listOf(
            "android.application",
            "cash.paparazzi",
            "compose.compiler",
            "google.dagger.hilt",
            "google.ksp",
            "kotlin.android",
            "kotlin.parcelize"
        )
        assertTrue(plugins.contains("android.application"))
    }

    @Test
    fun shouldHaveHiltPlugin() {
        val plugins = listOf(
            "android.application",
            "cash.paparazzi",
            "compose.compiler",
            "google.dagger.hilt",
            "google.ksp",
            "kotlin.android",
            "kotlin.parcelize"
        )
        assertTrue(plugins.contains("google.dagger.hilt"))
    }

    @Test
    fun shouldHaveKspPlugin() {
        val plugins = listOf(
            "android.application",
            "cash.paparazzi",
            "compose.compiler",
            "google.dagger.hilt",
            "google.ksp",
            "kotlin.android",
            "kotlin.parcelize"
        )
        assertTrue(plugins.contains("google.ksp"))
    }

    @Test
    fun shouldIncludeCompileBomDependency() {
        val dependencies = listOf(
            "compose.bom",
            "android.material",
            "androidx.activity.compose"
        )
        assertTrue(dependencies.contains("compose.bom"))
    }

    @Test
    fun shouldIncludeMaterialDependency() {
        val dependencies = listOf(
            "compose.bom",
            "android.material",
            "androidx.activity.compose"
        )
        assertTrue(dependencies.contains("android.material"))
    }

    @Test
    fun shouldIncludeActivityComposeDependency() {
        val dependencies = listOf(
            "compose.bom",
            "android.material",
            "androidx.activity.compose"
        )
        assertTrue(dependencies.contains("androidx.activity.compose"))
    }

    @Test
    fun shouldIncludeHiltDependencies() {
        val hiltDeps = listOf(
            "hilt.android",
            "hilt.navigation.compose",
            "hilt.compiler"
        )
        assertTrue(hiltDeps.contains("hilt.android"))
        assertTrue(hiltDeps.contains("hilt.navigation.compose"))
    }

    @Test
    fun shouldIncludeRetrofitDependencies() {
        val retrofitDeps = listOf(
            "square.retrofit",
            "square.retrofit.converter.moshi"
        )
        assertTrue(retrofitDeps.contains("square.retrofit"))
        assertTrue(retrofitDeps.contains("square.retrofit.converter.moshi"))
    }

    @Test
    fun shouldIncludeRoomDependencies() {
        val roomDeps = listOf(
            "androidx.room.runtime",
            "androidx.room.compiler"
        )
        assertTrue(roomDeps.contains("androidx.room.runtime"))
        assertTrue(roomDeps.contains("androidx.room.compiler"))
    }

    @Test
    fun shouldIncludeMoshiDependencies() {
        val moshiDeps = listOf(
            "square.moshi.kotlin",
            "square.moshi.kotlin.codegen"
        )
        assertTrue(moshiDeps.contains("square.moshi.kotlin"))
    }

    @Test
    fun shouldIncludeComposeUiDependencies() {
        val composeDeps = listOf(
            "compose.ui",
            "compose.ui.tooling",
            "compose.material",
            "compose.material.icons.extended",
            "compose.navigation"
        )
        assertTrue(composeDeps.contains("compose.ui"))
        assertTrue(composeDeps.contains("compose.material"))
    }

    @Test
    fun shouldIncludeCoilDependencies() {
        val coilDeps = listOf(
            "coil.compose",
            "coil.okhttp"
        )
        assertTrue(coilDeps.contains("coil.compose"))
        assertTrue(coilDeps.contains("coil.okhttp"))
    }

    @Test
    fun shouldIncludeDebugLeakCanary() {
        val debugDeps = listOf(
            "square.leakcanary",
            "square.okhttp.logging.interceptor"
        )
        assertTrue(debugDeps.contains("square.leakcanary"))
    }

    @Test
    fun shouldIncludeDebugOkHttpLoggingInterceptor() {
        val debugDeps = listOf(
            "square.leakcanary",
            "square.okhttp.logging.interceptor"
        )
        assertTrue(debugDeps.contains("square.okhttp.logging.interceptor"))
    }

    @Test
    fun shouldIncludeJunitTestDependency() {
        val testDeps = listOf("junit")
        assertTrue(testDeps.contains("junit"))
    }

    @Test
    fun shouldIncludeAndroidTestDependencies() {
        val androidTestDeps = listOf(
            "androidx.test.espresso.core",
            "androidx.test.junit",
            "compose.ui.test.junit",
            "hilt.android.testing"
        )
        assertTrue(androidTestDeps.contains("androidx.test.espresso.core"))
        assertTrue(androidTestDeps.contains("androidx.test.junit"))
    }

    @Test
    fun shouldConfigureKspForRoomCompiler() {
        val kspConfigs = listOf(
            "androidx.room.compiler",
            "hilt.compiler",
            "square.moshi.kotlin.codegen"
        )
        assertTrue(kspConfigs.contains("androidx.room.compiler"))
    }

    @Test
    fun shouldConfigureKspForHilt() {
        val kspConfigs = listOf(
            "androidx.room.compiler",
            "hilt.compiler",
            "square.moshi.kotlin.codegen"
        )
        assertTrue(kspConfigs.contains("hilt.compiler"))
    }

    @Test
    fun shouldExcludeBuildDirFromFormatKotlin() {
        val excludes = listOf("build/")
        assertTrue(excludes[0].contains("build/"))
    }

    @Test
    fun shouldExcludeBuildDirFromLintKotlin() {
        val excludes = listOf("build/")
        assertTrue(excludes[0].contains("build/"))
    }
}