---

## Quick Checklist

- [ ] Android Studio installed (Hedgehog or newer recommended)
- [ ] JDK 17 available on your machine
- [ ] Git installed and accessible from your terminal
- [ ] A GitHub account
- [ ] Android device or emulator running Android 6.0 (API 23) or higher

---

## 1. Android Studio

You need **Android Studio** to open, build, and run this project. Android Studio is Google's official development environment for Android apps and is available for free.

**Download:** [https://developer.android.com/studio](https://developer.android.com/studio)

> **Recommended:** Use the latest stable release of Android Studio. This template targets a modern Android toolchain (Android Gradle Plugin **8.11.0**), so older versions of Android Studio may not be fully compatible.

---

## 2. Java Development Kit (JDK) — Version 17

This template requires **JDK 17**. Both the app's source code compilation and Kotlin compilation are configured to use Java 17.

**How to check your JDK version:**

Open a terminal (Command Prompt on Windows, Terminal on macOS/Linux) and run:

```
java -version
```

You should see output that includes `version "17"` or higher. If not, you need to install JDK 17.

**Where to get JDK 17:**
- [Adoptium (Eclipse Temurin) — recommended](https://adoptium.net/temurin/releases/?version=17)
- [Oracle JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)

> **Tip:** Android Studio comes bundled with a JDK. If your Android Studio version bundles JDK 17, you may not need a separate installation. You can verify which JDK Android Studio is using under **File → Settings → Build, Execution, Deployment → Build Tools → Gradle → Gradle JDK**.

---

## 3. Gradle — Handled Automatically

You do **not** need to install Gradle separately. This project uses the **Gradle Wrapper**, which automatically downloads the correct version of Gradle the first time you build the project.

The project is configured to use **Gradle 8.14.2**. This download happens silently in the background the first time you sync or build in Android Studio.

> **Note:** Make sure you have an internet connection the first time you open the project, so the Gradle Wrapper can download the required version.

---

## 4. Git — Required for Git Hooks

This template includes **Git Hooks** that automatically run code quality checks (formatting and static analysis) every time you make a commit. For these hooks to work, **Git must be installed** on your machine.

**How to check if Git is installed:**

Open a terminal and run:

```
git --version
```

If you see a version number (e.g., `git version 2.40.0`), you're good to go. If not, install Git:

- **macOS:** Install via [Homebrew](https://brew.sh/) with `brew install git`, or download from [git-scm.com](https://git-scm.com/download/mac)
- **Windows:** Download the installer from [git-scm.com](https://git-scm.com/download/win)
- **Linux:** Use your package manager, e.g., `sudo apt install git` (Ubuntu/Debian) or `sudo dnf install git` (Fedora)

### OS-Specific Notes for Git Hooks

The template includes automated workflows to install Git hooks on both **macOS** and **Windows**. The hooks run shell scripts, so the following applies:

| Operating System | Notes |
|---|---|
| **macOS** | Fully supported. Git hooks run natively in your terminal. |
| **Windows** | Supported. Git for Windows (Git Bash) provides the shell environment the hooks need. Make sure you use Git Bash or a compatible terminal when running Git commands. |
| **Linux** | Fully supported. Git hooks run natively in your terminal. |

---

## 5. A GitHub Account

To use this project as a starting point for your own app, you need a **GitHub account** — it's free.

**Sign up at:** [https://github.com/join](https://github.com/join)

You need a GitHub account because:
- The template is hosted on GitHub, and the **"Use this template"** button creates a copy of the project directly in your own GitHub account.
- GitHub Actions (the automated quality checks that run on every pull request) are powered by GitHub and require a repository on GitHub to function.

---

## 6. Android Device Requirements

The app built from this template supports devices running **Android 6.0 (Marshmallow) or higher** (API level 23+). You can run the app on:

- A **physical Android device** running Android 6.0 or newer, connected via USB with USB debugging enabled.
- An **Android emulator** set up inside Android Studio with an API level of 23 or higher.

---

## Summary Table

| Requirement | Minimum Version | How to Verify |
|---|---|---|
| Android Studio | Latest stable (AGP 8.11.0 compatible) | Open Android Studio → Help → About |
| JDK | 17 | `java -version` in terminal |
| Gradle | 8.14.2 (auto-downloaded) | No action needed |
| Git | Any recent version | `git --version` in terminal |
| GitHub Account | — | Sign in at github.com |
| Android OS (target device) | 6.0 / API 23 | Check device Settings → About Phone |

---

Once all items in this checklist are verified, you're ready to click **"Use this template"** on GitHub and begin your project.