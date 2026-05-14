# How to Set Up and Rename the Template

This guide walks you through customizing the Android App Template for your own project. Instead of manually finding and replacing every reference to the template name, the project includes an automated setup task that handles everything for you in one step.

---

## Overview

When you first clone this template, it contains placeholder names like `template`, `template.app.id`, and `TemplateApp` throughout the project. The setup process lets you replace all of these with your own app's name and package in one go, then cleans up the setup files so they don't appear in your final project.

---

## Step 1: Open the Setup Configuration File

Open the file located at **buildscripts/setup.gradle** in your project. Near the top, you will find a block called `renameConfig` that looks like this:

```
def renameConfig = [
    templateName                : "template",
    templateAppId               : "template.app.id",
    templateMaterialThemeName   : "TemplateTheme",
    templateApplicationClassName: "TemplateApp",
    newPackage                  : "aaa.yourname.app",
    newProjectName              : "Your Project",
    newMaterialThemeName        : "MyMaterialTheme",
    newApplicationClassName     : "MyApp",
    useHiltDependencies         : true,
    useRoomDependencies         : true,
    useRetrofitDependencies     : true,
    usePaparazziDependencies    : true,
    useRenovateDependencies     : true,
    useAndroidXR                : false,
]
```

This block contains all the settings you need to fill in before running the rename task.

---

## Step 2: Fill In Your Configuration

### Fields You Must Change

These fields control your app's identity and should be updated with your own values:

| Field | What It Controls | Example Value |
|---|---|---|
| `newPackage` | Your app's package name (used as both the namespace and application ID) | `"com.yourname.myapp"` |
| `newProjectName` | The display name of your app (shown in the launcher and app bar) | `"My Awesome App"` |
| `newMaterialThemeName` | The name of your Material Design theme | `"MyAppTheme"` |
| `newApplicationClassName` | The name of your custom Application class | `"MyApp"` |

> **Important:** Do not change the four `template*` fields at the top (such as `templateName`, `templateAppId`, etc.). These are the original placeholder values that the task uses to find and replace — editing them will break the rename process.

### Choosing Which Dependencies to Keep

The bottom section of `renameConfig` lets you include or remove optional libraries. Set each one to `true` to keep it or `false` to remove it from your project:

| Setting | What It Controls |
|---|---|
| `useHiltDependencies` | Dependency injection with Hilt |
| `useRoomDependencies` | Local database support with Room |
| `useRetrofitDependencies` | Networking with Retrofit, Moshi, and OkHttp |
| `usePaparazziDependencies` | Screenshot testing with Paparazzi |
| `useRenovateDependencies` | Automated dependency update configuration (renovate.json5) |
| `useAndroidXR` | Android XR (extended reality) support |

Setting any of these to `false` will automatically remove all related lines from the project's build files, source files, and manifest during the rename task.

---

## Step 3: Run the Rename Task

Once your configuration is filled in, run the `renameTemplate` Gradle task. You can do this in one of two ways:

### From the Command Line

Open a terminal in your project's root directory and run:

```
./gradlew renameTemplate
```

On Windows, use:

```
gradlew.bat renameTemplate
```

### From Android Studio

1. Open the **Gradle panel** on the right side of Android Studio.
2. Navigate to your project's root → **Tasks** → **Template Setup**.
3. Double-click **renameTemplate** to run it.

---

## Step 4: What Happens Automatically

When the task runs, it takes care of everything for you:

- **Package folders are renamed** — Your source code files are moved from the old `template` folder structure to a new folder structure matching your chosen package name.
- **Package and import statements are updated** — Every reference to the old package name inside your Kotlin files is replaced with your new package name.
- **Theme and Application class names are updated** — References to `TemplateTheme` and `TemplateApp` are replaced throughout the source files.
- **The Android Manifest is updated** — The app's declared package, application class name, and activity references are all corrected.
- **Build files are updated** — The `namespace` and `applicationId` in the app's build file are set to your new package name.
- **The project name is updated** — The root project name in `settings.gradle.kts` and the app name string in `strings.xml` are both changed to your chosen project name.
- **Unwanted dependencies are removed** — Any library you set to `false` is stripped from the relevant build and source files.
- **Setup files are deleted** — The `setup.gradle` file itself, along with the template test workflow files (`.github/workflows/template_change_test.yml`, `install_git_hooks_macos.yml`, and `install_git_hooks_windows.yml`), are automatically deleted so they don't appear in your project.
- **Code is formatted** — Kotlin formatting is automatically applied after the rename.
- **Files are staged for commit** — A `git add` is run on all changed files so you can immediately commit and push your renamed project.

---

## Step 5: Verify the Rename Succeeded

After the task completes:

1. **Build the project** — In Android Studio, go to **Build → Make Project** (or press Ctrl+F9 / Cmd+F9). The build should complete without errors.
2. **Run the app** — Deploy to an emulator or device. The app should launch with your new app name displayed.
3. **Check the app launcher** — The app icon's label should show your `newProjectName` value.
4. **Confirm setup files are gone** — The `buildscripts/setup.gradle` file should no longer exist in your project.

---

## Troubleshooting

### The build fails after renaming

- Double-check that you did **not** modify any of the four `template*` fields in the config block. Those values must stay as-is.
- Make sure your `newPackage` value uses only lowercase letters, numbers, and dots (e.g., `com.yourname.app`). Uppercase letters or spaces in a package name will cause build errors.
- Try running **Build → Clean Project** in Android Studio, then rebuild.

### Some references still say "template"

- Open Android Studio's **Find in Files** (Ctrl+Shift+F / Cmd+Shift+F) and search for `template`. If any references remain, they may be in files not covered by the rename task. Update those manually.

### The task fails with an error about a missing directory

- This can happen if the `buildscripts/setup.gradle` file was already deleted (e.g., the task was run before). If the task has already been run successfully, you do not need to run it again.

### A dependency you set to `false` is still present

- Clean and sync your Gradle files: in Android Studio go to **File → Sync Project with Gradle Files**, then **Build → Clean Project** and rebuild.

### The task runs but formatting fails

- The Kotlin formatting step (`app:formatKotlin`) runs after the rename. If it reports errors, try running `./gradlew app:formatKotlin` manually to see the specific formatting issues.

---

## After Setup

Once the rename is complete and your build succeeds, you are ready to start developing. The template setup files have been removed, and your project is fully configured with your chosen name, package, and dependencies. Commit the staged changes and you are good to go.