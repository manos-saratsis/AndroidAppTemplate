# How to Check for Dependency Updates

Keeping your project's dependencies up to date is one of the most important habits for maintaining a healthy, secure Android project. Outdated libraries can introduce security vulnerabilities, bugs, or compatibility issues. This guide shows you how to use the built-in dependency update checker to instantly see which libraries in your project have newer versions available.

---

## What Is the Gradle Versions Plugin?

This project includes the [Gradle Versions Plugin](https://github.com/ben-manes/gradle-versions-plugin), a tool that automatically scans every library your project depends on and checks whether newer versions exist. Instead of manually visiting each library's page to look for updates, you run a single command and get a complete report in seconds.

The plugin is already configured to focus on **stable releases only** — it filters out alpha, beta, and release candidate (RC) versions by default, so you won't be overwhelmed with pre-release suggestions that aren't ready for production use.

---

## Running the Dependency Update Check

Open a terminal at the root of your project and run the following command:

```
./gradlew dependencyUpdates
```

That's it. The plugin will scan all dependencies and produce a report.

> **On Windows?** Use `gradlew.bat dependencyUpdates` instead.

---

## Reading the Report

Once the command finishes, results appear in two places:

1. **Your terminal / console** — A summary is printed directly to the screen, organized into clear sections.
2. **A text file** — A full report is saved as a file in your project, which you can open and review at any time.

### What the Report Shows You

The report is divided into three main sections:

| Section | What It Means |
|---|---|
| **Current** | Dependencies that are already up to date — no action needed. |
| **Outdated** | Dependencies where a newer stable version is available. These are the ones to update. |
| **Exceeded** | Dependencies where your version is newer than what's available in the repository (rare). |
| **Unresolved** | Dependencies the plugin couldn't look up (e.g., network issues or private repositories). |

Focus your attention on the **Outdated** section — it tells you exactly which library you're using, your current version, and the latest available stable version.

---

## How Unstable Versions Are Filtered Out

The plugin is configured to automatically ignore pre-release versions, including:

- **Alpha** releases (e.g., `2.0.0-alpha01`)
- **Beta** releases (e.g., `2.0.0-beta02`)
- **Release Candidates** (e.g., `2.0.0-rc01`)
- **Snapshot** builds

This means the report only surfaces versions that are considered production-ready. If you want to include pre-release versions in your checks — for example, to test a new alpha library — you can adjust this behavior in the plugin's configuration file within the `buildscripts` folder of the project.

---

## Acting on the Report

When you see an outdated dependency, the update process is straightforward:

1. **Note the library name and the suggested new version** from the report.
2. **Open your project's version catalog** (the `libs.versions.toml` file) or the relevant build file where that library version is defined.
3. **Update the version number** to the one suggested in the report.
4. **Sync your project** and run your tests to make sure everything still works correctly.

> **Tip:** Update one library at a time and verify your build passes before moving to the next. This makes it easy to identify if a particular update causes a problem.

---

## When Should You Run This Check?

There is no single rule, but here are recommended practices:

| Situation | Recommendation |
|---|---|
| **Regular maintenance** | Run the check once a week or once every two weeks to stay on top of updates. |
| **Before a release** | Always check for updates before publishing a new version of your app. |
| **After a security incident** | Run immediately if a vulnerability is announced in a library you might use. |
| **When onboarding** | Run the check when you first clone the project to understand its current state. |

### Automating the Check in CI

You can add the `dependencyUpdates` command to your Continuous Integration (CI) pipeline so it runs automatically on a schedule (e.g., weekly). While the task itself won't fail your build when outdated dependencies are found, the generated report can be saved as a CI artifact for your team to review regularly. This keeps the whole team informed without anyone having to remember to run it manually.

---

## Summary

| Step | Action |
|---|---|
| 1 | Run `./gradlew dependencyUpdates` in your terminal |
| 2 | Review the **Outdated** section of the report |
| 3 | Update version numbers for the libraries listed |
| 4 | Sync, build, and run tests to confirm everything works |
| 5 | Repeat on a regular schedule or via CI automation |

By checking for dependency updates regularly, you keep your project secure, stable, and compatible with the latest Android ecosystem improvements.