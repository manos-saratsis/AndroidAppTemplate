# How to Use Static Analysis (Ktlint and Detekt)

This project includes two static analysis tools that work together to keep the codebase clean, consistent, and easy to maintain. Running these tools regularly — and especially before submitting code for review — helps catch problems early and keeps the entire team aligned on code quality standards.

---

## Overview: Two Tools, Two Jobs

| Tool | What It Does |
|------|-------------|
| **Ktlint** | Checks and automatically fixes code *formatting* — things like whitespace, indentation, and import ordering. No more debates about style. |
| **Detekt** | Checks for *code smells* — deeper quality issues like magic numbers, overly long methods, complicated conditions, or functions with too many parameters. |

Both tools are complementary: Ktlint keeps the code looking consistent, while Detekt keeps the logic clean and maintainable.

---

## Running Ktlint

Ktlint is integrated via the [Kotlinter](https://github.com/jeremymailen/kotlinter-gradle) Gradle plugin, which provides two tasks:

### Check formatting

```
./gradlew lintKotlin
```

Use this to **verify** that all code is correctly formatted. This is the task that runs in CI — if anything is not formatted properly, the build will fail and report which files are affected.

### Auto-fix formatting

```
./gradlew formatKotlin
```

Use this to **automatically reformat** your entire codebase. Run this whenever you want Ktlint to apply all formatting fixes for you, so you don't have to do it manually. It is safe to run at any time.

> **Tip:** Run `formatKotlin` before committing your work to make sure `lintKotlin` passes in CI.

---

## Running Detekt

Detekt scans for code quality issues and produces a report of anything it finds.

### Run over all modules (one at a time)

```
./gradlew detekt
```

Runs Detekt across every module in the project, processing one module at a time. Good for local development when you want a straightforward output.

### Run over all modules (in parallel)

```
./gradlew detektAll
```

Runs Detekt across all modules simultaneously, which is faster. Ideal for use in CI pipelines or when you want quicker feedback on a larger project.

### Reading the output

Detekt produces both **HTML** and **XML** reports after each run. These reports are generated per module and show:

- The **rule** that was violated (e.g., `MagicNumber`, `LongMethod`, `ComplexCondition`)
- The **file and line number** where the issue was found
- A **description** of the problem and why it matters

Open the HTML report in any browser for a readable, formatted summary. The XML report is consumed automatically by CI tools.

---

## Customizing Rules

Both tools are pre-configured so they work out of the box. When you are ready to tailor the rules to your project's needs, here is where to look:

### Detekt configuration

The Detekt rules are defined in the **`config/detekt/detekt.yml`** file. This file only includes overrides — it builds on top of Detekt's full set of defaults, so you only need to specify what you want to change.

**Examples of what is already customized:**

- **Composable function naming** — Jetpack Compose preview functions start with an uppercase letter, which would normally violate Detekt's naming rules. This exception is already configured so Composable-annotated functions are ignored.
- **Unused private members** — Functions annotated with `@Preview` (Compose preview functions) are excluded from the "unused private member" check, since they are only used by Android Studio's preview tooling and not called directly in code.

**How to customize further:**

1. Open `config/detekt/detekt.yml`
2. Find the rule category you want to adjust (e.g., `style`, `naming`, `complexity`)
3. Add or modify the rule entry — set `active: false` to disable a rule entirely, or adjust threshold values (e.g., maximum allowed function length)
4. A full list of available rules and their options is available in the [Detekt documentation](https://detekt.dev/docs/intro)

### Ktlint configuration

Ktlint enforces standard Kotlin formatting conventions and does not require a separate configuration file for most teams. If you need to adjust Ktlint behavior, refer to the [Kotlinter plugin documentation](https://github.com/jeremymailen/kotlinter-gradle).

---

## How Violations Are Surfaced

### During local development

- Run `lintKotlin` or `detekt` manually at any point from your terminal
- Android Studio will also surface some of these warnings inline as you write code
- Run `formatKotlin` before committing to automatically resolve formatting issues before they become a problem

### In CI (Continuous Integration)

Both tools run automatically as part of the CI pipeline on every pull request:

- **`lintKotlin`** — A formatting violation causes the CI build to **fail**, blocking the pull request until the formatting is corrected (or `formatKotlin` is run locally and the fix is pushed)
- **`detektAll`** — A code smell violation causes the CI build to **fail**, with the report output indicating exactly which rules were triggered and where

This ensures that no code that violates quality standards can be merged into the main branch without being addressed first.

---

## Quick Reference

| Task | Command | When to Use |
|------|---------|-------------|
| Check formatting | `./gradlew lintKotlin` | Verify formatting before submitting a PR |
| Fix formatting | `./gradlew formatKotlin` | Auto-fix all formatting issues locally |
| Run Detekt (sequential) | `./gradlew detekt` | Local development quality check |
| Run Detekt (parallel) | `./gradlew detektAll` | Faster check; used in CI |