I'll fetch the dependency catalog file to generate an accurate SPDX SBOM, as it contains the actual version and licensing information needed.# Software Bill of Materials (SPDX Format) — AndroidAppTemplate

**SPDX Version:** SPDX-2.3
**Data License:** CC0-1.0
**SPDX Identifier:** SPDXRef-DOCUMENT
**Document Name:** AndroidAppTemplate-SBOM
**Document Namespace:** https://github.com/manos-saratsis/AndroidAppTemplate/sbom/spdx
**Creator:** Tool: AndroidAppTemplate SPDX Generator
**Created:** 2025-01-01T00:00:00Z
**Source Reference:** [`gradle/libs.versions.toml`](gradle/libs.versions.toml), [`buildscripts/setup.gradle`](buildscripts/setup.gradle)

---

## Document Overview

This SPDX Software Bill of Materials catalogs all runtime dependencies, test dependencies, annotation processors, build plugins, and static analysis tools declared in [`gradle/libs.versions.toml`](gradle/libs.versions.toml) for the **AndroidAppTemplate** project (GitHub: `manos-saratsis/AndroidAppTemplate`). Dependency groups (Hilt, Room, Retrofit, Paparazzi, AndroidXR) are configurable via [`buildscripts/setup.gradle`](buildscripts/setup.gradle) and may be removed during project setup.

---

## Package Information

---

### SPDXRef-Package-android-gradle-plugin

| Field | Value |
|---|---|
| **PackageName** | Android Gradle Plugin |
| **SPDXID** | SPDXRef-Package-android-gradle-plugin |
| **PackageVersion** | 8.11.0 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/com/android/tools/build/gradle/8.11.0/gradle-8.11.0.pom |
| **PackageHomePage** | https://developer.android.com/studio/releases/gradle-plugin |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.android.tools.build:gradle:8.11.0 |
| **Source** | `gradle/libs.versions.toml` → `agp = "8.11.0"`, `gradle = { module = "com.android.tools.build:gradle" }` |

---

### SPDXRef-Package-kotlin

| Field | Value |
|---|---|
| **PackageName** | Kotlin |
| **SPDXID** | SPDXRef-Package-kotlin |
| **PackageVersion** | 2.2.0 |
| **PackageSupplier** | Organization: JetBrains s.r.o. |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/org/jetbrains/kotlin/kotlin-gradle-plugin/2.2.0/ |
| **PackageHomePage** | https://kotlinlang.org/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.0 |
| **Source** | `gradle/libs.versions.toml` → `kotlin = "2.2.0"`, `kotlin-gradle-plugin` |

---

### SPDXRef-Package-ksp

| Field | Value |
|---|---|
| **PackageName** | Kotlin Symbol Processing (KSP) |
| **SPDXID** | SPDXRef-Package-ksp |
| **PackageVersion** | 2.1.21-2.0.2 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/google/devtools/ksp/symbol-processing-gradle-plugin/2.1.21-2.0.2/ |
| **PackageHomePage** | https://github.com/google/ksp |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.google.devtools.ksp:symbol-processing-gradle-plugin:2.1.21-2.0.2 |
| **Source** | `gradle/libs.versions.toml` → `ksp = "2.1.21-2.0.2"`, `google-ksp` plugin |

---

### SPDXRef-Package-compose-bom

| Field | Value |
|---|---|
| **PackageName** | Jetpack Compose BOM |
| **SPDXID** | SPDXRef-Package-compose-bom |
| **PackageVersion** | 2025.06.01 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/androidx/compose/compose-bom/2025.06.01/ |
| **PackageHomePage** | https://developer.android.com/jetpack/compose |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.compose:compose-bom:2025.06.01 |
| **Source** | `gradle/libs.versions.toml` → `composeBom = "2025.06.01"`, `compose-bom` |

---

### SPDXRef-Package-compose-ui

