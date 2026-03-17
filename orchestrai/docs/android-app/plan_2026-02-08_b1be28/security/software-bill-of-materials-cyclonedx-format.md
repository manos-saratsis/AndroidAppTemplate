I'll fetch the key dependency files to generate an accurate CycloneDX SBOM.# Software Bill of Materials (CycloneDX Format) — AndroidAppTemplate

**Repository:** `manos-saratsis/AndroidAppTemplate`
**SBOM Standard:** CycloneDX v1.4
**Format:** JSON-compatible Markdown representation
**Generated From:**
- `gradle/libs.versions.toml`
- `app/build.gradle.kts`
- `build.gradle.kts`

---

## Metadata

| Field | Value |
|---|---|
| **BOM Format** | CycloneDX |
| **Spec Version** | 1.4 |
| **Serial Number** | `urn:uuid:androidapptemplate-sbom-cyclonedx` |
| **Version** | 1 |
| **Component Name** | AndroidAppTemplate |
| **Component Type** | application |
| **Min SDK** | 23 |
| **Target / Compile SDK** | 35 |
| **JVM Target** | 17 (Java 17) |
| **Application ID** | `template.app.id` (replaced during setup) |
| **App Version** | 1.0 (versionCode: 1) |

---

## CycloneDX JSON Representation

```json
{
  "bomFormat": "CycloneDX",
  "specVersion": "1.4",
  "version": 1,
  "serialNumber": "urn:uuid:androidapptemplate-sbom-cyclonedx",
  "metadata": {
    "component": {
      "type": "application",
      "name": "AndroidAppTemplate",
      "version": "1.0",
      "purl": "pkg:github/manos-saratsis/AndroidAppTemplate@main"
    },
    "properties": [
      { "name": "minSdk", "value": "23" },
      { "name": "compileSdk", "value": "35" },
      { "name": "jvmTarget", "value": "17" }
    ]
  },
  "components": [ ... ]
}
```

---

## Component Inventory

### Runtime Dependencies (`implementation`)

| # | Component Name | Group:Artifact | Version | Scope | Type | PURL |
|---|---|---|---|---|---|---|
| 1 | Android Material | `com.google.android.material:material` | 1.12.0 | runtime | library | `pkg:maven/com.google.android.material/material@1.12.0` |
| 2 | AndroidX Activity Compose | `androidx.activity:activity-compose` | 1.10.1 | runtime | library | `pkg:maven/androidx.activity/activity-compose@1.10.1` |
| 3 | AndroidX AppCompat | `androidx.appcompat:appcompat` | 1.7.1 | runtime | library | `pkg:maven/androidx.appcompat/appcompat@1.7.1` |
| 4 | AndroidX Core KTX | `androidx.core:core-ktx` | 1.16.0 | runtime | library | `pkg:maven/androidx.core/core-ktx@1.16.0` |
| 5 | AndroidX Lifecycle Runtime KTX | `androidx.lifecycle:lifecycle-runtime-ktx` | 2.9.1 | runtime | library | `pkg:maven/androidx.lifecycle/lifecycle-runtime-ktx@2.9.1` |
| 6 | AndroidX Room Runtime | `androidx.room:room-runtime` | 2.7.2 | runtime | library | `pkg:maven/androidx.room/room-runtime@2.7.2` |
| 7 | Coil Compose | `io.coil-kt.coil3:coil-compose` | 3.2.0 | runtime | library | `pkg:maven/io.coil-kt.coil3/coil-compose@3.2.0` |
| 8 | Coil OkHttp Network | `io.coil-kt.coil3:coil-network-okhttp` | 3.2.0 | runtime | library | `pkg:maven/io.coil-kt.coil3/coil-network-okhttp@3.2.0` |
| 9 | Compose BOM | `androidx.compose:compose-bom` | 2025.06.01 | runtime | library | `pkg:maven/androidx.compose/compose-bom@2025.06.01` |
| 10 | Compose Material3 | `androidx.compose.material3:material3` | (BOM-managed) | runtime | library | `pkg:maven/androidx.compose.material3/material3` |
| 11 | Compose Material Icons Extended | `androidx.compose.material:material-icons-extended` | (BOM-managed) | runtime | library | `pkg:maven/androidx.compose.material/material-icons-extended` |
| 12 | Compose Navigation | `androidx.navigation:navigation-compose` | 2.9.0 | runtime | library | `pkg:maven/androidx.navigation/navigation-compose@2.9.0` |
| 13 | Compose UI | `androidx.compose.ui:ui` | (BOM-managed) | runtime | library | `pkg:maven/androidx.compose.ui/ui` |
| 14 | Compose UI Tooling | `androidx.compose.ui:ui-tooling` | (BOM-managed) | runtime | library | `pkg:maven/androidx.compose.ui/ui-tooling` |
| 15 | Hilt Android | `com.google.dagger:hilt-android` | 2.56.2 | runtime | library | `pkg:maven/com.google.dagger/hilt-android@2.56.2` |
| 16 | Hilt Navigation Compose | `androidx.hilt:hilt-navigation-compose` | 1.2.0 | runtime | library | `pkg:maven/androidx.hilt/hilt-navigation-compose@1.2.0` |
| 17 | Moshi Kotlin | `com.squareup.moshi:moshi-kotlin` | 1.15.2 | runtime | library | `pkg:maven/com.squareup.moshi/moshi-kotlin@1.15.2` |
| 18 | OkHttp Logging Interceptor | `com.squareup.okhttp3:logging-interceptor` | 4.12.0 | runtime | library | `pkg:maven/com.squareup.okhttp3/logging-interceptor@4.12.0` |
| 19 | Retrofit | `com.squareup.retrofit2:retrofit` | 3.0.0 | runtime | library | `pkg:maven/com.squareup.retrofit2/retrofit@3.0.0` |
| 20 | Retrofit Moshi Converter | `com.squareup.retrofit2:converter-moshi` | 3.0.0 | runtime | library | `pkg:maven/com.squareup.retrofit2/converter-moshi@3.0.0` |

