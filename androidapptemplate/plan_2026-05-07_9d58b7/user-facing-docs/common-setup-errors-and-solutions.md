# Common Setup Errors and Solutions

This guide helps you identify and fix the most common problems encountered when setting up and using the Android App Template. Each issue includes clear symptoms, the likely cause, and step-by-step resolution instructions.

---

## 1. Gradle Sync Fails After Cloning

### Symptoms
- Android Studio shows "Gradle sync failed" immediately after cloning
- Error messages appear in the Build or Sync output panel
- The project structure looks incomplete or modules are missing

### Likely Causes
- Your local Android Studio or Gradle version is incompatible with the project
- The project was cloned incompletely (e.g., interrupted download)
- A dependency listed in the version catalog cannot be fetched (no internet or proxy issues)

### How to Fix
1. **Check your internet connection.** Gradle downloads dependencies on first sync — a failed or slow connection will cause this to fail.
2. **Invalidate caches and retry.** In Android Studio, go to **File → Invalidate Caches / Restart**, then choose **Invalidate and Restart**.
3. **Re-clone the repository.** If the clone was interrupted, delete the local folder and clone again using the "Use this template" button on the repository page, then clone your new copy.
4. **Update Android Studio.** Make sure you are using a recent stable version of Android Studio, as older versions may not support the Gradle configuration used in this template.
5. **Check your proxy or firewall settings** if you are on a corporate network that blocks external package downloads.

---

## 2. The `renameTemplate` Task Fails or Produces Unexpected Results

### Symptoms
- Running the rename task shows an error like "Task not found" or "No such file or directory"
- Package names, app names, or class names were only partially replaced
- The task completes but old template references still appear in files
- An error about a missing config value appears in the output

### Likely Causes
- The `setup.gradle` file was not edited before running the task
- Required fields in the configuration block were left blank or contain invalid characters
- The task was run before a Gradle sync completed successfully
- The `setup.gradle` file was accidentally deleted before the task was run (it deletes itself after a successful run)

### How to Fix
1. **Open the setup configuration file.** Look for the `setup.gradle` file in the `buildscripts` folder of your project.
2. **Fill in all required fields.** The configuration block contains the following fields that you must update before running the task:
   - `newPackage` — your new app package name (e.g., `com.yourcompany.yourapp`)
   - `newProjectName` — the display name for your app
   - `newMaterialThemeName` — the name of your Material theme
   - `newApplicationClassName` — the name of your Application class

   > ⚠️ Do **not** leave these as their default placeholder values. The task uses these to find and replace references throughout the project.

3. **Verify your package name format.** The `newPackage` value must use dot-separated segments (e.g., `com.example.myapp`). Spaces or special characters will cause the task to fail or produce broken file paths.
4. **Run a Gradle sync first.** Before running the rename task, make sure the project syncs without errors in Android Studio.
5. **Run the task from the Terminal.** Open a terminal in your project root and run:
   ```
   ./gradlew renameTemplate
   ```
   This gives you the clearest error output if something goes wrong.
6. **If the task ran partially:** If only some files were renamed, check that the `setup.gradle` file still exists (it is deleted automatically on success). If it is gone, the task already ran — look for leftover template references manually in your manifest, build files, and string resources.
7. **Do not run the task twice.** The task deletes the `setup.gradle` file and removes itself on success. Running it a second time will fail because the setup file no longer exists.

---

## 3. Git Hooks Are Not Running After Cloning

### Symptoms
- Code is committed or pushed without any formatting or static analysis checks running
- No output appears from Ktlint or Detekt when you commit or push
- Other team members have hooks running but yours do not

### Likely Causes
- Git hooks must be explicitly installed after cloning — they are not activated automatically by Git
- A clean task has not been run yet (which triggers automatic installation)

### How to Fix
1. **Install the hooks manually** by opening a terminal in your project root and running one of the following commands:
   ```
   ./gradlew copyGitHooks
   ./gradlew installGitHooks
   ```
2. **Alternatively, run a clean build.** The hooks are set up to install automatically whenever you run the clean task:
   ```
   ./gradlew clean
   ```
3. **Verify the hooks are active.** After installation, make a small change to a Kotlin file and attempt to commit it. You should see Ktlint formatting run automatically before the commit completes.
4. **On Windows:** Git hook scripts may behave differently. If hooks still do not run after installation, check that your Git client supports shell scripts, or consult your team's setup notes.

---

## 4. Ktlint or Detekt Fails with Unexpected Errors

