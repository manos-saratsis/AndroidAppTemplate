# Creating Your Project from the Template

Welcome! This guide walks you through setting up your very own Android project using the AndroidAppTemplate. By the end of these steps, you'll have a working copy of the project on your computer, ready to build and customize.

---

## Before You Begin

Make sure you have the following ready:

- A **GitHub account** (free at [github.com](https://github.com))
- **Android Studio** installed on your computer ([download here](https://developer.android.com/studio))
- **Git** installed on your computer ([download here](https://git-scm.com))

---

## Step 1: Create Your New Repository from the Template

1. Go to the **AndroidAppTemplate** repository on GitHub:
   👉 [github.com/manos-saratsis/AndroidAppTemplate](https://github.com/manos-saratsis/AndroidAppTemplate)

2. In the top-right area of the page, click the green **"Use this template"** button.

   > 💡 **Tip:** If you don't see the button right away, make sure you are signed in to your GitHub account.

3. A new page will appear asking you to set up your repository. Fill in the following:
   - **Owner** – Select your GitHub username or organization from the dropdown.
   - **Repository name** – Type a name for your new project (e.g., `MyAwesomeApp`).
   - **Visibility** – Choose **Public** or **Private** depending on your preference.

4. Click the green **"Create repository from template"** button.

GitHub will generate a brand-new repository under your account with all the template files included. This usually takes just a few seconds.

---

## Step 2: Copy the Repository Link

1. On your new repository's page, click the green **"Code"** button near the top right.
2. Make sure the **HTTPS** tab is selected.
3. Click the **copy icon** to copy the repository URL to your clipboard. It will look something like:
   ```
   https://github.com/YOUR-USERNAME/MyAwesomeApp.git
   ```

---

## Step 3: Clone the Repository to Your Computer

1. Open a **terminal** (Mac/Linux) or **Command Prompt / Git Bash** (Windows).
2. Navigate to the folder where you want to save your project. For example:
   ```
   cd Documents/Projects
   ```
3. Type the following command, replacing the URL with the one you copied:
   ```
   git clone https://github.com/YOUR-USERNAME/MyAwesomeApp.git
   ```
4. Press **Enter**. Git will download all the project files into a new folder with your project's name.

---

## Step 4: Open the Project in Android Studio

1. Launch **Android Studio**.
2. On the welcome screen, click **"Open"** (or go to **File → Open** if a project is already open).
3. In the file browser that appears, navigate to the folder where you cloned your project (e.g., `Documents/Projects/MyAwesomeApp`).
4. Select the **root project folder** and click **"OK"** (or **"Open"**).

Android Studio will begin loading your project.

---

## Step 5: Run the Initial Gradle Sync

When Android Studio opens a project for the first time, it automatically starts a **Gradle sync** — this is the process that downloads all the tools and libraries your project needs to work.

1. You'll see a progress bar at the bottom of the screen while the sync runs. **Wait for it to complete** — this may take a few minutes the first time, especially if files need to be downloaded.

2. If Android Studio does **not** start the sync automatically, you can trigger it manually:
   - Click the **elephant icon with an arrow** (🐘) in the toolbar, or
   - Go to **File → Sync Project with Gradle Files**.

3. Watch the **Build** panel at the bottom of the screen. A successful sync will show a message like:
   ```
   BUILD SUCCESSFUL
   ```

   > ⚠️ **If you see errors:** The most common causes are a missing internet connection (needed to download libraries) or an outdated version of Android Studio. Make sure you're connected to the internet and that your Android Studio is up to date.

---

## Step 6: Verify the Project Builds Successfully

Before making any changes to the project, confirm everything is working correctly by running a test build.

1. In the top menu, go to **Build → Make Project** (or press **Ctrl+F9** on Windows/Linux, **⌘+F9** on Mac).
2. Watch the **Build** output panel at the bottom of the screen.
3. A successful build will display:
   ```
   BUILD SUCCESSFUL
   ```

If the build succeeds — congratulations! 🎉 Your project is set up correctly and ready for the next steps.

---

## ✅ You're All Set!

You now have a fully working local copy of your new Android project. Here's a quick summary of what you accomplished:

| Step | What You Did |
|------|-------------|
| 1 | Created a new GitHub repository from the template |
| 2 | Copied your repository's URL |
| 3 | Cloned the project to your computer |
| 4 | Opened the project in Android Studio |
| 5 | Ran a Gradle sync to download all dependencies |
| 6 | Verified the project builds without errors |

---

## What's Next?

Now that your project is up and running, you're ready to **rename and customize the template** — swapping out the placeholder app name and package details for your own. Head to the **Renaming Your Project** guide to continue.

> 💡 **Want a visual walkthrough?** The template author has recorded a full video tour of everything this template offers. You can watch it on [YouTube](https://youtu.be/E0iMUWJn76E).