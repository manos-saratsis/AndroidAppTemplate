# Common Errors and Solutions

This guide covers the most frequent issues you may encounter when setting up and using the Android App Template, along with clear steps to resolve each one.

---

## 1. `renameTemplate` Task Fails

### Issue: Invalid Package Name Format

The most common cause of `renameTemplate` failing is setting a `newPackage` value that doesn't follow Android's required package naming rules.

**What goes wrong:** The setup uses your `newPackage` value to rename directories, replace text in files, and update your app's namespace and application ID. If the value is malformed, these replacements will produce broken output or fail entirely.

**Rules your package name must follow:**
- Use only **lowercase letters**, **numbers**, and **dots** (`.`)
- Must have **at least two segments** separated by dots (e.g., `com.mycompany.myapp`)
- Each segment must **start with a letter**, not a number
- **No hyphens, underscores, spaces, or special characters** (e.g., `@`, `#`, `$`)

**✅ Valid examples:**
```
com.yourname.app
mycompany.android.myproject
```

**❌ Invalid examples:**
```
MyCompany.App       ← uppercase letters not allowed
my-company.app      ← hyphens not allowed
123app.company      ← starts with a number
yourapp             ← needs at least two dot-separated segments
```

**Fix:** Open the `buildscripts/setup.gradle` file and update the `newPackage` field, then re-run the task:
```
./gradlew renameTemplate
```

---

### Issue: Task Partially Ran Before Failing

If `renameTemplate` failed partway through a previous run, some files may have already been modified while others remain unchanged, leaving the project in a broken state.

**Fix:** The safest approach is to reset your repository to its original state before retrying:
```
git checkout -- .
git clean -fd
```
Then correct your `setup.gradle` configuration and run `./gradlew renameTemplate` again.

---

### Issue: `setup.gradle` File Is Missing

If you run `renameTemplate` successfully, the setup file deletes itself as part of the cleanup. Running the task a second time will fail because the file no longer exists.

**Fix:** You only need to run `renameTemplate` once. If you need to redo the setup, restore the file from your Git history or clone a fresh copy of the template.

---

## 2. Git Hooks Not Running

### Issue: Hooks Were Never Installed

Git hooks do not activate automatically when you clone the repository — they must be installed first.

**Fix:** Run one of the following commands to install the hooks:
```
./gradlew copyGitHooks
./gradlew installGitHooks
```
Alternatively, running a `clean` task will also install the hooks automatically:
```
./gradlew clean
```

---

### Issue: Permission Denied on macOS or Linux

On Unix-based systems (macOS, Linux), the hook scripts may not have executable permissions, causing them to be silently skipped or to produce a "Permission denied" error.

**Fix:** Grant executable permissions to the hook files manually:
```
chmod +x .git/hooks/pre-commit
chmod +x .git/hooks/pre-push
```

---

### Issue: Hooks Run but Nothing Happens

If you are on **Windows**, the default macOS hook scripts may be installed but won't execute correctly because they are shell scripts designed for Unix environments.

**Fix:** The template includes a separate Windows-compatible workflow. Re-install hooks using the Windows-specific Gradle task, or ensure your Git environment (e.g., Git for Windows / Git Bash) supports shell script execution.

---

## 3. Ktlint or Detekt Errors Blocking Commits

### Issue: Pre-Commit Hook Fails Due to Ktlint

The pre-commit hook automatically runs Ktlint formatting on any modified Kotlin files. If it reports errors, your commit will be blocked.

**Fix — Auto-format your code:** In most cases, Ktlint can fix formatting issues automatically. Run:
```
./gradlew formatKotlin
```
Then stage the newly formatted files and commit again.

**Fix — Check what's wrong first:** If you want to see the specific formatting violations before fixing:
```
./gradlew lintKotlin
```
This will list every file and line that doesn't meet formatting standards.

---

### Issue: Pre-Push Hook Fails Due to Detekt

The pre-push hook runs Detekt static analysis before any code is pushed. Detekt catches "code smells" such as overly long methods, magic numbers, or complex conditionals.

