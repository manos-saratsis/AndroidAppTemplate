# AndroidAppTemplate at a Glance

## What Is AndroidAppTemplate?

AndroidAppTemplate is a ready-to-use GitHub template that eliminates the repetitive, time-consuming setup work required every time you start a new Android project. Instead of spending hours configuring code quality tools, continuous integration pipelines, and developer workflows from scratch, you get all of that pre-configured and ready to go — so you can focus on building your app from day one.

The core philosophy of this template can be summarized in one line:

> **Opinionated about tooling. Unopinionated about code.**

---

## Who Is This For?

This template is ideal for **Android developers starting a new project** who want:

- A solid, professional-grade developer tooling foundation without the setup headache
- The freedom to choose their own architecture, folder structure, and third-party libraries
- Confidence that code quality checks and CI/CD are already in place before writing a single line of app code

Whether you're a solo developer or setting up a project for a team, this template gives you a production-ready baseline without locking you into any particular way of writing your app.

---

## What's Included Out of the Box

The template comes pre-configured with a carefully chosen set of developer tools:

| Tool | What It Does |
|---|---|
| **Ktlint** | Automatically enforces consistent code formatting |
| **Detekt** | Scans your code for potential code smells and quality issues |
| **Git Hooks** | Automatically runs static analysis checks every time you commit |
| **Gradle Versions Plugin** | Alerts you when any of your dependencies have newer versions available |
| **GitHub Actions** | Runs continuous integration (CI) checks on every pull request to keep code quality high |
| **LeakCanary** | Detects memory leaks in your app during development |
| **Danger** | Performs automated checks on pull requests and can leave comments with feedback |
| **Pull Request Template** | A built-in PR template that encourages organized, detailed pull request descriptions |

### Optional Dependencies (Removable During Setup)

The following dependencies are included by default but can be easily removed during the initial project setup if you don't need them:

- **Hilt** — Dependency injection
- **Room** — Local database storage
- **Paparazzi** — Screenshot testing

---

## What This Template Does NOT Do

This template is intentionally hands-off when it comes to how you write your app. It does **not**:

- ❌ Dictate or suggest a specific app architecture (e.g., MVVM, MVI, Clean Architecture)
- ❌ Define a package or folder structure for your code
- ❌ Force any particular runtime dependencies or UI framework choices
- ❌ Make decisions about networking libraries, image loaders, or other third-party tools

Those decisions are entirely yours to make.

---

## How to Get Started

1. Visit the [AndroidAppTemplate repository on GitHub](https://github.com/manos-saratsis/AndroidAppTemplate)
2. Click the **"Use this template"** button in the top-right corner
3. A new repository will be created under your account
4. Clone the repository to your machine
5. Open the setup configuration, adjust the package name and app name to match your project
6. Run the rename task to apply your changes automatically — this also cleans up the setup files so your project is ready to go

---

## Video Walkthrough

Want to see everything this template has to offer before diving in? A full video walkthrough is available on YouTube:

🎬 [Watch the AndroidAppTemplate Walkthrough on YouTube](https://youtu.be/E0iMUWJn76E)

---

## The Bottom Line

AndroidAppTemplate gives you a **professional developer tooling foundation in minutes**, not hours. You get code formatting, static analysis, memory leak detection, dependency update checks, CI/CD, and more — all wired together and ready to use. What you build on top of that foundation, and how you build it, is completely up to you.