# How to Use Static Analysis (Ktlint and Detekt)

This project includes two static analysis tools that automatically enforce code quality standards: **Ktlint** for code formatting and **Detekt** for detecting code issues. Together, they help every contributor write code that looks and behaves consistently — no more debates over spacing, indentation, or complex logic.

---

## Understanding the Two Tools

| Tool | What It Does |
|------|-------------|
| **Ktlint** | Enforces consistent code formatting — spacing, indentation, imports, and style |
| **Detekt** | Detects code smells — magic numbers, overly long methods, complicated conditions, and more |

Think of **Ktlint** as a formatter (like an auto-spell-checker for code style) and **Detekt** as a code reviewer (like a colleague flagging overly complex logic).

---

## Running Ktlint

Ktlint offers two commands depending on what you want to do:

### Check Formatting

To find out whether your code meets formatting standards (without changing anything):

```
./gradlew lintKotlin
```

This will report any formatting violations so you can review them.

### Auto-Format Your Code

To automatically fix formatting issues across the entire codebase:

```
./gradlew formatKotlin
```

This is the easiest way to get your code into shape before committing. Run this command and Ktlint will rewrite any files that have formatting problems.

> **Tip:** When in doubt, run `formatKotlin` first, then `lintKotlin` to confirm everything is clean.

---

## Running Detekt

Detekt checks your code for structural and complexity issues. You have two options:

### Run Sequentially (one module at a time)

```
./gradlew detekt
```

### Run in Parallel (faster, all modules at once)

```
./gradlew detektAll
```

After running either command, Detekt will report any violations it finds, such as:

- Magic numbers (unexplained numeric values in logic)
- Long or complicated methods
- Overly long parameter lists
- Complex conditional statements

---

## Customizing Detekt Rules

The Detekt configuration file lives at **`config/detekt/detekt.yml`**. This is where you control which rules are active, which are turned off, and what thresholds to use.

The configuration file is intentionally kept minimal — it only overrides the defaults you want to change, which makes it easy to maintain.

### Example: Composable Function Names

By default, Detekt flags functions that start with uppercase letters. Since Jetpack Compose requires composable functions to be uppercase, the configuration already includes a rule to ignore this for `@Composable`-annotated functions:

```yaml
naming:
  FunctionNaming:
    ignoreAnnotated: ['Composable']
```

### Example: Unused Preview Functions

Compose `@Preview` functions are often private and appear "unused" to Detekt. The configuration already handles this:

```yaml
style:
  UnusedPrivateMember:
    ignoreAnnotated: ['Preview']
```

### How to Customize Rules

Open `config/detekt/detekt.yml` and add or modify entries following the same pattern. You can:

- **Disable a rule entirely** by setting `active: false` under that rule
- **Change thresholds** (e.g., maximum line length, maximum method length)
- **Exclude specific directories** using the `excludes` pattern (e.g., test directories)

Full documentation of all available rules is available at [detekt.dev/docs/intro](https://detekt.dev/docs/intro).

---

## Suppressing a Specific Detekt Warning

Sometimes a rule violation is intentional. Rather than disabling the rule globally, you can suppress it for a specific piece of code by adding an annotation directly above it:

```kotlin
@Suppress("MagicNumber")
val retryLimit = 3
```

Use the exact rule name (as reported by Detekt) inside `@Suppress(...)`. This keeps the rule active everywhere else while acknowledging that this particular case is a deliberate choice.

---

## Automatic Enforcement (Git Hooks & CI)

You don't have to remember to run these tools manually. They are wired into the project's automation:

### Git Hooks

When you attempt to commit or push code, git hooks automatically run the static analysis checks. If violations are found, the commit or push will be blocked until the issues are resolved. This prevents style or quality problems from ever entering the repository.

### Continuous Integration (CI)

Every pull request is also checked by the CI pipeline, which runs both Ktlint and Detekt automatically. A pull request cannot be merged if either tool reports a failure.

---

## Quick Reference

| Goal | Command |
|------|---------|
| Check formatting | `./gradlew lintKotlin` |
| Auto-fix formatting | `./gradlew formatKotlin` |
| Run Detekt (sequential) | `./gradlew detekt` |
| Run Detekt (parallel) | `./gradlew detektAll` |
| Customize rules | Edit `config/detekt/detekt.yml` |
| Suppress one warning | Add `@Suppress("RuleName")` to your code |