**Fix — Identify the failing rule:** Run Detekt manually to see the full report:
```
./gradlew detekt
```
The output will show the file, line number, and the specific rule that was violated.

**Fix — Resolve the issue:** Refactor your code to address the flagged problem. Common examples:
- Extract a long method into smaller ones
- Replace a magic number with a named constant
- Simplify a complex conditional expression

**Fix — Suppress a rule (use sparingly):** If you have a legitimate reason to bypass a specific Detekt rule, you can suppress it inline or adjust the configuration thresholds in the `config/detekt/detekt.yml` file. Only suppress rules intentionally and with team agreement.

---

### Issue: Formatting and Analysis Pass Locally but Fail in CI

This usually means the auto-formatter changed files that weren't committed before pushing.

**Fix:** After running `./gradlew formatKotlin`, check for any modified files with `git status`, stage them (`git add .`), and include them in your commit before pushing.

---

## 4. GitHub Actions Workflow Failures

### Issue: Danger Checks Fail with a Permissions Error

The Danger workflow posts review comments on pull requests. If it lacks permission to do so, the workflow will fail.

**Fix:** In your repository, navigate to **Settings → Actions → General**, scroll down to **Workflow Permissions**, and set it to **Read and write permissions**. Save the change and re-run the failed workflow.

---

### Issue: Build Workflow Fails — Reviewing Logs

When a workflow fails on GitHub Actions, the error details are in the workflow run logs.

**How to read them:**
1. Go to the **Actions** tab in your GitHub repository
2. Click on the failed workflow run
3. Click on the failing job (e.g., `build`, `ui-tests`, `danger`)
4. Expand the step that shows a red ✗ icon to see the full error output

**Common root causes:**

| Symptom in Logs | Likely Cause | Fix |
|---|---|---|
| `Permission denied` on Danger step | Missing write permissions | Enable read/write in Settings → Actions → General |
| `Build failed` with unresolved references | Rename task left broken references | See Section 5 below |
| Gradle build is unexpectedly slow | Gradle cache not restored | Ensure caching is configured in the workflow YAML; re-running usually restores it |
| Test failures not seen locally | Environment differences | Check the Android API level used in the workflow matches your local setup |

---

### Issue: Workflow Files Still Present After Running `renameTemplate`

The `renameTemplate` task deletes several setup-only workflow files (`template_change_test.yml`, `install_git_hooks_macos.yml`, `install_git_hooks_windows.yml`) as part of cleanup. If these files are still present, the task may not have completed successfully.

**Fix:** Confirm the task ran to completion without errors, then check whether the files were deleted. If not, re-run `./gradlew renameTemplate` after fixing any configuration issues.

---

## 5. Build Failures After Renaming

### Issue: The App Won't Build After Running `renameTemplate`

If the rename task succeeded but the app now fails to compile, some references may not have been updated correctly.

**How to verify all references were updated — check these locations:**

| Location | What to Check |
|---|---|
| `app/build.gradle.kts` | `namespace` and `applicationId` should match your new package name |
| `app/src/main/AndroidManifest.xml` | Activity and Application class references should use your new package and class names |
| `settings.gradle.kts` | `rootProject.name` should reflect your new project name |
| `app/src/main/res/values/strings.xml` | `app_name` string should show your new project name |
| All Kotlin source files | `package` and `import` statements should reference your new package, not `template` |

**Fix — Search for leftover template references:**

Use your IDE's global search (Find in Files) to search for the old template values:
- `template.app.id`
- `package template`
- `import template`
- `TemplateApp`
- `TemplateTheme`

Replace any remaining occurrences with your new values.

**Fix — Re-run formatting after rename:**

The `renameTemplate` task automatically runs `formatKotlin` at the end. If that step was skipped or failed, run it manually:
```
./gradlew formatKotlin
```

---

## Still Stuck?

If you've worked through this guide and are still experiencing an issue, you can report it by opening a new Issue in the [AndroidAppTemplate GitHub repository](https://github.com/AdamMc331/AndroidAppTemplate/issues/new). Include the full error message from your terminal or GitHub Actions logs to help diagnose the problem quickly.