### AndroidX XR Bundle (`implementation(libs.bundles.androidx.xr)`)

> Defined in `gradle/libs.versions.toml` under `[bundles]`. Included by default; removable via `setup.gradle` (`useAndroidXR = false`).

| # | Component Name | Group:Artifact | Version | Scope | Type | PURL |
|---|---|---|---|---|---|---|
| 21 | AndroidX XR Compose | `androidx.xr.compose:compose` | 1.0.0-alpha04 | runtime | library | `pkg:maven/androidx.xr.compose/compose@1.0.0-alpha04` |
| 22 | AndroidX XR Compose Material3 | `androidx.xr.compose.material3:material3` | 1.0.0-alpha08 | runtime | library | `pkg:maven/androidx.xr.compose.material3/material3@1.0.0-alpha08` |
| 23 | AndroidX XR Scenecore | `androidx.xr.scenecore:scenecore` | 1.0.0-alpha04 | runtime | library | `pkg:maven/androidx.xr.scenecore/scenecore@1.0.0-alpha04` |

### Debug-Only Dependencies (`debugImplementation`)

| # | Component Name | Group:Artifact | Version | Scope | Type | PURL |
|---|---|---|---|---|---|---|
| 24 | LeakCanary Android | `com.squareup.leakcanary:leakcanary-android` | 2.14 | development | library | `pkg:maven/com.squareup.leakcanary/leakcanary-android@2.14` |
| 25 | Compose UI Test Manifest | `androidx.compose.ui:ui-test-manifest` | (BOM-managed) | development | library | `pkg:maven/androidx.compose.ui/ui-test-manifest` |
| 26 | Compose UI Tooling (debug) | `androidx.compose.ui:ui-tooling` | (BOM-managed) | development | library | `pkg:maven/androidx.compose.ui/ui-tooling` |

### Test Dependencies (`testImplementation`)

| # | Component Name | Group:Artifact | Version | Scope | Type | PURL |
|---|---|---|---|---|---|---|
| 27 | JUnit | `junit:junit` | 4.13.2 | test | library | `pkg:maven/junit/junit@4.13.2` |

### Android Test Dependencies (`androidTestImplementation`)

| # | Component Name | Group:Artifact | Version | Scope | Type | PURL |
|---|---|---|---|---|---|---|
| 28 | AndroidX Test Espresso Core | `androidx.test.espresso:espresso-core` | 3.6.1 | test | library | `pkg:maven/androidx.test.espresso/espresso-core@3.6.1` |
| 29 | AndroidX Test JUnit | `androidx.test.ext:junit` | 1.2.1 | test | library | `pkg:maven/androidx.test.ext/junit@1.2.1` |
| 30 | Compose UI Test JUnit4 | `androidx.compose.ui:ui-test-junit4` | (BOM-managed) | test | library | `pkg:maven/androidx.compose.ui/ui-test-junit4` |
| 31 | Hilt Android Testing | `com.google.dagger:hilt-android-testing` | 2.56.2 | test | library | `pkg:maven/com.google.dagger/hilt-android-testing@2.56.2` |

### Annotation Processors / KSP (`ksp`, `annotationProcessor`, `kspAndroidTest`)

