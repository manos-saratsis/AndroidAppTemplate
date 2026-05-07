## What Is LeakCanary?

LeakCanary is an automatic memory leak detection tool built by Square and included in this project to help you catch memory leaks during development — before they reach your users.

A **memory leak** happens when your app holds on to objects (like screens or data) longer than it needs to, preventing Android from freeing up that memory. Over time, this causes your app to consume more and more RAM, leading to slowdowns, freezes, and crashes. LeakCanary watches your app as you use it and immediately notifies you when a leak is detected, showing you exactly what went wrong.

---

## How It Is Set Up in This Project

LeakCanary is included as a **debug-only dependency**, which means:

- It is **automatically active** when you run a debug build on your device or emulator.
- It is **completely removed** from release (production) builds — your users never see it, and it adds no overhead to your published app.

The dependency is declared in the project as version **2.14** of `com.squareup.leakcanary:leakcanary-android` and is applied exclusively under `debugImplementation` in the app's build configuration. No additional setup, initialization code, or configuration is required — it works out of the box.

---

## How LeakCanary Works Automatically

You do not need to write a single line of code to use LeakCanary. Once you install and run a debug build of the app:

1. **LeakCanary silently monitors** your app's memory in the background as you navigate between screens and use features.
2. When you leave a screen (for example, press Back), LeakCanary checks whether that screen's memory was properly released.
3. If the memory was **not** released within the expected time, LeakCanary triggers a **heap dump** — a snapshot of everything currently in memory.
4. LeakCanary analyzes the heap dump and identifies the chain of objects responsible for keeping memory alive that should have been freed.
5. A **notification appears on your device** telling you a leak was found. Tapping the notification opens a detailed leak report directly on the device.

You will also see a new **"Leaks" app icon** appear on your device after the first run. You can open this at any time to browse all detected leaks.

---

## How to Read a LeakCanary Leak Trace

When LeakCanary detects a leak, it shows you a **leak trace** — a chain of objects from a strong reference (something that is alive and should stay alive) all the way down to the object that is leaking (something that should have been released).

Here is how to interpret the leak trace:

### Structure of a Leak Trace

```
┬───
│ GC Root: Thread
│
├─ SomeThread instance
│    Leaking: NO (a running thread is expected to be alive)
│    ↓ SomeThread.someField
├─ SomeActivity instance
│    Leaking: YES (Activity was destroyed and is no longer needed)
│    ↓ SomeActivity.listener
├─ MyListener instance
│    Leaking: YES (references a destroyed Activity)
```

### What Each Part Means

| Part | What It Tells You |
|---|---|
| **GC Root** | The starting point — an object that Android's garbage collector will never remove (e.g., a running Thread, a static field) |
| **↓ field name** | The specific field on the object above that is holding a reference to the object below |
| **Leaking: NO** | This object is legitimately alive — it is not the problem |
| **Leaking: YES** | This object should have been released but is being held alive by the chain above it |

### Finding the Root Cause

Look for the **transition point** in the trace — the first object marked `Leaking: YES`. The object immediately above it (marked `Leaking: NO`) and the specific **field name** connecting them is your root cause. That field is holding a reference to something that should have been released, and it is where you need to make a fix.

---

## Common Memory Leak Patterns in Android

LeakCanary is particularly good at catching these frequent Android leak patterns:

### 1. Activity or Fragment Held After Destruction
A callback, listener, or background task holds a direct reference to an `Activity` or `Fragment`. When the screen is closed (destroyed), the `Activity` cannot be garbage collected because the callback still points to it.

**Example scenario:** You register a listener on a singleton or a background service using `this` (your Activity), but never unregister it when the Activity is destroyed.

**Fix:** Always unregister listeners and callbacks in the appropriate lifecycle method (e.g., when your screen is being closed or paused).

### 2. Static References to Context or Views
Storing an `Activity`, `Context`, or any `View` in a static variable causes it to live for the entire duration of the app, long after the screen is gone.

**Fix:** Never store Activity or View references in static fields. Use `ApplicationContext` if you need a long-lived context.

### 3. Inner Classes and Anonymous Classes
Non-static inner classes and anonymous classes (like anonymous `Runnable` or `Handler` callbacks) automatically hold an implicit reference to their enclosing class (often an Activity or Fragment).

**Fix:** Use static inner classes combined with a `WeakReference` to the outer class, or switch to lambdas that do not capture `this`.

### 4. Background Tasks Outliving the Screen
A coroutine, thread, or `AsyncTask` that started on a screen continues running after the screen is closed, holding a reference to it.

**Fix:** Tie background tasks to the screen's lifecycle scope so they are automatically cancelled when the screen is destroyed.

---

## Removing LeakCanary

If you decide this project does not need LeakCanary, removing it is straightforward and requires changes in two places:

### Step 1 — Remove the Dependency Declaration
In the app's build configuration file, delete the following line from the `dependencies` block:

```kotlin
debugImplementation(libs.square.leakcanary)
```

### Step 2 — Remove the Version Catalog Entry
In the `gradle/libs.versions.toml` file, remove:

- From the `[versions]` section:
  ```toml
  leakCanary = "2.14"
  ```
- From the `[libraries]` section:
  ```toml
  square-leakcanary = { module = "com.squareup.leakcanary:leakcanary-android", version.ref = "leakCanary" }
  ```

After syncing your project, LeakCanary will be completely removed. No other code changes are needed since LeakCanary requires no initialization code in this project.

---

## Quick Reference

| Topic | Detail |
|---|---|
| **Library** | LeakCanary by Square |
| **Version** | 2.14 |
| **Active In** | Debug builds only |
| **Requires Code Changes?** | No — fully automatic |
| **Where Results Appear** | Device notification + "Leaks" app on device |
| **Official Documentation** | [square.github.io/leakcanary](https://square.github.io/leakcanary/) |