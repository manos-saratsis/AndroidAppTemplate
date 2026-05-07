---

## 1. GitHub Account

The template is hosted on GitHub and uses GitHub's "Use this template" feature to create your new project.

- You need a **free GitHub account** at [github.com](https://github.com)
- Once signed in, click the **"Use this template"** button at the top-right of the template repository page to generate your own copy

---

## 2. Android Studio

Android Studio is the official tool for building Android apps and is required to open and run any project created from this template.

| Requirement | Details |
|---|---|
| **Recommended version** | Android Studio **Meerkat (2024.3)** or newer |
| **Why this version?** | The template uses Android Gradle Plugin **8.11.0** and Kotlin **2.2.0**, which require a recent version of Android Studio to function correctly |

> **How to check your version:** Open Android Studio → Help → About. If your version is older, download the latest stable release from [developer.android.com/studio](https://developer.android.com/studio).

---

## 3. Java Development Kit (JDK) — Version 17

The template is configured to compile using **Java 17**. Android Studio ships with a bundled JDK, but it must be version 17 or later.

- The project explicitly targets **Java 17** for both source and bytecode compatibility
- Android Studio **Hedgehog (2023.1.1)** and newer bundle JDK 17 automatically — no separate install needed
- If you manage the JDK yourself, install [JDK 17](https://adoptium.net/) or higher

> **How to verify inside Android Studio:** Go to **File → Project Structure → SDK Location** and confirm the Gradle JDK shown is version 17.

---

## 4. Gradle — Version 8.14.2

Gradle is the build system that compiles and packages your app. This template comes with a built-in **Gradle Wrapper**, so you do **not** need to install Gradle separately — it downloads the correct version automatically when you first sync the project.

| Setting | Value |
|---|---|
| **Gradle version** | 8.14.2 |
| **Android Gradle Plugin (AGP)** | 8.11.0 |
| **Distribution type** | Binary (downloads automatically on first sync) |
| **Network required on first open?** | Yes — the wrapper fetches Gradle from `services.gradle.org` |

No manual Gradle installation is needed. Simply open the project in Android Studio and allow it to sync.

---

## 5. Kotlin — Version 2.2.0

All code in this template is written in **Kotlin**. The Kotlin compiler is bundled as part of the project's Gradle configuration — you do not install it separately.

| Item | Version |
|---|---|
| **Kotlin** | 2.2.0 |
| **KSP (Kotlin Symbol Processing)** | 2.1.21-2.0.2 |
| **JVM target** | 17 |

Kotlin is downloaded automatically when Android Studio syncs the project for the first time.

---

## 6. Git — Required for Git Hooks

This template includes **Git hooks** that automatically run code formatting and static analysis checks every time you commit code. For these hooks to work, Git must be installed on your machine.

- **Download Git:** [git-scm.com/downloads](https://git-scm.com/downloads)
- **Minimum version:** Any recent stable release (2.x) works fine
- Git is also required to clone your repository after creating it from the template

> **How to check if Git is installed:** Open a terminal and run `git --version`. If you see a version number, you're good to go.

---

## 7. Android SDK — API Level 23 and Above

The template targets the following Android API levels:

| Setting | Value |
|---|---|
| **Minimum supported Android version** | Android 6.0 (API 23) |
| **Target / Compile SDK** | Android 15 (API 35) |

The Android SDK is installed and managed through Android Studio via **Tools → SDK Manager**. Make sure you have at least the **Android 15 (API 35)** SDK platform installed to compile the project successfully.

---

## Quick Pre-Flight Checklist

Use this checklist to confirm your environment is ready before creating a project:

- [ ] GitHub account created at [github.com](https://github.com)
- [ ] Android Studio installed (Meerkat 2024.3 or newer recommended)
- [ ] JDK 17 available (bundled with recent Android Studio versions)
- [ ] Git installed and accessible from the command line
- [ ] Internet connection available for the first Gradle sync
- [ ] Android SDK API 35 installed via SDK Manager

Once all boxes are checked, head to the template repository, click **"Use this template"**, and you're ready to start building.