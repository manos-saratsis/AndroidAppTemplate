---

## What Is CI and Why Does It Matter?

CI (Continuous Integration) means every change to your codebase is automatically verified before it gets merged. When you push code or open a pull request, GitHub Actions runs a series of checks in the background. If any check fails, you'll see a clear warning before merging — catching bugs, broken builds, or code quality issues early.

---

## Your Pre-Configured Workflows

This template includes four automated workflows, each serving a specific purpose:

### 1. Android Build
**Runs on:** Every push to the `development` branch, and on every pull request.

This is the core workflow. Every time you push code, it automatically:
- **Compiles the project** — ensures the code builds without errors.
- **Runs unit tests** — verifies your logic works as expected.
- **Runs lint and static analysis checks** — catches code style issues and potential bugs using Detekt, ktlint, and Android Lint.
- **Checks dependency sort order** — ensures project dependencies are listed in a consistent order.

If any of these steps fail, the workflow stops and reports which step failed.

> **Smart cancellation:** If you push multiple times in quick succession on the same pull request, GitHub Actions automatically cancels the older in-progress run and starts fresh with your latest push. This saves time and resources.

---

### 2. Android UI Tests
**Runs on:** Pull requests only (not on every push).

UI tests are slower and more resource-intensive than unit tests, so they only run when you're preparing to merge. This workflow:
- Launches an Android emulator (API level 29).
- Runs all connected/instrumented UI tests against the emulator.

Because of this separation, your regular pushes get fast feedback from the **Android Build** workflow, while the heavier UI verification happens just before a merge.

---

### 3. Danger Checks
**Runs on:** Pull requests only.

This workflow provides automated pull request review checks. It:
- Scans for available dependency updates in your project.
- Runs [Danger](https://danger.systems/kotlin/), a tool that can automatically comment on your pull request with useful feedback (e.g., reminders, warnings, or policy checks).

Danger uses a secure GitHub token automatically provided by GitHub Actions — no manual setup needed.

---

### 4. Install Git Hooks (macOS & Windows)
Two separate workflows handle setting up local Git hooks for macOS and Windows contributors. These ensure developers on your team have consistent pre-commit checks installed on their local machines.

---

## When Each Workflow Runs — At a Glance

| Workflow | On Every Push | On Pull Request |
|---|---|---|
| Android Build | ✅ (to `development`) | ✅ |
| Android UI Tests | ❌ | ✅ |
| Danger Checks | ❌ | ✅ |
| Install Git Hooks | ❌ | ✅ |

---

## Viewing Workflow Results

1. **On a Pull Request:** Scroll to the bottom of any open pull request on GitHub. You'll see a "Checks" section listing each workflow and whether it passed (✅), failed (❌), or is still running (🔄).

2. **In the Actions Tab:** Go to your repository on GitHub and click the **Actions** tab. You'll see a full history of every workflow run, with timestamps and results.

3. **Clicking into a failed run:** Select any failed run, then click on the failing job name. Expand the failing step to see the exact error message and log output. Common failure points are:
   - **Build Project** — a compilation error in your code.
   - **Run Tests** — a failing unit test.
   - **Lint Checks** — a code style or static analysis violation.
   - **Dependency Sort Checks** — dependencies listed out of order in your build files.

---

## The Pull Request Template

Every time you open a new pull request, GitHub automatically pre-fills the description with a structured template. It includes three sections:

- **Summary** — Describe what your pull request does and why.
- **How It Was Tested** — Explain how you verified your changes work (e.g., ran specific tests, tested manually on a device).
- **Screenshot/Gif** — Attach a visual if your change affects anything the user can see on screen. Screenshots are placed inside a collapsible section to keep the PR description clean.

Filling out this template consistently helps your team understand changes at a glance and makes code review faster.

---

## Adding New Steps to an Existing Workflow

To add a new check to, for example, the Android Build workflow:

1. Open the `android_build.yml` workflow file in your repository.
2. Add a new step under the `steps:` section, following the same format as the existing steps:
   ```yaml
   - name: Your New Step
     run: ./gradlew yourGradleTask
   ```
3. Commit and push. The new step will run automatically on the next trigger.

Each step runs sequentially. If a step fails, subsequent steps are skipped and the workflow is marked as failed.

---

## Creating a Brand New Workflow

To add an entirely new automated workflow:

1. Create a new `.yml` file in the `.github/workflows/` folder of your repository.
2. Define when it should trigger (e.g., on push, on pull request, or on a schedule).
3. List the steps it should run.

A minimal example that runs on every pull request:
```yaml
name: My New Workflow

on: pull_request

jobs:
  my-job:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Run My Check
        run: ./gradlew myTask
```

GitHub will automatically pick up and run any `.yml` file placed in the `.github/workflows/` folder.

---

## Tips for Working with CI

- **Fix lint failures locally first.** Run the lint and static analysis checks on your own machine before pushing to avoid waiting for the CI cycle.
- **Don't ignore red checks.** A failing Android Build workflow means your branch has an issue that needs to be resolved before merging.
- **UI test failures are real.** The Android UI Tests workflow runs on a real emulator — failures there reflect actual broken behavior on a device.
- **Keep the PR template filled out.** The Danger workflow can be configured to enforce PR description completeness, so a blank template may trigger a warning on your pull request.