| Field | Value |
|---|---|
| **PackageName** | Compose UI |
| **SPDXID** | SPDXRef-Package-compose-ui |
| **PackageVersion** | (managed by BOM 2025.06.01) |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://developer.android.com/jetpack/androidx/releases/compose-ui |
| **PackageHomePage** | https://developer.android.com/jetpack/compose |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.compose.ui:ui |
| **Source** | `gradle/libs.versions.toml` → `compose-ui = { group = "androidx.compose.ui", name = "ui" }` |

---

### SPDXRef-Package-compose-material3

| Field | Value |
|---|---|
| **PackageName** | Compose Material3 |
| **SPDXID** | SPDXRef-Package-compose-material3 |
| **PackageVersion** | (managed by BOM 2025.06.01) |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://developer.android.com/jetpack/androidx/releases/compose-material3 |
| **PackageHomePage** | https://m3.material.io/develop/android/jetpack-compose |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.compose.material3:material3 |
| **Source** | `gradle/libs.versions.toml` → `compose-material = { group = "androidx.compose.material3", name = "material3" }` |

---

### SPDXRef-Package-compose-material-icons-extended

| Field | Value |
|---|---|
| **PackageName** | Compose Material Icons Extended |
| **SPDXID** | SPDXRef-Package-compose-material-icons-extended |
| **PackageVersion** | (managed by BOM 2025.06.01) |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://developer.android.com/jetpack/androidx/releases/compose-material |
| **PackageHomePage** | https://developer.android.com/jetpack/compose |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.compose.material:material-icons-extended |
| **Source** | `gradle/libs.versions.toml` → `compose-material-icons-extended` |

---

### SPDXRef-Package-compose-ui-tooling

| Field | Value |
|---|---|
| **PackageName** | Compose UI Tooling |
| **SPDXID** | SPDXRef-Package-compose-ui-tooling |
| **PackageVersion** | (managed by BOM 2025.06.01) |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://developer.android.com/jetpack/androidx/releases/compose-ui |
| **PackageHomePage** | https://developer.android.com/jetpack/compose/tooling |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.compose.ui:ui-tooling |
| **Source** | `gradle/libs.versions.toml` → `compose-ui-tooling` |

---

### SPDXRef-Package-androidx-activity-compose

| Field | Value |
|---|---|
| **PackageName** | AndroidX Activity Compose |
| **SPDXID** | SPDXRef-Package-androidx-activity-compose |
| **PackageVersion** | 1.10.1 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/androidx/activity/activity-compose/1.10.1/ |
| **PackageHomePage** | https://developer.android.com/jetpack/androidx/releases/activity |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.activity:activity-compose:1.10.1 |
| **Source** | `gradle/libs.versions.toml` → `activityCompose = "1.10.1"` |

---

### SPDXRef-Package-androidx-core-ktx

| Field | Value |
|---|---|
| **PackageName** | AndroidX Core KTX |
| **SPDXID** | SPDXRef-Package-androidx-core-ktx |
| **PackageVersion** | 1.16.0 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/androidx/core/core-ktx/1.16.0/ |
| **PackageHomePage** | https://developer.android.com/jetpack/androidx/releases/core |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.core:core-ktx:1.16.0 |
| **Source** | `gradle/libs.versions.toml` → `ktxCore = "1.16.0"` |

---

### SPDXRef-Package-androidx-appcompat

| Field | Value |
|---|---|
| **PackageName** | AndroidX AppCompat |
| **SPDXID** | SPDXRef-Package-androidx-appcompat |
| **PackageVersion** | 1.7.1 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/androidx/appcompat/appcompat/1.7.1/ |
| **PackageHomePage** | https://developer.android.com/jetpack/androidx/releases/appcompat |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.appcompat:appcompat:1.7.1 |
| **Source** | `gradle/libs.versions.toml` → `appCompat = "1.7.1"` |

---

### SPDXRef-Package-androidx-lifecycle-runtime-ktx

