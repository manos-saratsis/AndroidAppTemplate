# AndroidAppTemplate at a Glance

## What Is This?

**AndroidAppTemplate** is a ready-made starting point for new Android projects. Instead of spending hours setting up code quality tools, formatting rules, and automation pipelines every time you start something new, this template gives you all of that out of the box — so you can focus on actually building your app.

---

## The Core Idea

This template has a clear philosophy that sets it apart:

> **Opinionated about tooling. Unopinionated about architecture.**

That means the template makes smart decisions about *developer tools* (formatting, code checks, automation) so you don't have to — but it never tells you how to structure your code, which architecture to use, which libraries to prefer, or how to organize your packages. Those choices are entirely yours.

---

## What Problem Does It Solve?

Every new Android project needs the same foundational setup: code formatting rules, static analysis, automated checks, dependency management, and CI pipelines. Setting these up from scratch on every project is repetitive and easy to skip under deadline pressure.

This template solves the "blank slate" problem by giving you a production-quality tooling foundation from day one, so your very first commit starts with confidence.

---

## What's Included

| Tool | What It Does |
|------|-------------|
| **Ktlint** | Automatically formats your Kotlin code to a consistent style |
| **Detekt** | Scans your code for potential problems and bad practices (code smells) |
| **Git Hooks** | Runs formatting and analysis checks automatically before every commit |
| **Gradle Versions Plugin** | Tells you when any of your dependencies have newer versions available |
| **GitHub Actions** | Runs automated checks on every Pull Request to keep code quality high |
| **Danger** | Reviews Pull Requests and posts helpful automated comments and warnings |
| **LeakCanary** | Detects memory leaks in your app while you develop |
| **Hilt** | Dependency injection setup (can be removed during setup if not needed) |
| **Room** | Local database setup (can be removed during setup if not needed) |
| **Paparazzi** | Screenshot testing for UI components (can be removed during setup if not needed) |
| **Pull Request Template** | A pre-filled PR description template to help your team write clear, organized pull requests |

---

## Who Is This For?

This template is ideal for **Android developers starting a new project** who want:

- A clean, professional tooling setup without the manual configuration work
- Consistent code quality enforced automatically from the start
- Freedom to choose their own architecture and libraries
- A foundation that scales easily into a multi-module project

Whether you're a solo developer or part of a team, this template removes the boilerplate so your project starts strong.

---

## See It in Action

Want a guided tour before you dive in? There's a full video walkthrough available on YouTube:

🎬 **[Watch the Video Walkthrough →](https://youtu.be/E0iMUWJn76E)**

---

## Ready to Get Started?

Click the **"Use this template"** button at the top right of the [repository page](https://github.com/manos-saratsis/AndroidAppTemplate) to create your own copy. From there, a quick configuration step lets you rename the package and customize it to your project — and you're off.