## What Is LeakCanary?

LeakCanary is an automatic memory leak detection tool built by Square (the same team behind Retrofit and OkHttp). A **memory leak** happens when your app holds on to objects — like screens or data — longer than it needs to, preventing Android from freeing up that memory. Over time, leaks cause your app to slow down, consume excessive memory, and eventually crash.

This template includes LeakCanary **version 2.14** so that every developer on the team gets instant, automatic feedback about memory leaks while building and testing the app — before those leaks ever reach users.

---

## How LeakCanary Is Set Up

LeakCanary is included as a **debug-only** dependency (`com.squareup.leakcanary:leakcanary-android`). This means:

- ✅ It runs automatically in **Debug builds** (when you build and run the app from Android Studio)
- ✅ It requires **zero code changes** — just install and go
- ❌ It is **completely absent from Release builds** that go to users — no performance impact, no extra app size in production

You do not need to initialize it, configure it, or write a single line of setup code. The moment you run a debug build, LeakCanary is watching.

---

## How LeakCanary Detects Leaks (Automatic)

Once your app is running in debug mode, LeakCanary silently monitors it in the background. Here is what happens automatically:

1. **It watches objects that should be garbage collected** — primarily screens (Activities and Fragments) that the user has navigated away from or dismissed.
2. **It waits a few seconds** after the object should have been released.
3. **If the object is still in memory**, LeakCanary triggers a heap dump — a snapshot of everything currently in your app's memory.
4. **It analyzes the snapshot** to find exactly which chain of references is keeping the object alive.
5. **It notifies you** with a system notification and a detailed leak report.

You do not need to do anything to trigger this. Simply use your app normally — navigate between screens, press Back, rotate the device — and LeakCanary will catch leaks as they occur.

---

## Understanding the LeakCanary Notification and Leaks Screen

When a leak is detected, two things happen:

### 1. System Notification
A notification appears in your device's notification shade that reads something like:
> **"LeakCanary: 1 new leak"**

Tapping this notification opens the **Leaks screen** — a dedicated app screen installed alongside your app during debug builds specifically for viewing leak reports.

### 2. The Leaks Screen
The Leaks screen (labeled **"Leaks"** in your app drawer) shows a list of all detected leaks. Each entry displays:

- **The leaked object type** (e.g., `MainActivity`, `HomeFragment`)
- **How many times** that leak has been seen
- A tap-to-expand **leak trace** showing the full chain of references causing the leak

---

## Reading a Leak Trace

A leak trace is the most important part of the report. It shows you a **chain of objects** — from a "GC Root" (something Android always keeps alive) down to your **leaked object**. Every link in the chain is a reference that is preventing memory from being freed.

Here is an example of what a leak trace looks like:

```
┬───
│ GC Root: Thread local variable
│
├─ android.os.HandlerThread instance
│    Leaking: NO (PathClassLoader↓ is not leaking)
│
├─ com.example.myapp.SomeManager instance
│    Leaking: NO (a static field references it)
│    ↓ SomeManager.listener
│
╰→ com.example.myapp.MainActivity instance
     Leaking: YES (Activity#mDestroyed is true)
```

**How to read it:**

| Part | What It Means |
|------|---------------|
| **GC Root** | The starting point — something Android will never release (a thread, a static field, a system service) |
| **Arrow chain (↓)** | Each arrow is a reference from one object to the next |
| **"Leaking: NO"** | This object itself is fine, but it holds a reference that leads to the problem |
| **"Leaking: YES"** | This is your leaked object — it should have been released but wasn't |
| **Field name (e.g., `.listener`)** | The exact field on the parent object that holds the reference |

**Your fix lives just above the "Leaking: YES" line.** Look at the field name on the object immediately above the leaked object — that is almost always where you need to clear or remove the reference.

---

## Common Memory Leak Patterns to Watch For

LeakCanary will catch these frequently in Android apps:

### 🔴 Activity or Fragment Leaks via Callbacks / Listeners
A screen registers itself as a listener (for a click, a data event, an animation) and never unregisters when the screen closes. The listener holds a reference to the screen, keeping it alive.

**What to look for in the trace:** A `Manager`, `Service`, or `ViewModel` holding a reference to a destroyed `Activity` or `Fragment`.

**Fix:** Always unregister listeners in the appropriate lifecycle callback (`onStop`, `onDestroyView`, `onDestroy`).

---

### 🔴 Static References to Contexts or Views
Storing an `Activity`, `Context`, or `View` in a static field (one that lives for the entire lifetime of the app) means that screen can never be garbage collected.

**What to look for in the trace:** A `GC Root: Static field` pointing to your Activity or a View that contains your Activity.

**Fix:** Never store `Activity` or `View` references in static fields. If you need a long-lived context, use `applicationContext` instead.

---

### 🔴 Inner Classes Holding Implicit References
Anonymous classes, Runnables, or non-static inner classes defined inside an Activity automatically hold a hidden reference to that Activity.

**What to look for in the trace:** An anonymous class or `$1`-style class name appearing in the chain.

**Fix:** Use static inner classes with a `WeakReference` to the Activity, or use a `ViewModel` + `LiveData` pattern to decouple background work from the screen lifecycle.

---

### 🔴 Fragment Leaks via View Binding
Holding a reference to a View (or a view binding object) inside a Fragment after `onDestroyView` is a very common leak in Jetpack-based apps.

**What to look for in the trace:** A `Fragment` instance where `mView` is null but a binding field still references old views.

**Fix:** Set your binding reference to `null` in `onDestroyView`.

---

## Dealing with False Positives

Occasionally, LeakCanary may report a leak that is actually a known issue inside the Android operating system or a third-party library — not something your code caused. These are called **false positives**.

LeakCanary 2.x includes a built-in list of known false positives for common Android SDK bugs and automatically suppresses many of them. However, if you encounter a leak that you have confirmed is not from your own code, you can tell LeakCanary to ignore it.

To do this, you would create a custom configuration in your app's debug source set that adds the pattern to LeakCanary's ignore list. The [official LeakCanary documentation](https://square.github.io/leakcanary/recipes/#ignoring-specific-leaks) provides step-by-step instructions and examples for writing these exclusion rules.

> **Tip:** Before marking anything as a false positive, search for the class name in the [LeakCanary known issues list](https://github.com/square/leakcanary/blob/main/shark-android/src/main/java/shark/AndroidReferenceMatchers.kt) to see if it is already recognized and suppressed automatically.

---

## Quick Reference: LeakCanary Workflow

```
Run debug build
      ↓
Use your app normally (navigate, press Back, rotate screen)
      ↓
LeakCanary detects a retained object
      ↓
Notification appears → Tap to open Leaks screen
      ↓
Read the leak trace → Find the "Leaking: YES" object
      ↓
Look at the field just above it → That's your fix
      ↓
Fix the code → Re-run → Confirm leak is gone
```

---

## Summary

| Topic | Detail |
|-------|--------|
| **Library** | LeakCanary 2.14 by Square |
| **Dependency type** | Debug-only — never ships to users |
| **Setup required** | None — works automatically |
| **How to trigger** | Just use your app normally in a debug build |
| **Where to see results** | Notification shade → "Leaks" app screen |
| **Most common leaks** | Listeners not unregistered, static context references, Fragment view binding held past `onDestroyView` |
| **Official docs** | [square.github.io/leakcanary](https://square.github.io/leakcanary/) |