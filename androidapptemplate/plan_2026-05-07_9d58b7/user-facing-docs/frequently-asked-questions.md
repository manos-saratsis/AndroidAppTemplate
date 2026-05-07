# Frequently Asked Questions — Android App Template

Quick answers to the most common questions about getting started, configuring, and maintaining the Android App Template.

---

## 1. Can I use this template with Java instead of Kotlin?

The Android App Template is built with **Kotlin** as its primary language, and the included tooling — particularly Ktlint for code formatting and Detekt for static analysis — is designed specifically for Kotlin codebases. If you prefer to write your app in Java, you can still use this template, but you should be aware that:

- The formatting and static analysis tools (Ktlint, Detekt) will only apply to Kotlin files and will not lint your Java code.
- The git hooks run Ktlint checks on modified Kotlin files automatically; Java files are not covered by these hooks.
- All other tools (dependency version checks, GitHub Actions, LeakCanary, etc.) work independently of the language you choose.

For a purely Java project, you may want to remove or replace the Kotlin-specific tooling to avoid confusion. If you write a mixed Kotlin/Java codebase, the tooling will still provide value for your Kotlin files.

---

## 2. Can I remove tools I don't want (e.g., Detekt, LeakCanary)?

**Yes, absolutely.** The template is intentionally designed to be modular and easy to trim down.

Here is how to remove tools you don't need:

- **Detekt, Ktlint, Git Hooks, and the Gradle Versions Plugin** each have their own dedicated Gradle file inside the `buildscripts` folder. To remove one, you can delete its corresponding Gradle file and remove the line that applies it in your root `build.gradle.kts`.
- **LeakCanary** is included as an app-level dependency. You can simply remove its dependency entry from the version catalog (`gradle/libs.versions.toml`) and any references to it in your app module.
- **Hilt, Room, and Paparazzi** are optional from the start. The `setup.gradle` file inside the `buildscripts` folder lets you opt out of these dependencies during initial setup. If you've already run the setup task, you can manually remove their entries from the version catalog and module-level build files.

The template's goal is to give you a strong starting point — not to lock you in to any particular set of tools.

---

## 3. How do I update the template tools after starting my project?

The template uses a **Gradle version catalog** (located at `gradle/libs.versions.toml`) to manage all dependency versions in one place. To update tools and libraries:

1. Navigate to the `gradle/libs.versions.toml` file in your project.
2. Update the version numbers for any tools you want to upgrade (e.g., Detekt, Ktlint, LeakCanary).
3. Sync your project to apply the changes.

To make this process even easier, the template includes the **Gradle Versions Plugin**, which scans all of your dependencies and reports which ones have newer versions available. You can run this check at any time to get a report of outdated tools without having to check each one manually.

For tooling configuration changes (such as Detekt rules or Ktlint settings), look inside the `buildscripts` folder where each tool has its own dedicated Gradle file.

---

## 4. Why are git hooks not committed as executable files?

This is a known cross-platform challenge. Git does not reliably preserve file permissions (such as the executable bit) across different operating systems — particularly between macOS/Linux and Windows. If the hooks were committed as executable files, they might not work correctly on every developer's machine.

**The solution** is the built-in Gradle tasks that install the hooks for you:

- Run `./gradlew copyGitHooks` to copy the hook files into the correct `.git/hooks` directory.
- Run `./gradlew installGitHooks` to ensure the hooks are installed and executable.

Even better — the hooks are **installed automatically** whenever you run a `clean` task, so most developers will have them set up without needing to think about it. You do not need to do anything special; just run a clean build and the hooks will be ready to go.

---

## 5. Does this template work with Jetpack Compose?

The template does **not include Jetpack Compose by default**, keeping in line with its philosophy of not being opinionated about how you write your app's UI. However, you can absolutely add Compose to a project created from this template.

To add Compose:

1. Add the required Compose dependencies and the Compose compiler version to your `gradle/libs.versions.toml` file.
2. Enable Compose in your app module's build configuration by setting `buildFeatures { compose = true }` and specifying the `composeOptions`.
3. Start writing composable functions as you normally would.

All of the template's tooling (CI via GitHub Actions, static analysis, git hooks, dependency version checks) will continue to work alongside Compose without any conflicts, since they operate at the build and Kotlin code level rather than being tied to a specific UI framework.

---

## 6. How do I contribute back to the template?

Contributions are welcome! The template is open to feedback and improvements. Here is how to get involved:

- **Report a problem or suggest a change**: Open a new [Issue on the repository](https://github.com/AdamMc331/AndroidAppTemplate/issues/new). If you think something is missing or that a setup should be changed, this is the right place to start the conversation.
- **Submit a fix or improvement**: Fork the repository, make your changes, and open a Pull Request. The repository includes a Pull Request template to help you write a clear and detailed description of your changes.
- **Check existing issues**: Before opening a new issue, browse the existing ones to see if your question or suggestion has already been raised.

The template maintainer (Adam McNeilly) reviews issues and pull requests, so community feedback directly shapes the direction of the project.

---

## 7. Is this template maintained?

Yes. The template is actively maintained by [Adam McNeilly](https://github.com/AdamMc331) and shaped by community feedback through GitHub Issues and Pull Requests.

Key things to know about the maintenance approach:

- **Tooling stays current**: The included tools (Ktlint, Detekt, LeakCanary, Hilt, Room, etc.) are updated over time, and the Gradle Versions Plugin is included specifically to make it easy to track when updates are available.
- **Community-driven improvements**: The repository description explicitly invites users to submit issues if they feel something is missing or should be changed — meaning the template evolves based on real-world developer needs.
- **Stable automation**: GitHub Actions workflows are included to run continuous integration checks, ensuring that the template itself stays in a healthy, buildable state as changes are made.

If you are evaluating the template for a new project, check the repository's commit history and open issues on GitHub for the most up-to-date picture of recent activity.

---

*Still have questions? Open an [Issue](https://github.com/AdamMc331/AndroidAppTemplate/issues/new) on the repository and the maintainer or community members will be happy to help.*