| Field | Value |
|---|---|
| **PackageName** | AndroidX Lifecycle Runtime KTX |
| **SPDXID** | SPDXRef-Package-androidx-lifecycle-runtime-ktx |
| **PackageVersion** | 2.9.1 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/androidx/lifecycle/lifecycle-runtime-ktx/2.9.1/ |
| **PackageHomePage** | https://developer.android.com/jetpack/androidx/releases/lifecycle |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.lifecycle:lifecycle-runtime-ktx:2.9.1 |
| **Source** | `gradle/libs.versions.toml` → `lifecycle = "2.9.1"` |

---

### SPDXRef-Package-navigation-compose

| Field | Value |
|---|---|
| **PackageName** | AndroidX Navigation Compose |
| **SPDXID** | SPDXRef-Package-navigation-compose |
| **PackageVersion** | 2.9.0 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/androidx/navigation/navigation-compose/2.9.0/ |
| **PackageHomePage** | https://developer.android.com/jetpack/androidx/releases/navigation |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.navigation:navigation-compose:2.9.0 |
| **Source** | `gradle/libs.versions.toml` → `navigationCompose = "2.9.0"` |

---

### SPDXRef-Package-android-material

| Field | Value |
|---|---|
| **PackageName** | Android Material Components |
| **SPDXID** | SPDXRef-Package-android-material |
| **PackageVersion** | 1.12.0 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/google/android/material/material/1.12.0/ |
| **PackageHomePage** | https://github.com/material-components/material-components-android |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.google.android.material:material:1.12.0 |
| **Source** | `gradle/libs.versions.toml` → `material = "1.12.0"` |

---

### SPDXRef-Package-coil-compose

| Field | Value |
|---|---|
| **PackageName** | Coil Compose |
| **SPDXID** | SPDXRef-Package-coil-compose |
| **PackageVersion** | 3.2.0 |
| **PackageSupplier** | Organization: Coil Contributors |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/io/coil-kt/coil3/coil-compose/3.2.0/ |
| **PackageHomePage** | https://coil-kt.github.io/coil/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven io.coil-kt.coil3:coil-compose:3.2.0 |
| **Source** | `gradle/libs.versions.toml` → `coil = "3.2.0"` |

---

### SPDXRef-Package-coil-okhttp

| Field | Value |
|---|---|
| **PackageName** | Coil OkHttp Network Backend |
| **SPDXID** | SPDXRef-Package-coil-okhttp |
| **PackageVersion** | 3.2.0 |
| **PackageSupplier** | Organization: Coil Contributors |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/io/coil-kt/coil3/coil-network-okhttp/3.2.0/ |
| **PackageHomePage** | https://coil-kt.github.io/coil/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven io.coil-kt.coil3:coil-network-okhttp:3.2.0 |
| **Source** | `gradle/libs.versions.toml` → `coil-okhttp` |

---

### SPDXRef-Package-leakcanary *(Optional — configurable)*

| Field | Value |
|---|---|
| **PackageName** | LeakCanary |
| **SPDXID** | SPDXRef-Package-leakcanary |
| **PackageVersion** | 2.14 |
| **PackageSupplier** | Organization: Square Inc. |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/squareup/leakcanary/leakcanary-android/2.14/ |
| **PackageHomePage** | https://square.github.io/leakcanary/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.squareup.leakcanary:leakcanary-android:2.14 |
| **Source** | `gradle/libs.versions.toml` → `leakCanary = "2.14"` |

---

## Optional Dependency Group: Hilt

> Controlled by `useHiltDependencies` flag in `buildscripts/setup.gradle`. Set to `true` in the default `renameConfig`.

### SPDXRef-Package-hilt-android

| Field | Value |
|---|---|
| **PackageName** | Hilt Android |
| **SPDXID** | SPDXRef-Package-hilt-android |
| **PackageVersion** | 2.56.2 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/google/dagger/hilt-android/2.56.2/ |
| **PackageHomePage** | https://dagger.dev/hilt/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.google.dagger:hilt-android:2.56.2 |
| **Source** | `gradle/libs.versions.toml` → `hilt = "2.56.2"` |

