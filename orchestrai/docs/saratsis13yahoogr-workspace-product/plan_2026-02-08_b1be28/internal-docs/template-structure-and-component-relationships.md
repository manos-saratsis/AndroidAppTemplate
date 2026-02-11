# Template Structure and Component Relationships

## Overview

The AndroidAppTemplate is a modular, opinionated GitHub template repository designed to provide developer tooling infrastructure while remaining unopinionated about application code architecture. The template's architecture emphasizes automated setup, code quality enforcement, and maintainability through a coordinated system of build scripts, git hooks, static analysis tools, and CI/CD workflows.

## Core Architecture Principles

### 1. Tooling-First, Code-Agnostic Design

The template is explicitly designed to:
- Provide comprehensive developer tooling infrastructure
- Avoid imposing architectural patterns on application code
- Enable developers to choose their own architecture, dependencies, and package structure
- Focus solely on code quality, formatting, and development workflow automation

### 2. Self-Configuring Template System

The template includes a sophisticated setup system (`buildscripts/setup.gradle`) that transforms the template into a production-ready project through automated renaming and dependency management.

## Component Architecture

### Build System Organization

The template uses a distributed build configuration architecture with centralized management:

```
project-root/
├── build.gradle.kts              # Root build configuration
├── settings.gradle.kts           # Project settings and module configuration
├── gradle/
│   └── libs.versions.toml        # Centralized dependency catalog
└── buildscripts/
    ├── setup.gradle              # Template initialization and setup
    ├── detekt.gradle             # Static analysis configuration
    └── versionsplugin.gradle     # Dependency update checking
```

#### File: `buildscripts/setup.gradle`

This is the core orchestration script for template initialization. It defines the template transformation logic through a configuration-driven approach.

**Configuration Structure:**

```groovy
def renameConfig = [
    templateName                : "template",
    templateAppId               : "template.app.id",
    templateMaterialThemeName   : "TemplateTheme",
    templateApplicationClassName: "TemplateApp",
    newPackage                  : "aaa.yourname.app",
    newProjectName              : "Your Project",
    newMaterialThemeName        : "MyMaterialTheme",
    newApplicationClassName     : "MyApp",
    useHiltDependencies         : true,
    useRoomDependencies         : true,
    useRetrofitDependencies     : true,
    usePaparazziDependencies    : true,
    useRenovateDependencies     : true,
    useAndroidXR                : false,
]
```

### Template Setup Pipeline

The setup system implements a multi-stage pipeline orchestrated by the `renameTemplate` task:

#### Stage 1: Dependency Filtering (`keepOrRemoveDependencies`)

**Purpose:** Conditionally removes unwanted dependencies based on `renameConfig` flags.

**Target Files:**
- `build.gradle.kts`
- `gradle/libs.versions.toml`
- `app/build.gradle.kts`
- `app/src/main/AndroidManifest.xml`
- `app/src/main/java/template/TemplateApp.kt`
- `app/src/main/java/template/MainActivity.kt`

**Removal Logic:**
```groovy
if (renameConfig.useHiltDependencies != true) {
    removeTextFromFile(fileName, "hilt")
    removeTextFromFile(fileName, "Hilt")
    removeTextFromFile(fileName, "AndroidEntryPoint")
}
```

**Configurable Dependencies:**
- **Hilt:** Dependency injection framework (removes `@HiltAndroidApp`, `@AndroidEntryPoint` annotations)
- **Room:** Database persistence (removes Room dependencies)
- **Retrofit:** HTTP client (removes Retrofit, Moshi, OkHttp dependencies)
- **Paparazzi:** Screenshot testing (removes Paparazzi plugin)
- **Renovate:** Automated dependency updates (deletes `renovate.json5`)
- **AndroidXR:** Extended reality support (removes XR dependencies)

#### Stage 2: Package Renaming (`renameAppPackage`)

**Purpose:** Transforms the template package structure to the developer's custom package name.