### Symptoms
- Running `./gradlew lintKotlin` or `./gradlew detekt` fails with errors unrelated to your code
- Error messages mention configuration files or missing rules
- The task worked before but suddenly fails after pulling new changes
- Version conflict warnings appear in the output

### Likely Causes
- The Detekt configuration file has been accidentally modified or deleted
- A version mismatch exists between the plugin and its configuration expectations
- The Kotlinter plugin (which powers Ktlint) is on a version that conflicts with your Kotlin version

### How to Fix

**For Detekt issues:**
1. Check that the Detekt configuration file exists at `config/detekt/detekt.yml` in your project root.
2. If the file was accidentally changed, restore it from version control:
   ```
   git checkout config/detekt/detekt.yml
   ```
3. To run Detekt over all modules at once (faster), use:
   ```
   ./gradlew detektAll
   ```

**For Ktlint/Kotlinter issues:**
1. Try auto-formatting first, which may resolve rule violations automatically:
   ```
   ./gradlew formatKotlin
   ```
2. Then re-run the lint check to see if remaining errors are genuine code issues:
   ```
   ./gradlew lintKotlin
   ```
3. If errors persist and appear to be configuration-related, check the `buildscripts` folder for the Ktlint/Kotlinter Gradle file and ensure no manual edits have broken the plugin setup.
4. Sync your project after any changes to build scripts, then try again.

---

## 5. GitHub Actions Workflows Are Failing

### Symptoms
- Pull requests show failing CI checks on GitHub
- Workflow logs mention "permission denied" or "insufficient permissions"
- A workflow called Danger checks fails with an authentication or comment error
- Secrets-related errors appear in the workflow logs

### Likely Causes
- The repository's workflow permissions have not been updated to allow read and write access
- Required secrets have not been added to the repository settings
- The Danger tool does not have permission to post comments on pull requests

### How to Fix

**Fix workflow permissions (required for Danger):**
1. On GitHub, navigate to your repository.
2. Click **Settings** in the top navigation bar.
3. In the left sidebar, click **Actions**, then click **General**.
4. Scroll down to the **Workflow permissions** section.
5. Select **Read and write permissions**.
6. Click **Save**.

**If a specific workflow is failing due to missing secrets:**
1. Go to **Settings → Secrets and variables → Actions**.
2. Add any secrets that the failing workflow references. Check the workflow file in the `.github/workflows` folder for the exact secret names used.

**If the `template_change_test` workflow appears after you've set up the project:**
- This workflow is automatically deleted when you run the `renameTemplate` task successfully. If it still appears, re-run the rename task or manually delete the workflow file.

---

## 6. LeakCanary Does Not Appear in Debug Builds

### Symptoms
- The LeakCanary notification or launcher icon does not appear when running a debug build
- No memory leak reports are shown even when leaks are expected
- The app runs normally but LeakCanary seems completely absent

### Likely Causes
- LeakCanary is a debug-only dependency and will not appear in release builds — this is expected behavior
- The dependency may not have been resolved correctly after a Gradle sync issue
- LeakCanary was removed during the `keepOrRemoveDependencies` step if the configuration was set to exclude it

### How to Fix
1. **Confirm you are running a debug build.** LeakCanary only activates in debug mode. If you are testing a release or staging build, LeakCanary will not appear — this is by design.
2. **Force a full Gradle sync.** In Android Studio, go to **File → Sync Project with Gradle Files** and wait for the sync to complete successfully.
3. **Clean and rebuild.** Run:
   ```
   ./gradlew clean
   ```
   Then rebuild and reinstall the app on your device or emulator.
4. **Reinstall the app on your device.** Sometimes a fresh install is needed after dependency changes. Uninstall the app from your device/emulator and deploy it again from Android Studio.
5. **Check that LeakCanary was not removed during setup.** If you ran the `renameTemplate` task with certain options set to `false`, some dependencies may have been stripped. Review your `app/build.gradle.kts` file to confirm `leakcanary-android` is still listed as a `debugImplementation` dependency.

---

## Still Stuck?

If none of the steps above resolve your issue:

1. Watch the official [video walkthrough on YouTube](https://youtu.be/E0iMUWJn76E) for a guided overview of how the template is set up.
2. Search the [GitHub Issues page](https://github.com/AdamMc331/AndroidAppTemplate/issues) to see if your problem has already been reported and resolved.
3. If your issue is new, open a [new GitHub Issue](https://github.com/AdamMc331/AndroidAppTemplate/issues/new) with a description of what you tried and the error output you received.