### SPDXRef-Package-hilt-android-compiler

| Field | Value |
|---|---|
| **PackageName** | Hilt Android Compiler |
| **SPDXID** | SPDXRef-Package-hilt-android-compiler |
| **PackageVersion** | 2.56.2 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/google/dagger/hilt-android-compiler/2.56.2/ |
| **PackageHomePage** | https://dagger.dev/hilt/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.google.dagger:hilt-android-compiler:2.56.2 |
| **Source** | `gradle/libs.versions.toml` → `hilt-android-compiler` |

### SPDXRef-Package-hilt-compiler

| Field | Value |
|---|---|
| **PackageName** | Hilt Compiler |
| **SPDXID** | SPDXRef-Package-hilt-compiler |
| **PackageVersion** | 2.56.2 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/google/dagger/hilt-compiler/2.56.2/ |
| **PackageHomePage** | https://dagger.dev/hilt/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.google.dagger:hilt-compiler:2.56.2 |
| **Source** | `gradle/libs.versions.toml` → `hilt-compiler` |

### SPDXRef-Package-hilt-navigation-compose

| Field | Value |
|---|---|
| **PackageName** | Hilt Navigation Compose |
| **SPDXID** | SPDXRef-Package-hilt-navigation-compose |
| **PackageVersion** | 1.2.0 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/androidx/hilt/hilt-navigation-compose/1.2.0/ |
| **PackageHomePage** | https://developer.android.com/jetpack/androidx/releases/hilt |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.hilt:hilt-navigation-compose:1.2.0 |
| **Source** | `gradle/libs.versions.toml` → `hiltNavigationCompose = "1.2.0"` |

### SPDXRef-Package-hilt-android-testing

| Field | Value |
|---|---|
| **PackageName** | Hilt Android Testing |
| **SPDXID** | SPDXRef-Package-hilt-android-testing |
| **PackageVersion** | 2.56.2 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/google/dagger/hilt-android-testing/2.56.2/ |
| **PackageHomePage** | https://dagger.dev/hilt/testing.html |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.google.dagger:hilt-android-testing:2.56.2 |
| **Source** | `gradle/libs.versions.toml` → `hilt-android-testing` |

---

## Optional Dependency Group: Room

> Controlled by `useRoomDependencies` flag in `buildscripts/setup.gradle`. Set to `true` in the default `renameConfig`.

### SPDXRef-Package-room-runtime

| Field | Value |
|---|---|
| **PackageName** | AndroidX Room Runtime |
| **SPDXID** | SPDXRef-Package-room-runtime |
| **PackageVersion** | 2.7.2 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/androidx/room/room-runtime/2.7.2/ |
| **PackageHomePage** | https://developer.android.com/training/data-storage/room |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.room:room-runtime:2.7.2 |
| **Source** | `gradle/libs.versions.toml` → `room = "2.7.2"` |

### SPDXRef-Package-room-compiler

| Field | Value |
|---|---|
| **PackageName** | AndroidX Room Compiler |
| **SPDXID** | SPDXRef-Package-room-compiler |
| **PackageVersion** | 2.7.2 |
| **PackageSupplier** | Organization: Google LLC |
| **PackageDownloadLocation** | https://dl.google.com/dl/android/maven2/androidx/room/room-compiler/2.7.2/ |
| **PackageHomePage** | https://developer.android.com/training/data-storage/room |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven androidx.room:room-compiler:2.7.2 |
| **Source** | `gradle/libs.versions.toml` → `androidx-room-compiler` |

---

## Optional Dependency Group: Retrofit + OkHttp + Moshi

> Controlled by `useRetrofitDependencies` flag in `buildscripts/setup.gradle`. Set to `true` in the default `renameConfig`. Removing this group also removes `moshi` and `okhttp` dependencies (see `buildscripts/setup.gradle` → `keepOrRemoveDependencies` task).

### SPDXRef-Package-retrofit