**Implementation Details:**
- Type: Gradle `Copy` task
- Source: `app/src/main/java/template`
- Destination: `app/src/main/java/{newPackageAsDirectory}`

**Transformation Operations:**

1. **Package Statement Replacement:**
   ```groovy
   filter { line ->
       line.replaceAll("package ${renameConfig.templateName}", "package ${renameConfig.newPackage}")
   }
   ```

2. **Import Statement Replacement:**
   ```groovy
   filter { line ->
       line.replaceAll("import ${renameConfig.templateName}", "import ${renameConfig.newPackage}")
   }
   ```

3. **Theme Reference Replacement:**
   ```groovy
   filter { line ->
       line.replaceAll("${renameConfig.templateMaterialThemeName}", "${renameConfig.newMaterialThemeName}")
   }
   ```

4. **Application Class Renaming:**
   ```groovy
   rename { fileName ->
       if (fileName.contains("${renameConfig.templateApplicationClassName}")) {
           fileName.replace(
               "${renameConfig.templateApplicationClassName}",
               "${renameConfig.newApplicationClassName}"
           )
       } else {
           fileName
       }
   }
   ```

5. **Cleanup:** Deletes original template directory after successful copy.

#### Stage 3: Reference Replacement (`replaceTemplateReferences`)

**Purpose:** Updates configuration files with new package names and project identifiers.

**File Transformations:**

1. **AndroidManifest.xml:**
   - Updates activity references: `template.MainActivity` → `{newPackage}.MainActivity`
   - Updates application class: `.TemplateApp` → `.{newApplicationClassName}`

2. **app/build.gradle.kts:**
   - Updates namespace: `namespace = "template"` → `namespace = "{newPackage}"`
   - Updates applicationId: `applicationId = "template.app.id"` → `applicationId = "{newPackage}"`

3. **settings.gradle.kts:**
   - Updates project name: `rootProject.name = "template"` → `rootProject.name = "{newProjectName}"`

4. **strings.xml:**
   - Updates app name: `<string name="app_name">template</string>` → `<string name="app_name">{newProjectName}</string>`

#### Stage 4: Cleanup (`deleteSetupCode`)

**Purpose:** Removes template-specific files that are not needed in production projects.

**Deleted Files:**
- `.github/workflows/template_change_test.yml` - Template validation workflow
- `.github/workflows/install_git_hooks_macos.yml` - MacOS-specific hook installation
- `.github/workflows/install_git_hooks_windows.yml` - Windows-specific hook installation
- `buildscripts/setup.gradle` - The setup script itself
- `renovate.json5` - (Conditional) If Renovate is not enabled

**Additional Cleanup:**
```groovy
removeTextFromFile("${rootDir}/build.gradle.kts", "setup.gradle")
```
Removes the reference to `setup.gradle` from the root build file.

#### Stage 5: Code Formatting Integration

**Task Dependency Chain:**
```groovy
project('app').tasks.named {
    it.startsWith("formatKotlin")
}.configureEach {
    mustRunAfter(rootProject.tasks.named("renameTemplate"))
}

task renameTemplate {
    dependsOn(
        keepOrRemoveDependencies,
        renameAppPackage,
        replaceTemplateReferences,
        deleteSetupCode,
    )
    finalizedBy("app:formatKotlin")
}
```

**Execution Flow:**
1. All rename operations complete
2. Kotlin formatting runs automatically via `finalizedBy`
3. Ensures all generated code adheres to formatting standards

#### Stage 6: Git Integration

**Automatic Staging:**
```groovy
doLast {
    exec {
        commandLine "git", "add", "${rootDir}/."
    }
}
```

After all transformations complete, the task automatically stages all changes for commit, enabling immediate commit and push operations.

## Dependency Management Architecture

### Gradle Version Catalog System

**Location:** `gradle/libs.versions.toml`

The template uses Gradle's version catalog feature for centralized dependency management, providing:
- Single source of truth for all dependency versions
- Type-safe accessors in build scripts
- Easy sharing across multi-module projects

### Multi-Module Support

