# Understanding the Tooling Philosophy Behind AndroidAppTemplate

## What This Template Is — and Isn't

AndroidAppTemplate is built around a clear guiding principle: **be opinionated about tooling, not about code**.

This means the template deliberately avoids making decisions for you about how to structure your app, which architectural patterns to follow, how to organize your packages, or which third-party libraries to use in your product. Those choices belong to you and your team.

What the template *does* decide for you is the quality infrastructure surrounding your code — the automated safety net that catches problems before they become expensive. Every tool included exists to answer one question: *"How do we make sure everyone on the team ships consistent, high-quality code without relying on willpower or memory?"*

---

## The Quality Pipeline: Three Layers Working Together

The tools in this template form a deliberate pipeline with three stages, each acting as a safety net for the next:

```
Write Code → Commit → Push → Pull Request
               ↓         ↓          ↓
          Format it   Analyze it  Validate it
          (automatic) (automatic)  (automated CI)
```

### Layer 1 — Format on Commit (Local, Automatic)
When you commit code, a **pre-commit hook** automatically runs the Kotlin formatter (Ktlint) over any files you've changed. You don't have to think about it. Indentation, whitespace, import ordering — it's all handled silently in the background. You commit, it formats.

### Layer 2 — Analyze Before Push (Local, Automatic)
When you push code to the remote repository, a **pre-push hook** runs static analysis (Detekt) across the codebase. If any code smells are detected — overly complex methods, magic numbers, long parameter lists — you're alerted immediately on your machine, before the code ever leaves your local environment. This saves you from waiting for a CI failure minutes later.

### Layer 3 — Validate on Every Pull Request (Remote, Automated)
Once code reaches GitHub, **GitHub Actions** take over. These automated workflows compile the project, run unit tests, and check lint rules on every push. UI tests run separately on pull requests only (since they're resource-intensive). Nothing merges without passing these gates.

---

## The Role of Each Tool Category

### Formatting — Ktlint
**What it solves:** Debates about code style waste team energy. Ktlint enforces a single formatting standard automatically, so no one argues about spaces vs. tabs or import ordering ever again. Every team member's code looks the same.

**When it runs:** Automatically at commit time via the pre-commit hook.

### Static Analysis — Detekt
**What it solves:** Some code problems aren't formatting issues — they're structural red flags. Detekt finds things like overly complex logic, suspiciously long functions, and other patterns that make code harder to maintain. It's configurable, so your team can tune the rules to match your standards.

**When it runs:** Automatically before every push via the pre-push hook, and again in CI.

### Dependency Management — Gradle Versions Plugin
**What it solves:** Dependencies go out of date silently. The Gradle Versions Plugin gives your team an easy way to check whether any library in the project has a newer version available, keeping security and compatibility risks visible.

**When it runs:** On demand, whenever you want to audit dependency freshness.

### Continuous Integration — GitHub Actions
**What it solves:** Local hooks are only as reliable as the developer's machine and setup. GitHub Actions provides a neutral, consistent environment that validates every push and pull request, regardless of whose laptop the code came from. It's the authoritative final check.

**Two workflows are included:**
- **Android Build** — Runs on every push: compiles the app, runs unit tests, checks lint.
- **Android UI Tests** — Runs on pull requests only: validates UI behavior when code is ready to merge.

### Runtime Diagnostics — LeakCanary
**What it solves:** Memory leaks don't show up in static analysis — they only appear at runtime. LeakCanary monitors the running app during development and alerts you the moment a memory leak is detected, before it reaches production.

**When it runs:** Automatically during development builds on a device or emulator.

---

## Git Hooks and GitHub Actions: Complementary, Not Redundant

A natural question is: *"If GitHub Actions catches problems, why also have local hooks?"*

They serve different purposes and protect different moments:

| | Git Hooks | GitHub Actions |
|---|---|---|
| **Where it runs** | Your local machine | GitHub's servers |
| **When it runs** | Before commit / before push | After code is pushed |
| **Feedback speed** | Instant (seconds) | Minutes later |
| **Who it protects** | The individual developer | The shared repository |
| **Can be bypassed?** | Yes (by skipping hook install) | No (always runs) |

Git hooks are fast, local feedback — a first line of defense that helps *you* catch problems before they leave your machine. GitHub Actions are the authoritative, unchallengeable enforcement layer that protects the shared codebase regardless of local environment differences. Together, they create defense in depth: most problems are caught early and cheaply, and anything that slips through is caught before it can merge.

---

## The Documentation Folder: Living Team Knowledge

The template ships with a `documentation/` folder containing explanations of every included tool. This folder is intentionally written to **stay in your real project**.

The idea is simple: when a new team member joins, they shouldn't have to reverse-engineer why Detekt is configured a certain way, or what the git hooks are doing. The documentation folder gives them readable, plain-language answers. As your team customizes the template — adjusting Detekt rules, adding new workflows, removing tools you don't need — the expectation is that you update these docs to reflect your real project's decisions.

Think of it as the team's shared memory for tooling decisions: *why we chose this*, *what it does*, *how to use it*.

---

## Summary: What You're Inheriting

When you use this template, you're inheriting a complete, integrated quality pipeline designed so that good practices happen automatically rather than being enforced through discipline alone:

| Tool | Purpose | Enforcement Point |
|---|---|---|
| **Ktlint** | Code formatting | Commit (automatic) |
| **Detekt** | Code smell detection | Push (automatic) |
| **Git Hooks** | Local automation bridge | Your machine |
| **GitHub Actions** | CI validation | Pull Request / Push |
| **Gradle Versions Plugin** | Dependency freshness | On demand |
| **LeakCanary** | Memory leak detection | Runtime (dev builds) |
| **Documentation folder** | Team knowledge base | Ongoing / living |

None of these tools tell you *how* to build your app. They only ensure that however you build it, the code stays clean, consistent, and continuously validated — from the moment you type a keystroke to the moment it merges into your main branch.