| # | Component Name | Group:Artifact | Version | Scope | Type | PURL |
|---|---|---|---|---|---|---|
| 32 | AndroidX Room Compiler | `androidx.room:room-compiler` | 2.7.2 | build | library | `pkg:maven/androidx.room/room-compiler@2.7.2` |
| 33 | Hilt Compiler | `com.google.dagger:hilt-compiler` | 2.56.2 | build | library | `pkg:maven/com.google.dagger/hilt-compiler@2.56.2` |
| 34 | Hilt Android Compiler (androidTest) | `com.google.dagger:hilt-android-compiler` | 2.56.2 | build | library | `pkg:maven/com.google.dagger/hilt-android-compiler@2.56.2` |
| 35 | Moshi Kotlin Codegen | `com.squareup.moshi:moshi-kotlin-codegen` | 1.15.2 | build | library | `pkg:maven/com.squareup.moshi/moshi-kotlin-codegen@1.15.2` |

---

## Gradle Plugins (Build Tools)

> Declared in `build.gradle.kts` (root) and `app/build.gradle.kts`. Sourced from `gradle/libs.versions.toml` `[plugins]` block.

| # | Plugin Name | Plugin ID | Version | Applied In | PURL |
|---|---|---|---|---|---|
| 1 | Android Gradle Plugin | `com.android.application` | 8.11.0 | root + app | `pkg:maven/com.android.tools.build/gradle@8.11.0` |
| 2 | Kotlin Android | `org.jetbrains.kotlin.android` | 2.2.0 | root + app | `pkg:maven/org.jetbrains.kotlin/kotlin-gradle-plugin@2.2.0` |
| 3 | Kotlin Compose Compiler | `org.jetbrains.kotlin.plugin.compose` | 2.2.0 | root + app | `pkg:maven/org.jetbrains.kotlin/kotlin-gradle-plugin@2.2.0` |
| 4 | Kotlin Parcelize | `org.jetbrains.kotlin.plugin.parcelize` | 2.2.0 | root + app | `pkg:maven/org.jetbrains.kotlin/kotlin-gradle-plugin@2.2.0` |
| 5 | Google KSP | `com.google.devtools.ksp` | 2.1.21-2.0.2 | root + app | `pkg:maven/com.google.devtools.ksp/symbol-processing-gradle-plugin@2.1.21-2.0.2` |
| 6 | Google Dagger Hilt | `com.google.dagger.hilt.android` | 2.56.2 | root + app | `pkg:maven/com.google.dagger/hilt-android-gradle-plugin@2.56.2` |
| 7 | Detekt | `io.gitlab.arturbosch.detekt` | 1.23.8 | root (applied to all subprojects) | `pkg:maven/io.gitlab.arturbosch.detekt/detekt-gradle-plugin@1.23.8` |
| 8 | Kotlinter | `org.jmailen.kotlinter` | 5.1.1 | root (subprojects) | `pkg:maven/org.jmailen.gradle/kotlinter-gradle@5.1.1` |
| 9 | Gradle Versions Plugin | `com.github.ben-manes.versions` | 0.52.0 | root | `pkg:maven/com.github.ben-manes/gradle-versions-plugin@0.52.0` |
| 10 | Paparazzi | `app.cash.paparazzi` | 1.3.5 | root + app | `pkg:maven/app.cash.paparazzi/paparazzi-gradle-plugin@1.3.5` |
| 11 | Square Sort Dependencies | `com.squareup.sort-dependencies` | 0.14 | root (subprojects) | `pkg:maven/com.squareup.sort-dependencies/com.squareup.sort-dependencies.gradle.plugin@0.14` |

---

## Optional / Configurable Components

> Controlled via `renameConfig` flags in `buildscripts/setup.gradle`. Components below can be removed at project initialization time.

| Component Group | Flag | Default State | Libraries Affected |
|---|---|---|---|
| Hilt (DI) | `useHiltDependencies` | `true` (included) | `hilt-android`, `hilt-android-compiler`, `hilt-android-testing`, `hilt-compiler`, `hilt-navigation-compose`, plugin `google-dagger-hilt` |
| Room (Database) | `useRoomDependencies` | `true` (included) | `androidx-room-runtime`, `androidx-room-compiler` |
| Retrofit / Moshi / OkHttp (Networking) | `useRetrofitDependencies` | `true` (included) | `square-retrofit`, `square-retrofit-converter-moshi`, `square-moshi-kotlin`, `square-moshi-kotlin-codegen`, `square-okhttp-logging-interceptor`, `coil-okhttp` |
| Paparazzi (Screenshot Testing) | `usePaparazziDependencies` | `true` (included) | plugin `cash-paparazzi` |
| AndroidX XR (Spatial Computing) | `useAndroidXR` | `false` (excluded) | `androidx-xr-compose`, `androidx-xr-compose-material3`, `androidx-xr-scenecore` |
| Renovate (Dependency Bot) | `useRenovateDependencies` | `true` (included) | `renovate.json5` config file |

