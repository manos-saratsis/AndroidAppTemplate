# Frequently Asked Questions

Quick answers to the most common questions about the Android App Template.

---

## Can I remove a tool I don't want?

**Yes!** The template is designed so that tools can be removed cleanly. When you first set up the template, open the setup configuration and look for options to remove optional dependencies — Hilt, Room, and Paparazzi can all be toggled off through the setup process.

For other tools like **Detekt**, **Ktlint (Kotlinter)**, or **LeakCanary**, each tool has its own self-contained configuration file. You can remove the tool by:

1. Deleting or commenting out the line that applies its build script in your root `build.gradle.kts`
2. Removing the corresponding entry from the version catalog (`gradle/libs.versions.toml`)
3. Removing any related configuration files (for example, the Detekt config folder)

**Git Hooks** can be removed by deleting the hooks scripts — they run automatically on commit but are not required for the project to build or run.

---

## Does this template support Kotlin Multiplatform or only Android?

This template is **Android-only**. It is purpose-built to kick-start an Android application project and all included tooling (Detekt, Ktlint, LeakCanary, GitHub Actions workflows, etc.) is configured specifically for Android development.

If you need Kotlin Multiplatform support, this template is not the right starting point — you would need a separate KMP-focused setup.

---

## How do I add my own dependencies using the version catalog?

All dependencies are managed through a central version catalog file located at `gradle/libs.versions.toml`. This file has three sections you'll work with:

- **`[versions]`** — Define a version number with a label (e.g., `retrofit = "3.0.0"`)
- **`[libraries]`** — Declare a library and point it to a version label (e.g., `square-retrofit = { module = "com.squareup.retrofit2:retrofit", version.ref = "retrofit" }`)
- **`[plugins]`** — Declare Gradle plugins the same way

**To add a new dependency:**

1. Add its version under `[versions]`
2. Add the library entry under `[libraries]`, referencing that version
3. Use it in your module's build file using the `libs.` accessor (e.g., `libs.square.retrofit`)

This approach means all version numbers live in one place, making upgrades and audits straightforward — especially across multi-module projects.

---

## Is this template compatible with Jetpack Compose?

**Yes.** The template is intentionally **architecture-neutral** — it does not force any particular UI toolkit or app architecture on you. The version catalog already includes Compose-related entries (Compose BOM, Material 3, Navigation Compose, UI tooling, etc.), so Compose is ready to use out of the box if you want it.

If you prefer a View-based UI, you are equally free to go that route. The template's philosophy is to give you confidence in your *tooling* (formatting, static analysis, CI, dependency management) without dictating *how you write your code*.

---

## How do I update the template tools themselves?

The template includes the **Gradle Versions Plugin**, which checks every dependency in the project — including the template tools themselves — for newer stable releases.

Run the following command in your terminal from the project root:

```
./gradlew dependencyUpdates
```

This will print a report to your console listing any dependencies that have newer versions available, including tools like Detekt, Ktlint/Kotlinter, LeakCanary, and Hilt. Once you see what needs updating, change the version number in `gradle/libs.versions.toml` and sync your project.

By default, the plugin is configured to only suggest **stable** releases, so you won't be nudged toward alpha or beta versions unintentionally.

---

## Do I need to change anything before I start coding?

Before you begin, it's recommended to run the built-in `renameTemplate` Gradle task. This replaces the template's placeholder package name and app strings with your own. You configure what to rename in the setup file, run the task, and the template handles the rest — including cleaning up the setup files so they don't ship with your real app.

---

## What continuous integration is included?

The template ships with **GitHub Actions** workflows that automatically run on every pull request. These checks include static analysis (Detekt and Ktlint) to ensure code quality standards are maintained without any manual effort from reviewers.

A **Pull Request Template** is also included, prompting contributors to write organized and descriptive PR descriptions every time.