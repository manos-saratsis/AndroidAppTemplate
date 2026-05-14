# Key Concepts: Tooling vs. Architecture

## The Core Philosophy

This template is built on a single, deliberate idea: **your project setup should not decide how you write your app.**

Many starter projects come bundled with architectural opinions — a specific way to structure screens, a mandated pattern for managing state, or a required library for connecting components. This template deliberately avoids all of that. Instead, it focuses exclusively on the *surrounding* concerns that every professional Android project needs, regardless of how the app itself is built.

Think of it this way: the template handles the workshop, not the craft.

---

## What "Developer Tooling" Means

Developer tooling refers to the automated systems and configurations that support your team's workflow — things that run quietly in the background, enforce consistency, and catch problems early. This template includes four categories of tooling:

### 1. Code Formatting & Style Enforcement
Two tools work together to keep your codebase consistent:

- **Ktlint** automatically formats your Kotlin code — handling spacing, indentation, imports, and other stylistic details. This eliminates the unproductive debates teams often have about whitespace and formatting preferences.
- **Detekt** scans your code for quality issues known as "code smells" — things like overly complicated logic, unusually long functions, and hardcoded magic numbers. It catches these problems before they become habits.

### 2. Git Hooks (Automatic Quality Gates)
Git hooks are checks that run automatically at key moments in your Git workflow — before you commit or push code. You don't have to remember to run them; they just happen.

- **Before every commit:** Your Kotlin files are automatically formatted by Ktlint. You write the code; the tool handles the presentation.
- **Before every push:** Detekt scans for code smells. If something needs attention, you're told immediately — not hours later after a failed build.

### 3. Continuous Integration (GitHub Actions)
Every time code is pushed or a pull request is opened, automated workflows validate the project. These include compiling the app, running unit tests, and checking code formatting. Slower tests (like UI tests) are reserved for pull requests only, keeping day-to-day pushes fast.

### 4. Dependency Management
Two tools handle library management:

- A **version catalog** keeps all dependency versions in one place, making updates easy to track across the whole project.
- The **Gradle Versions Plugin** checks whether any of your libraries have newer versions available, so you never unknowingly fall behind.

---

## How the Tools Work Together

Here is the typical flow a developer experiences:

1. **Write code** in your editor of choice.
2. **Commit your changes** — Ktlint automatically formats any modified Kotlin files. No manual step needed.
3. **Push to the remote repository** — Detekt checks for code quality issues before the push completes. Problems surface immediately.
4. **Open a pull request** — GitHub Actions runs the full suite: compilation, unit tests, lint checks, and UI tests. A pull request template guides you to write a clear description.
5. **Stay current** — Run the dependency updater periodically to see if your libraries have newer stable versions.

Each tool reinforces the next. Local hooks catch issues before they reach CI. CI catches anything that slipped through. The result is a consistent, reliable baseline for the whole team.

---

## What Is Intentionally Left Out — and Why

The template makes no decisions in the following areas:

| What's Excluded | Why It's Excluded |
|---|---|
| App architecture (MVVM, MVI, MVP, etc.) | Different apps and teams have different needs. The template has no opinion. |
| Dependency injection framework (Hilt, Koin, Dagger, manual DI) | Hilt dependencies are included as *optional* — they can be removed during setup if you prefer something else or nothing at all. |
| Networking libraries | Your API layer, its shape, and how it's abstracted is your decision. |
| UI framework approach | Whether you use Jetpack Compose, traditional Views, or a mix is entirely up to you. |
| Package structure | How you organize your code by feature, layer, or any other scheme is yours to define. |
| State management | How data flows through your screens is an architectural concern, not a tooling one. |

This is a deliberate design choice. Prescribing architecture in a template creates friction when the prescribed pattern doesn't fit the project. By leaving these decisions open, the template stays useful across a wide variety of apps and team preferences.

---

## The Documentation Folder as Living Team Reference

The template includes a `documentation` folder containing plain-language explanations of each included tool — why it was chosen, how it works, and how to use it. These files are written so that you can **keep them in your real project** after you start building.

This means a new team member joining months later can open the documentation folder and understand:
- Why Ktlint formats code the way it does
- What Detekt is looking for
- How the CI workflows are structured
- How to check for dependency updates

The documentation folder is not a one-time setup guide — it is intended to grow into your team's shared knowledge base as your project evolves.

---

## Summary: Where the Template's Opinions Start and Stop

| The Template Decides | You Decide |
|---|---|
| How code is formatted | How your app is structured |
| When quality checks run | Which architectural pattern to follow |
| How dependencies are versioned | Which third-party libraries to use |
| What CI workflows run and when | How to organize your packages |
| What a pull request description should include | How data flows through your app |

The template gives your project a professional, automated foundation. Everything from the first line of feature code onward is entirely in your hands.