---

## Version Catalog Summary

> Source: `gradle/libs.versions.toml`

| Alias | Resolved Version |
|---|---|
| `activityCompose` | 1.10.1 |
| `agp` | 8.11.0 |
| `androidxTest` | 1.2.1 |
| `appCompat` | 1.7.1 |
| `coil` | 3.2.0 |
| `compileSdk` | 35 |
| `composeBom` | 2025.06.01 |
| `detektGradlePlugin` | 1.23.8 |
| `espresso` | 3.6.1 |
| `gradleVersionsPlugin` | 0.52.0 |
| `hilt` | 2.56.2 |
| `hiltNavigationCompose` | 1.2.0 |
| `junit` | 4.13.2 |
| `kotlin` | 2.2.0 |
| `kotlinter` | 5.1.1 |
| `ksp` | 2.1.21-2.0.2 |
| `ktxCore` | 1.16.0 |
| `leakCanary` | 2.14 |
| `lifecycle` | 2.9.1 |
| `material` | 1.12.0 |
| `minSdk` | 23 |
| `moshi` | 1.15.2 |
| `navigationCompose` | 2.9.0 |
| `okhttp` | 4.12.0 |
| `paparazzi` | 1.3.5 |
| `retrofit` | 3.0.0 |
| `room` | 2.7.2 |
| `sortDependencies` | 0.14 |
| `xr` | 1.0.0-alpha04 |
| `xr-material` | 1.0.0-alpha08 |

---

## Supply Chain Security Notes

### BOM-Managed Dependencies
The Compose BOM (`androidx.compose:compose-bom:2025.06.01`) manages versions for all `androidx.compose.*` artifacts. Individual versions for these components are not pinned in `libs.versions.toml` and are resolved transitively at build time. This applies to:
- `androidx.compose.ui:ui`
- `androidx.compose.ui:ui-tooling`
- `androidx.compose.ui:ui-test-manifest`
- `androidx.compose.ui:ui-test-junit4`
- `androidx.compose.material3:material3`
- `androidx.compose.material:material-icons-extended`

### Alpha-Stage Components
The following components carry alpha-stage version identifiers and should be evaluated before production use:

| Component | Version | Risk |
|---|---|---|
| `androidx.xr.compose:compose` | 1.0.0-alpha04 | API instability; excluded by default (`useAndroidXR = false`) |
| `androidx.xr.compose.material3:material3` | 1.0.0-alpha08 | API instability; excluded by default |
| `androidx.xr.scenecore:scenecore` | 1.0.0-alpha04 | API instability; excluded by default |

### Debug-Only Memory Leak Detection
LeakCanary (`com.squareup.leakcanary:leakcanary-android:2.14`) is declared under `debugImplementation` only. It is **not** included in release builds (`buildTypes.release` in `app/build.gradle.kts`).

### Proguard / Code Shrinking
Release builds have `isMinifyEnabled = false` (line in `app/build.gradle.kts`). ProGuard configuration is referenced via `proguard-android-optimize.txt` but minification is currently disabled. Supply chain components are **not obfuscated** in release artifacts.

### Dependency Update Tooling
`com.github.ben-manes.versions` plugin (v0.52.0) and optional Renovate (`renovate.json5`) provide automated dependency update scanning. Both are enabled by default (`usePaparazziDependencies = true`, `useRenovateDependencies = true`).

### Static Analysis & Code Quality (CI Supply Chain)
Applied to all subprojects via root `build.gradle.kts`:

| Tool | Plugin ID | Version | Purpose |
|---|---|---|---|
| Detekt | `io.gitlab.arturbosch.detekt` | 1.23.8 | Kotlin static analysis / code smells |
| Kotlinter (Ktlint) | `org.jmailen.kotlinter` | 5.1.1 | Kotlin code formatting enforcement |
| Sort Dependencies | `com.squareup.sort-dependencies` | 0.14 | Canonical dependency ordering |

Git hooks (`buildscripts/githooks.gradle`) enforce these checks pre-commit. GitHub Actions CI (`/.github/workflows/`) further enforces them on pull requests.

---

## Complete Component Count

| Category | Count |
|---|---|
| Runtime libraries | 23 |
| Debug-only libraries | 3 |
| Unit test libraries | 1 |
| Instrumented test libraries | 4 |
| Code generation / annotation processors | 4 |
| Gradle build plugins | 11 |
| **Total** | **46** |

---

*This SBOM was generated from source: `gradle/libs.versions.toml` (version catalog), `app/build.gradle.kts` (dependency declarations), `build.gradle.kts` (plugin declarations), and `buildscripts/setup.gradle` (optional component configuration).*