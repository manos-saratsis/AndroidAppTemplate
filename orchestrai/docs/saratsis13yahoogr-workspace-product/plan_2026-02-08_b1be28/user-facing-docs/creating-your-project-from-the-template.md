# Creating Your Project from the Template

This guide will walk you through creating your own Android project using the Android App Template. You'll go from clicking a button on GitHub to having a fully functional development environment on your computer.

## What You'll Get

When you create a project from this template, you'll have a ready-to-use Android application with professional development tools already configured, including:

- Code formatting and quality checks
- Automated testing workflows
- Memory leak detection
- Dependency management tools
- Pull request templates for team collaboration

## Step 1: Create Your Repository from the Template

1. **Navigate to the template repository** at https://github.com/manos-saratsis/AndroidAppTemplate

2. **Click the "Use this template" button** located at the top right of the page (next to the green "Code" button)

3. **Fill in your new repository details:**
   - Choose a repository name for your project
   - Add a description (optional)
   - Select whether you want the repository to be public or private
   - Leave "Include all branches" unchecked unless you have a specific reason to include them

4. **Click "Create repository"** - GitHub will create a new repository under your account with all the template files copied over

## Step 2: Download Your Project

Once your repository is created, you need to download it to your computer:

1. **Copy the repository URL:**
   - On your new repository page, click the green "Code" button
   - Copy the HTTPS URL shown (it will look like `https://github.com/your-username/your-project-name.git`)

2. **Open your terminal or command prompt** and navigate to where you want to store your project

3. **Clone the repository** by running:
   ```
   git clone [paste-your-repository-url-here]
   ```

4. **Navigate into your project folder:**
   ```
   cd your-project-name
   ```

## Step 3: Customize Your Project

Now that you have the template on your computer, you need to customize it with your project's information:

1. **Open your project in Android Studio** (or your preferred code editor)

2. **Locate the setup configuration file** at `buildscripts/setup.gradle`

3. **Edit the `renameConfig` section** to match your project:
   - Update the package name to your desired Android package (e.g., `com.yourcompany.yourapp`)
   - Change the app name to your application's name
   - Modify any other configuration values as needed

4. **Run the rename task:**
   - Open the Gradle panel in Android Studio
   - Find the `renameTemplate` task
   - Run the task - this will automatically update all files with your new project information

5. **The cleanup is automatic** - The rename task will remove the setup files and test workflows, so your project is ready to go

## Step 4: Configure Team Collaboration (Optional)

If you're working with a team and want to enable automated code review comments:

1. **Go to your repository on GitHub**

2. **Navigate to Settings** from your repository menu

3. **Select "Actions"** from the left sidebar, then **"General"**

4. **Scroll down to "Workflow permissions"**

5. **Select "Read and write permissions"** - This allows automated tools to comment on your pull requests with helpful feedback

6. **Click "Save"**

## Step 5: Verify Your Setup

To make sure everything is working correctly:

1. **Open the project in Android Studio** if you haven't already

2. **Wait for Gradle to sync** - This may take a few minutes the first time as it downloads necessary dependencies

3. **Build the project** by clicking the "Build" menu and selecting "Make Project" (or press Ctrl+F9 / Cmd+F9)

4. **Run the app** on an emulator or physical device to confirm it launches successfully

## Next Steps

Congratulations! Your development environment is now ready. You can:

- **Start building your features** - The template doesn't enforce any specific architecture, so you're free to structure your code as you prefer

- **Review the included tools** - Explore the documentation folder in your project to learn about the developer tools that are pre-configured

- **Invite team members** - Add collaborators to your repository on GitHub so your team can start contributing

- **Create your first pull request** - The template includes a pull request template to help you and your team write clear, organized descriptions

## Need Help?

If you encounter any issues during setup, you can report them on the original template repository's issue tracker. The template is designed to make setup smooth, but if something doesn't work as expected, the community can help troubleshoot.