**Root Build Configuration (`build.gradle.kts`):**
```groovy
subprojects {
    apply from: "../buildscripts/detekt.gradle"
    apply from: "../buildscripts/versionsplugin.gradle"
}
```

This configuration automatically applies static analysis and version checking to all submodules, enabling:
- Consistent tooling across modules
- Zero-configuration module addition
- Centralized tool management

## Static Analysis Integration

### Tool Distribution

The template includes multiple static analysis tools configured in separate build scripts:

1. **Ktlint** - Code formatting (referenced in `/documentation/StaticAnalysis.md`)
2. **Detekt** - Code smell detection (`buildscripts/detekt.gradle`)
3. **Danger** - Pull request automation (`Dangerfile.df.kts`)

### Analysis Enforcement Points

The template enforces code quality at multiple stages:

1. **Pre-commit:** Git hooks run static analysis before allowing commits
2. **Pre-push:** Additional checks before code reaches remote
3. **CI/CD:** GitHub Actions workflows validate all pull requests
4. **PR Review:** Danger performs automated review checks

## Git Workflow Integration

### Git Hooks Architecture

**Location:** `/documentation/GitHooks.md` (referenced in README)

The template includes pre-configured git hooks that automatically:
- Run static analysis checks
- Validate code formatting
- Prevent commits that violate quality standards

**Installation Workflows:**
- `.github/workflows/install_git_hooks_macos.yml` (deleted during setup)
- `.github/workflows/install_git_hooks_windows.yml` (deleted during setup)

These workflows are template-specific and removed after initialization since hooks are installed locally.

## CI/CD Architecture

### GitHub Actions Integration

**Location:** `/documentation/GitHubActions.md` (referenced in README)

The template includes workflows for:
- Continuous integration on pull requests
- Automated code quality checks
- Danger-based PR validation

### Danger Integration

**Configuration:** `Dangerfile.df.kts`

**Required Repository Setup:**
To enable Danger PR comments, configure repository permissions:
1. Navigate to: Repository Settings → Actions → General
2. Scroll to: "Workflow Permissions"
3. Set: Read and write permissions

## Template Validation System

### Template Change Testing

**Workflow:** `.github/workflows/template_change_test.yml`

This workflow validates that template modifications don't break the setup process. It is automatically deleted during the `renameTemplate` task execution since it's only relevant for template development, not end projects.

## Documentation Structure

The template includes comprehensive documentation in `/documentation/`:

- **StaticAnalysis.md** - Ktlint and Detekt configuration and usage
- **GitHooks.md** - Git hook setup and customization
- **VersionsPlugin.md** - Dependency update checking
- **GitHubActions.md** - CI/CD workflow documentation

**Design Philosophy:**
Documentation files are written to be retained in production projects, serving as onboarding material for team members.

## Utility Functions

The setup script provides reusable text manipulation utilities:

### `replaceTextInFile(fileName, originalText, newText)`

**Purpose:** Global find-and-replace within a file.

**Implementation:**
```groovy
static def replaceTextInFile(fileName, originalText, newText) {
    def file = new File(fileName)
    file.text = file.text.replaceAll(originalText, newText)
}
```

**Use Cases:**
- Package name updates
- Project name substitution
- Configuration value replacement

### `removeTextFromFile(fileName, text)`

**Purpose:** Line-level filtering to remove dependency references.

**Implementation:**
```groovy
static def removeTextFromFile(fileName, text) {
    def file = new File(fileName)
    List fileLines = file.readLines()
    file.text = ""
    fileLines.each { line ->
        if (!line.contains(text)) {
            file.append(line)
            file.append("\n")
        }
    }
}
```

**Use Cases:**
- Removing unwanted dependencies
- Cleaning up conditional code blocks
- Removing annotations for unused frameworks

**Design Note:** Uses line-based filtering rather than regex for predictable removal of entire dependency declarations.

## Component Relationships

### Initialization Flow