| Field | Value |
|---|---|
| **PackageName** | Retrofit |
| **SPDXID** | SPDXRef-Package-retrofit |
| **PackageVersion** | 3.0.0 |
| **PackageSupplier** | Organization: Square Inc. |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/squareup/retrofit2/retrofit/3.0.0/ |
| **PackageHomePage** | https://square.github.io/retrofit/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.squareup.retrofit2:retrofit:3.0.0 |
| **Source** | `gradle/libs.versions.toml` → `retrofit = "3.0.0"` |

### SPDXRef-Package-retrofit-converter-moshi

| Field | Value |
|---|---|
| **PackageName** | Retrofit Moshi Converter |
| **SPDXID** | SPDXRef-Package-retrofit-converter-moshi |
| **PackageVersion** | 3.0.0 |
| **PackageSupplier** | Organization: Square Inc. |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/squareup/retrofit2/converter-moshi/3.0.0/ |
| **PackageHomePage** | https://square.github.io/retrofit/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.squareup.retrofit2:converter-moshi:3.0.0 |
| **Source** | `gradle/libs.versions.toml` → `square-retrofit-converter-moshi` |

### SPDXRef-Package-okhttp-logging-interceptor

| Field | Value |
|---|---|
| **PackageName** | OkHttp Logging Interceptor |
| **SPDXID** | SPDXRef-Package-okhttp-logging-interceptor |
| **PackageVersion** | 4.12.0 |
| **PackageSupplier** | Organization: Square Inc. |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/squareup/okhttp3/logging-interceptor/4.12.0/ |
| **PackageHomePage** | https://square.github.io/okhttp/ |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.squareup.okhttp3:logging-interceptor:4.12.0 |
| **Source** | `gradle/libs.versions.toml` → `okhttp = "4.12.0"` |

### SPDXRef-Package-moshi-kotlin

| Field | Value |
|---|---|
| **PackageName** | Moshi Kotlin |
| **SPDXID** | SPDXRef-Package-moshi-kotlin |
| **PackageVersion** | 1.15.2 |
| **PackageSupplier** | Organization: Square Inc. |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/squareup/moshi/moshi-kotlin/1.15.2/ |
| **PackageHomePage** | https://github.com/square/moshi |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.squareup.moshi:moshi-kotlin:1.15.2 |
| **Source** | `gradle/libs.versions.toml` → `moshi = "1.15.2"` |

### SPDXRef-Package-moshi-kotlin-codegen

| Field | Value |
|---|---|
| **PackageName** | Moshi Kotlin Codegen |
| **SPDXID** | SPDXRef-Package-moshi-kotlin-codegen |
| **PackageVersion** | 1.15.2 |
| **PackageSupplier** | Organization: Square Inc. |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/com/squareup/moshi/moshi-kotlin-codegen/1.15.2/ |
| **PackageHomePage** | https://github.com/square/moshi |
| **FilesAnalyzed** | false |
| **PackageLicense** | Apache-2.0 |
| **ExternalRef** | PACKAGE-MANAGER maven com.squareup.moshi:moshi-kotlin-codegen:1.15.2 |
| **Source** | `gradle/libs.versions.toml` → `square-moshi-kotlin-codegen` |

---

## Optional Dependency Group: Paparazzi

> Controlled by `usePaparazziDependencies` flag in `buildscripts/setup.gradle`. Set to `true` in the default `renameConfig`.

### SPDXRef-Package-paparazzi

| Field | Value |
|---|---|
| **PackageName** | Paparazzi |
| **SPDXID** | SPDXRef-Package-paparazzi |
| **PackageVersion** | 1.3.5 |
| **PackageSupplier** | Organization: Cash App (Square Inc.) |
| **PackageDownloadLocation** | https://repo1.maven.org/maven2/app/cash/paparazzi/paparazzi-gradle-plugin/1.3.5/ |
| **PackageHomePage** | https://github.com/cashapp/paparazzi |
| **FilesAnalyzed