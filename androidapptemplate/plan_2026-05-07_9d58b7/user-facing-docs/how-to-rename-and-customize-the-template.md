# How to Rename and Customize the Template

Once you've created your project from this template, the next step is making it your own — giving it your app's name, package identity, and choosing which built-in tools you want to keep. This is handled through a single setup step that takes just a few minutes.

---

## Overview

The template ships with a ready-made setup tool. You fill in a short list of details about your project, choose which optional features to include, and then run one command. The template takes care of everything else automatically.

---

## Step 1: Open the Setup Configuration

Navigate to the **`buildscripts/setup.gradle`** file in the root of your project. Near the top, you'll find a block called `renameConfig` — this is where all your customization happens.

It looks like this out of the box:

```
renameConfig = [
    newPackage              : "aaa.yourname.app",
    newProjectName          : "Your Project",
    newMaterialThemeName    : "MyMaterialTheme",
    newApplicationClassName : "MyApp",
    ...
]
```

---

## Step 2: Fill In Your Project Details

Replace the placeholder values with your own. Here's what each field means:

| Field | What to Enter | Example |
|-------|--------------|---------|
| `newPackage` | Your app's unique package name (reverse-domain style) | `com.acme.myapp` |
| `newProjectName` | The display name of your app | `Acme App` |
| `newMaterialThemeName` | The name for your Material Design theme | `AcmeTheme` |
| `newApplicationClassName` | The name for your Application class | `AcmeApp` |

> **Tip:** Your package name should follow the standard format: `com.yourcompany.yourapp`. It must be unique if you plan to publish to the Google Play Store.

---

## Step 3: Choose Which Features to Include

Below the naming fields, you'll see a set of `true/false` switches for optional features. Set each one to `true` to keep it in your project, or `false` to have it automatically removed:

| Feature | What It Does | Default |
|---------|-------------|---------|
| `useHiltDependencies` | Dependency injection with Hilt | `true` |
| `useRoomDependencies` | Local database support with Room | `true` |
| `useRetrofitDependencies` | Networking with Retrofit, Moshi & OkHttp | `true` |
| `usePaparazziDependencies` | Screenshot testing with Paparazzi | `true` |
| `useRenovateDependencies` | Automated dependency update tracking | `true` |
| `useAndroidXR` | Android XR (extended reality) support | `false` |

Set any feature you don't need to `false` and its dependencies will be cleanly removed from your project automatically.

---

## Step 4: Run the Rename Task

Once your `renameConfig` is filled in, you need to run the **`renameTemplate`** Gradle task. You can do this in two ways:

### Option A — From Android Studio

1. Open the **Gradle panel** on the right side of Android Studio
2. Expand your project → **Template Setup**
3. Double-click **`renameTemplate`**

### Option B — From the Command Line

Open a terminal in your project's root folder and run:

**On macOS / Linux:**
```bash
./gradlew renameTemplate
```

**On Windows:**
```
gradlew.bat renameTemplate
```

---

## What Happens Automatically

When the task runs, it takes care of everything for you:

- **Renames your package** — all source files are moved into the correct folder structure and all `package` and `import` statements are updated throughout
- **Updates your app name** — the display name shown on the device is updated to your `newProjectName`
- **Updates the Application ID** — your app's unique identifier in the build files is set to your `newPackage`
- **Updates theme references** — your new theme name replaces the template theme throughout the codebase
- **Renames the Application class** — the main application class file and all references to it are updated to your chosen name
- **Removes unwanted dependencies** — any features you set to `false` are cleanly stripped out of all relevant files
- **Cleans up setup files** — the setup configuration file itself and related workflow files are deleted, so they don't clutter your project
- **Formats your code** — Kotlin formatting is automatically applied to the updated files
- **Stages your changes** — a `git add` is run automatically so all renamed files are ready for you to commit

---

## Step 5: Verify the Rename Worked

After the task completes, build your project to confirm everything is working:

**In Android Studio:** Click **Build → Make Project** (or press `Ctrl+F9` / `Cmd+F9`)

**From the command line:**
```bash
./gradlew assembleDebug
```

A successful build means the rename completed correctly. If there are any errors, double-check that your `newPackage` value followed the correct format (e.g., `com.yourcompany.yourapp` — lowercase letters and dots only, no spaces or special characters).

---

## Step 6: Commit Your Changes

Since the task already staged all the changed files with `git add`, you can commit immediately:

```bash
git commit -m "Rename template to [Your Project Name]"
git push
```

Your project is now fully set up with your own identity and is ready for development. The setup file has been removed, so you won't see the `renameTemplate` task again — your project is clean and ready to build on.

---

## Quick Reference Summary

| Step | Action |
|------|--------|
| 1 | Open `buildscripts/setup.gradle` |
| 2 | Fill in `newPackage`, `newProjectName`, `newMaterialThemeName`, `newApplicationClassName` |
| 3 | Set feature flags (`useHiltDependencies`, etc.) to `true` or `false` |
| 4 | Run the `renameTemplate` Gradle task |
| 5 | Build the project to verify success |
| 6 | Commit and push your changes |