# Quick Start: Use This Template

Get your new Android project up and running in under 15 minutes by following these steps.

---

## What You'll Need

- A GitHub account
- [Android Studio](https://developer.android.com/studio) installed on your computer
- Git installed on your computer

---

## Step 1: Create Your Repository from the Template

1. Go to the [AndroidAppTemplate repository](https://github.com/manos-saratsis/AndroidAppTemplate) on GitHub.
2. Click the **"Use this template"** button in the top-right corner of the page.
3. Choose **"Create a new repository"** from the dropdown.
4. Fill in your new repository name, choose whether it should be public or private, and click **"Create repository"**.

Your new repository will appear in your GitHub account, ready to use.

---

## Step 2: Clone Your New Repository

1. On your new repository's GitHub page, click the green **"Code"** button.
2. Copy the repository URL (HTTPS or SSH).
3. Open a terminal on your computer and run:

```
git clone <your-repository-url>
```

4. Navigate into the newly cloned folder:

```
cd <your-repository-name>
```

---

## Step 3: Open the Project in Android Studio

1. Open **Android Studio**.
2. Select **"Open"** from the welcome screen (or go to **File → Open**).
3. Browse to the folder you just cloned and click **"OK"**.
4. Wait for Android Studio to finish indexing and syncing the project — this may take a minute or two.

---

## Step 4: Configure Your Project Name and Package

Before renaming, you need to tell the template what your project is called. Open the file located at:

**`buildscripts/setup.gradle`**

Find the `renameConfig` block near the top of the file. It looks like this:

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

Update **only the fields in the right column that start with `new`**, plus any feature toggles. Here is what each setting means:

| Setting | What to Enter |
|---|---|
| `newPackage` | Your app's unique package name (e.g., `com.yourcompany.myapp`) |
| `newProjectName` | The display name of your app (e.g., `My Awesome App`) |
| `newMaterialThemeName` | The name for your app's Material theme (e.g., `MyAwesomeTheme`) |
| `newApplicationClassName` | The name for your app's Application class (e.g., `MyAwesomeApp`) |

### Optional: Remove Unused Dependencies

If your project does not need certain libraries, set their value to `false` to have them automatically removed:

| Setting | What It Controls |
|---|---|
| `useHiltDependencies` | Dependency injection with Hilt (`true` keeps it, `false` removes it) |
| `useRoomDependencies` | Local database with Room (`true` keeps it, `false` removes it) |
| `useRetrofitDependencies` | Network calls with Retrofit, Moshi, and OkHttp (`true` keeps it, `false` removes it) |
| `usePaparazziDependencies` | Screenshot testing with Paparazzi (`true` keeps it, `false` removes it) |
| `useRenovateDependencies` | Automated dependency updates with Renovate (`true` keeps it, `false` removes it) |
| `useAndroidXR` | Android XR (extended reality) support (`true` keeps it, `false` removes it) |

Save the file when you are done.

---

## Step 5: Run the Rename Task

This step automatically replaces all references to the template name with your new project name and package throughout the entire project.

### Option A: From the Terminal

In your terminal, from the root of your project folder, run:

**On Mac or Linux:**
```
./gradlew renameTemplate
```

**On Windows:**
```
gradlew.bat renameTemplate
```

### Option B: From Android Studio

1. Open the **Gradle** panel on the right side of Android Studio.
2. Navigate to **Tasks → Template Setup**.
3. Double-click **renameTemplate**.

The task will rename your package, update your app name in all the right places, remove any dependencies you turned off, clean up the setup files, and automatically stage all the changes with `git add`.

---

## Step 6: Commit Your Changes and Verify the Build

Since the rename task automatically stages your files, you are ready to commit right away.

1. In your terminal, confirm everything looks correct:

```
git status
```

2. Commit all the renamed files:

```
git commit -m "Initial project setup from template"
```

3. Push your changes to GitHub:

```
git push
```

4. Back in Android Studio, click the **"Sync Project with Gradle Files"** button (the elephant icon in the toolbar) if it has not synced automatically.
5. Once synced, press the green **Run** button (▶) to build and launch the app on an emulator or connected device.

If the app launches successfully, your project is set up and ready for development. 🎉

---

## Troubleshooting

- **Build fails after renaming:** Try running **File → Invalidate Caches / Restart** in Android Studio, then sync and rebuild.
- **`renameTemplate` task not found:** Make sure you opened the root project folder in Android Studio, not a subfolder.
- **Problems with the setup process:** [Report an issue](https://github.com/AdamMc331/AndroidAppTemplate/issues) on the template's GitHub page.

---

## What's Next?

Your project comes pre-configured with several developer tools to help you maintain code quality, including automatic code formatting, static analysis, git hooks, and GitHub Actions for continuous integration. You can learn more about each tool inside the `documentation` folder of your project.