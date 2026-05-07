# How to Check for Dependency Updates

Keeping your app's libraries up to date is important for security, performance, and access to new features. This project includes a built-in tool — the **Gradle Versions Plugin** — that automatically scans all your dependencies and tells you which ones have newer versions available.

---

## What the Gradle Versions Plugin Does

The Gradle Versions Plugin inspects every library and tool declared in your project and compares them against the latest published versions. It then produces a clear report showing:

- **Dependencies that are up to date** — no action needed
- **Dependencies with newer versions available** — candidates for upgrading
- **Dependencies using pre-release versions** — flagged separately (see below)

By default, this project configures the plugin to **only report stable releases**, so you won't be flooded with alpha, beta, or release-candidate versions unless you want them.

---

## Running the Dependency Check

Open a terminal at the root of your project and run:

```
./gradlew dependencyUpdates
```

That's it. The task will scan all declared dependencies and produce results in two places:

1. **Your terminal / console** — a summary is printed directly so you can review it immediately
2. **A text file** — a report file is saved so you can revisit it later without re-running the task

> **Tip:** On Windows, you may need to use `gradlew.bat dependencyUpdates` instead.

---

## Reading the Report

After the task completes, the output is organized into clear sections:

| Section | What It Means |
|---|---|
| **The following dependencies are using the latest milestone version** | These are already current — no action needed |
| **The following dependencies have later milestone versions** | These can be upgraded — the report shows your current version and the latest available stable version |
| **The following dependencies exceed the version found at the revision level** | You may be on a newer version than what was officially found |

### Example Output (What You Might See)

```
The following dependencies have later milestone versions:
 - androidx.core:core-ktx [1.15.0 -> 1.16.0]
 - com.squareup.retrofit2:retrofit [2.9.0 -> 3.0.0]
```

This tells you the library name, the version currently in use, and the latest stable version you could upgrade to.

---

## How Dependencies Are Managed in This Project

All dependency versions are centrally managed in a single file called the **Version Catalog** (`gradle/libs.versions.toml`). This means every library version is defined in one place, making updates straightforward and consistent.

The versions section at the top of that file looks like this:

```toml
[versions]
activityCompose = "1.10.1"
kotlin = "2.2.0"
retrofit = "3.0.0"
room = "2.7.2"
# ... and so on
```

Each version has a name (like `retrofit`) and a value (like `"3.0.0"`). All the libraries in your project reference these named versions, so changing a version number in one place updates it everywhere it's used.

---

## Updating a Dependency After Finding a Newer Version

Once you've identified a dependency that needs updating from the report, follow these steps:

1. **Find the version name** — Look at the report output to identify the library (e.g., `androidx.core:core-ktx`)
2. **Open the versions file** — Navigate to the `gradle/libs.versions.toml` file in your project
3. **Locate the version entry** — Find the corresponding entry in the `[versions]` section (e.g., `ktxCore = "1.16.0"`)
4. **Update the version number** — Change the value to the newer version shown in the report
5. **Sync your project** — In Android Studio, click **Sync Now** when prompted, or run `./gradlew build` to verify everything still compiles

**Example:** To update `core-ktx` from `1.15.0` to `1.16.0`, you would change:
```toml
ktxCore = "1.15.0"
```
to:
```toml
ktxCore = "1.16.0"
```

> **Important:** After updating, always run your tests to make sure nothing broke. Major version bumps (e.g., `2.x` → `3.x`) may include breaking changes that require code adjustments.

---

## Filtering Out Unstable Versions

The plugin is already configured to **exclude unstable pre-release versions** (alpha, beta, RC) from the report by default. This means when you run `dependencyUpdates`, you'll only see fully stable releases — keeping your upgrade path safe and predictable.

If you want to change this behavior (for example, to see all available versions including pre-releases), you can adjust the plugin's settings in the **`buildscripts/versionsplugin.gradle`** file in your project.

### What "Unstable" Versions Look Like

These version suffixes are considered unstable and are filtered out by default:

| Suffix | Meaning |
|---|---|
| `-alpha` | Early preview, may be incomplete |
| `-beta` | Feature-complete but potentially buggy |
| `-rc` | Release candidate, nearly final but not guaranteed stable |
| `-SNAPSHOT` | Development build, not for production |

Stable versions (e.g., `1.2.3` with no suffix) will always appear in the report.

---

## Quick Reference

| Action | Command / Location |
|---|---|
| Run the dependency audit | `./gradlew dependencyUpdates` in your terminal |
| View results | Console output or the generated report text file |
| Update a version | Edit `gradle/libs.versions.toml` under `[versions]` |
| Configure stable-only filter | Edit `buildscripts/versionsplugin.gradle` |