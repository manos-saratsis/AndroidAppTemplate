# How to Use Git Hooks for Pre-Commit Checks

Git hooks are automatic checkpoints that run behind the scenes whenever you save (commit) or share (push) your code. This project comes with pre-configured hooks that catch problems early — before they ever leave your machine — so you spend less time fixing issues flagged by automated systems later.

---

## What Git Hooks Do for You

This template includes two types of automatic checks:

| When It Runs | What It Checks | Why It Helps |
|---|---|---|
| Every time you save (commit) code | Automatically formats your Kotlin files | You never have to manually worry about code style |
| Every time you share (push) code | Runs a full code quality scan | Catches code problems before your teammates or automated systems see them |

These hooks work quietly in the background. Most of the time, you simply work as normal and the hooks handle quality control for you.

---

## The Two Hooks Explained

### Pre-Commit Hook — Automatic Formatting

Every time you commit (save a snapshot of) your code, this hook automatically applies Ktlint formatting to any Kotlin files you changed. You do not need to manually format anything — just commit your work and the hook takes care of it.

> **In plain terms:** Think of it like spell-check that runs automatically when you save a document. Your code gets tidied up without you lifting a finger.

### Pre-Push Hook — Code Quality Scan

Every time you push (share) your code to the remote repository, this hook runs a static analysis check. Static analysis looks for common code problems, bad patterns, and potential bugs — the kinds of things that would otherwise only be caught when the project's automated build system runs (which can take much longer).

> **In plain terms:** It's like having a reviewer glance over your work before you share it with the team, catching obvious issues right away.

---

## Hook Scripts Included

The hook scripts live in the **git-hooks** folder at the root of the project. There are separate versions for macOS and Windows:

| Script | Platform | Purpose |
|---|---|---|
| `pre-commit-macos.sh` | macOS | Runs Ktlint formatting on commit |
| `pre-commit-windows.sh` | Windows | Runs Ktlint formatting on commit |
| `pre-push-macos.sh` | macOS | Runs static analysis before push |
| `pre-push-windows.sh` | Windows | Runs static analysis before push |

The correct script for your operating system is automatically selected during installation.

---

## Activating the Hooks

The hooks are **not active automatically** just by cloning the project — they need to be installed once. You have two options:

### Option 1 — Automatic (Recommended)

Simply run a **Clean** build in Android Studio (go to the **Build** menu and select **Clean Project**). The hooks install themselves as part of this process. No extra steps needed.

### Option 2 — Manual Installation

Open a terminal in the project folder and run the following commands one after the other:

```
./gradlew copyGitHooks
./gradlew installGitHooks
```

Once installed, the hooks remain active for your local copy of the project. Any teammate who clones the project also needs to install the hooks on their own machine using either method above.

---

## Bypassing a Hook When Necessary

Occasionally you may need to commit or push without running the hooks — for example, when saving an unfinished work-in-progress, or when the hook is blocking an urgent fix. You can skip hooks for a single operation by adding `--no-verify` to your Git command:

**Skip hooks on a commit:**
```
git commit --no-verify -m "your commit message"
```

**Skip hooks on a push:**
```
git push --no-verify
```

> ⚠️ **Use sparingly.** Bypassing hooks means code quality checks are skipped entirely for that operation. The same checks will still run in the project's automated build pipeline — so skipping locally only delays the feedback, it does not remove it. Reserve `--no-verify` for genuine emergencies or temporary work-in-progress saves.

---

## Adding or Modifying Hooks

To adjust what the hooks do for your project:

1. Navigate to the **git-hooks** folder in the project root.
2. Open the relevant script file for your platform (e.g., `pre-commit-macos.sh` for macOS commit behaviour).
3. Edit the script to add, remove, or change the commands that run.
4. Reinstall the hooks by running a **Clean Project** in Android Studio, or by running `./gradlew copyGitHooks` followed by `./gradlew installGitHooks` in the terminal.

> **Tip:** If you add a new hook, create matching versions for both macOS and Windows (following the existing naming pattern) so all team members on different platforms benefit from the same checks.

---

## Quick Reference

| Goal | What to Do |
|---|---|
| Install hooks for the first time | Run a Clean build in Android Studio, or run the two `gradlew` commands |
| Commit code normally | Just commit — formatting runs automatically |
| Push code normally | Just push — static analysis runs automatically |
| Skip checks for one operation | Add `--no-verify` to your `git commit` or `git push` command |
| Change what a hook does | Edit the relevant script in the **git-hooks** folder, then reinstall |