```
User Configures renameConfig
          ↓
  Runs renameTemplate Task
          ↓
    ┌─────┴─────┬─────────────┬──────────────────┬────────────┐
    ↓           ↓             ↓                  ↓            ↓
Keep/Remove  Rename       Replace          Delete        Format
Dependencies  Package     References       Setup         Kotlin
    ↓           ↓             ↓             Files            ↓
    └───────────┴─────────────┴──────────────┴──────────────┘
                            ↓
                     Git Add Changes
                            ↓
                   Ready for Commit
```

### Runtime Integration

```
Developer Workflow
        ↓
    Git Commit
        ↓
   Git Hooks Execute
        ↓
   ├─ Ktlint Format Check
   ├─ Detekt Code Analysis
   └─ Custom Validation
        ↓
    Git Push
        ↓
 GitHub Actions Triggered
        ↓
   ├─ CI Build
   ├─ Test Execution
   ├─ Static Analysis
   └─ Danger PR Review
```

### Build System Hierarchy

```
Root build.gradle.kts
    ↓
    ├─→ gradle/libs.versions.toml (Dependency Catalog)
    ↓
    ├─→ buildscripts/setup.gradle (Template Setup)
    ├─→ buildscripts/detekt.gradle (Static Analysis)
    └─→ buildscripts/versionsplugin.gradle (Version Checking)
    ↓
Applied to All Subprojects
    ↓
app/build.gradle.kts
```

## Pull Request Template System

**Location:** `.github/pull_request_template.md`

Provides standardized PR descriptions to ensure:
- Consistent PR documentation
- Comprehensive change descriptions
- Organized team communication

## Memory Leak Detection

**Dependency:** LeakCanary

Automatically included in debug builds to detect memory leaks during development. Requires no configuration and operates transparently.

## Extensibility Points

### Adding New Dependencies

1. Update `gradle/libs.versions.toml` with version and dependency declaration
2. Reference in `app/build.gradle.kts` using catalog accessor
3. (Optional) Add removal logic in `keepOrRemoveDependencies` if dependency should be optional

### Adding New Static Analysis Tools

1. Create new build script in `buildscripts/{tool}.gradle`
2. Apply to subprojects in root `build.gradle.kts`:
   ```groovy
   subprojects {
       apply from: "../buildscripts/{tool}.gradle"
   }
   ```

### Customizing Setup Process

Modify `renameConfig` in `buildscripts/setup.gradle`:
- Add new configuration flags
- Extend task dependencies
- Add custom transformation logic in `doLast` blocks

## Best Practices for Template Usage

### Initial Setup

1. Click "Use this template" on GitHub
2. Clone the new repository
3. Edit `buildscripts/setup.gradle` `renameConfig`
4. Run `./gradlew renameTemplate`
5. Verify changes with `git diff`
6. Commit and push changes

### Multi-Module Projects

The architecture is pre-configured for multi-module support:
- Create new module directories
- Add to `settings.gradle.kts`
- Static analysis automatically applies
- Share dependencies via version catalog

### Continuous Integration

Ensure proper Danger permissions for automated PR reviews:
- Enable read/write workflow permissions
- Verify GitHub Actions workflows execute
- Customize `Dangerfile.df.kts` for project-specific rules

## Maintenance Considerations

### Template Updates

When updating the template itself:
- Maintain `.github/workflows/template_change_test.yml` for validation
- Test `renameTemplate` task after modifications
- Update documentation to reflect architectural changes

### Version Management

Use the included Versions Plugin to:
- Identify outdated dependencies
- Plan upgrade cycles
- Maintain security patches

Reference: `/documentation/VersionsPlugin.md`

## Architecture Benefits

1. **Zero Configuration for New Modules:** Tooling automatically applies
2. **Consistent Code Quality:** Enforced at commit, push, and PR stages
3. **Self-Documenting:** Comprehensive documentation included in template
4. **Flexible Dependency Management:** Easy to add/remove frameworks
5. **Automated Setup:** Single command transforms template to production project
6. **Git Integration:** Automatic staging reduces manual steps
7. **Team Onboarding:** Documentation and templates standardize practices