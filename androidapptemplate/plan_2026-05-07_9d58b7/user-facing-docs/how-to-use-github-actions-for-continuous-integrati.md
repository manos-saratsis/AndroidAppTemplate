# How to Use GitHub Actions for Continuous Integration

GitHub Actions automatically checks your code every time you push changes or open a pull request — no manual steps needed. This means your team always gets an early warning if something breaks, before it reaches your main codebase.

---

## What Is Continuous Integration (CI)?

Continuous Integration (CI) is a practice where every code change is automatically verified by running a series of checks — such as building the app, running tests, and scanning for code quality issues. The workflows in this template handle all of that for you automatically.

---

## The Workflows Included in This Template

This template includes **six automated workflows**, each serving a specific purpose:

| Workflow | When It Runs | What It Does |
|---|---|---|
| **Android Build** | Every time code is pushed | Compiles the app, runs unit tests, and checks code quality (lint) |
| **Android UI Tests** | When a pull request is opened | Runs slower, user-interface-level tests to verify the app behaves correctly on screen |
| **Danger Checks** | On pull requests | Performs additional automated code review checks |
| **Install Git Hooks (macOS)** | On demand | Sets up local development hooks for macOS contributors |
| **Install Git Hooks (Windows)** | On demand | Sets up local development hooks for Windows contributors |
| **Template Change Test** | On template updates | Validates that the template itself still works correctly after modifications |

---

## Workflow Details

### ✅ Android Build
This is the primary safety net for your project. Every time anyone pushes code — to any branch — this workflow automatically:
1. **Compiles the app** to confirm the code is free of build errors
2. **Runs unit tests** to catch logic errors and regressions
3. **Runs lint checks** to flag code style issues and potential bugs

Because this runs on every push, your team gets instant feedback after every change.

### 📱 Android UI Tests
UI tests simulate how a real user interacts with the app — tapping buttons, navigating screens, and verifying what appears on the display. These tests are thorough but take significantly more time and computing resources, so they only run when a **pull request is opened**. This way, the slower checks happen at exactly the right moment: when the team is ready to merge changes into the main branch.

### 🔍 Danger Checks
This workflow runs automatically on pull requests and performs additional automated review tasks, such as checking that pull requests meet your team's standards (e.g., size limits, description requirements). It acts as a smart assistant reviewer alongside your human reviewers.

### 🪝 Git Hooks (macOS & Windows)
These two workflows help new contributors get their local environment set up correctly on either macOS or Windows. They install automated checks that run on a developer's machine before code is even committed.

### 🏗️ Template Change Test
This workflow is specific to the template itself. It verifies that the template's setup and rename process works correctly. **Once you have finished setting up your project from this template, you should delete this workflow** — it is not needed for ongoing development of your own app.

---

## Viewing Workflow Results

1. Go to your repository on GitHub
2. Click the **Actions** tab at the top of the page
3. You will see a list of all recent workflow runs, each showing:
   - The name of the workflow
   - Which branch or pull request triggered it
   - A **green checkmark ✅** if all checks passed
   - A **red X ❌** if something failed
4. Click any workflow run to see a detailed breakdown of each step, including logs that show exactly what went wrong

On a pull request, the checks also appear directly at the bottom of the pull request page, so reviewers can see at a glance whether everything is passing before approving.

---

## Preventing Merges When CI Fails (Required Status Checks)

You can configure GitHub to **block pull requests from being merged** if any CI check is failing. This is a highly recommended safeguard for any team.

**To set up required status checks:**

1. Navigate to your repository on GitHub
2. Go to **Settings** → **Branches**
3. Under **Branch protection rules**, click **Add rule**
4. In the **Branch name pattern** field, enter the name of your main branch (e.g., `main` or `development`)
5. Check the box **Require status checks to pass before merging**
6. In the search box that appears, type and select the checks you want to require, such as:
   - `Android Build`
   - `Android UI Tests`
   - `Danger Checks`
7. Click **Save changes**

From this point on, GitHub will prevent anyone from merging a pull request until all selected checks show a green pass.

---

## Customizing Workflows for Your Project

You can tailor any workflow to fit your team's needs. The workflow files live in the `.github/workflows/` folder of your repository and can be edited directly on GitHub or in any text editor.

### Changing Which Branches Trigger a Workflow
Each workflow file contains a section that defines when it runs. You can change the branch names listed there to match your project's branching strategy. For example, if your team uses `main` instead of `development` as the primary branch, update the trigger branch accordingly.

### Adding Secret Environment Variables
If your workflows need access to sensitive information — such as API keys, signing certificates, or service credentials — you should store these as **GitHub Secrets** rather than writing them directly in the workflow files.

**To add a secret:**
1. Go to your repository's **Settings**
2. Navigate to **Secrets and variables** → **Actions**
3. Click **New repository secret**
4. Give it a name and paste in the value
5. Reference it in your workflow file using the `${{ secrets.YOUR_SECRET_NAME }}` format

### Adjusting When UI Tests Run
Since UI tests consume significant time and resources, you may want to further limit when they run — for example, only on pull requests targeting your main branch. This can be adjusted in the `android_ui_tests.yml` workflow file.

---

## Cleaning Up After Template Setup

The **Template Change Test** workflow (`template_change_test.yml`) exists solely to verify the template itself works correctly. It has no purpose in a real project built from this template.

**After you have completed your initial project setup, delete this workflow:**

1. Go to the `.github/workflows/` folder in your repository
2. Open the file `template_change_test.yml`
3. Delete the file and commit the change

This keeps your Actions tab clean and avoids confusion for your team.

---

## Summary: Your CI at a Glance

| Event | Checks That Run |
|---|---|
| Push to any branch | Android Build (compile, unit tests, lint) |
| Pull request opened | Android Build + Android UI Tests + Danger Checks |
| Template modifications | Template Change Test |

With these workflows in place, your team can merge code with confidence — knowing that every change has been automatically verified before it lands in your shared codebase.