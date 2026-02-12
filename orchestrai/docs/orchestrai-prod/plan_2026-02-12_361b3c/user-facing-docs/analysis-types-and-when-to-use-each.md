I'll retrieve the key source files first to understand the analysis types available in this product.# Analysis Types and When to Use Each

Choosing the right analysis for your needs helps you focus your efforts and get the most value from your development process. This guide helps you understand what each analysis type does and when to use it.

## Code Quality Analysis

### What It Does

Code quality analysis examines your project for maintainability, readability, and efficiency. It looks for:

- **Code complexity** - Methods or functions that are hard to understand and maintain
- **Code smells** - Patterns that suggest potential problems (like duplicated code or overly complex conditionals)
- **Formatting issues** - Inconsistent code style that makes your project harder to read
- **Best practices** - Whether your code follows established standards and conventions
- **Magic numbers** - Hard-coded values that should be named constants
- **Long methods** - Functions that try to do too much at once
- **Long parameter lists** - Functions with too many inputs

### When to Use It

Run code quality analysis when:

- **Starting a new project** - Establish quality standards from day one
- **Before major releases** - Ensure your code is clean before shipping
- **After adding new features** - Verify new code meets your quality standards
- **During code reviews** - Get objective feedback on code quality
- **When onboarding new team members** - Help them understand your code standards
- **When technical debt is accumulating** - Identify areas that need refactoring

### Benefits

- Makes your code easier to understand and modify
- Reduces the time spent on code reviews
- Helps new team members learn your coding standards
- Prevents small issues from becoming big problems
- Improves team consistency across the entire codebase

## Security Analysis

### What It Does

Security analysis scans your project for vulnerabilities and security risks. It examines:

- **Known vulnerabilities** - Security issues in your dependencies
- **Unsafe coding patterns** - Code that could introduce security holes
- **Authentication weaknesses** - Problems with how users log in
- **Data exposure risks** - Places where sensitive information might leak
- **Permission issues** - Incorrect security permissions
- **Encryption gaps** - Missing or weak data protection

### When to Use It

Run security analysis when:

- **Handling sensitive data** - Your app processes passwords, payment info, or personal data
- **Before releases** - Catch security issues before users do
- **After adding dependencies** - New libraries might contain vulnerabilities
- **For compliance requirements** - Meeting security standards for your industry
- **When connecting to external services** - APIs and third-party integrations increase risk
- **After security incidents** - Audit your codebase following a breach or close call
- **Regular security audits** - Schedule periodic checks as part of your security practice

### Benefits

- Protects your users' data and privacy
- Prevents costly security breaches
- Helps meet regulatory requirements
- Builds trust with your users
- Reduces legal and financial risks
- Catches issues before attackers do

## Testing Analysis

### What It Does

Testing analysis evaluates your test coverage and generates new tests. It provides:

- **Test coverage reports** - Which parts of your code are tested
- **Test generation** - Automatically creates tests for untested code
- **Coverage improvement suggestions** - Where to add tests for maximum benefit
- **Test quality assessment** - Whether your tests actually verify important behavior
- **Gap identification** - Critical code paths that lack testing

### When to Use It

Run testing analysis when:

- **Test coverage is low** - You need to improve how much of your code is tested
- **Before major changes** - Ensure good test coverage before refactoring
- **After bug fixes** - Verify that new tests prevent regression
- **When shipping critical features** - Important functionality needs thorough testing
- **During continuous integration** - Automatically verify tests with every change
- **When team testing practices vary** - Standardize testing across your team
- **Before releases** - Confirm adequate test protection

### Benefits

- Catches bugs before they reach users
- Makes refactoring safer
- Documents how your code should behave
- Reduces manual testing time
- Improves confidence in your releases
- Helps new developers understand the codebase

## Documentation Generation

### What It Does

Documentation generation creates guides and reference materials from your code. You can generate:

- **User-facing documentation** - Guides for people using your app
- **Developer documentation** - Technical references for your team
- **API documentation** - How to integrate with your services
- **Architecture overviews** - High-level system design explanations
- **Setup instructions** - How to install and configure your project

### When User Documentation Is Needed

Generate user documentation when:

- **Launching to new users** - Help people understand what your app does
- **Adding complex features** - Users need guidance for advanced functionality
- **Supporting non-technical users** - Clear explanations in simple language
- **Reducing support requests** - Answer common questions before they're asked
- **Improving user adoption** - Good docs help people start using your product

### When Developer Documentation Is Needed

Generate developer documentation when:

- **Onboarding new team members** - Help them get up to speed quickly
- **The codebase is complex** - Explain architectural decisions and patterns
- **Multiple teams collaborate** - Share understanding across different groups
- **APIs need explanation** - Internal or external integrations require clarity
- **Code has unusual patterns** - Document non-standard approaches
- **Before knowledge loss** - Preserve understanding when people leave the team

### Benefits

- Reduces time answering the same questions
- Helps teams work independently
- Improves onboarding speed
- Preserves institutional knowledge
- Makes your product easier to use
- Enables self-service for users and developers

## Compliance Analysis

### What It Does

Compliance analysis verifies your project meets regulatory and organizational requirements. It checks:

- **Regulatory standards** - GDPR, HIPAA, PCI-DSS, and other legal requirements
- **License compliance** - Whether your dependencies have compatible licenses
- **Accessibility standards** - WCAG compliance for users with disabilities
- **Industry certifications** - Standards specific to your field
- **Internal policies** - Your organization's coding and security rules
- **Data protection laws** - How user data is collected and stored

### When to Use It

Run compliance analysis when:

- **Preparing for audits** - Regular checks or certification renewals
- **Entering new markets** - Different regions have different regulations
- **Handling regulated data** - Healthcare, finance, or government projects
- **Before major releases** - Verify compliance before shipping
- **After adding dependencies** - Ensure new libraries meet requirements
- **When regulations change** - Adapt to new legal requirements
- **Starting government contracts** - Meet specific compliance standards

### Benefits

- Avoids legal penalties and fines
- Simplifies audit processes
- Protects user privacy rights
- Enables business in regulated industries
- Demonstrates due diligence
- Maintains certifications and approvals

## Workflow Recommendations

### Early Development Phase

When starting a new project:
1. **Run code quality analysis** - Establish standards from the beginning
2. **Set up testing analysis** - Build good testing habits early
3. **Generate developer documentation** - Help your team understand the architecture

### Active Development Phase

During ongoing feature work:
1. **Run code quality before merging** - Keep standards consistent
2. **Use testing analysis for new features** - Ensure adequate coverage
3. **Run security analysis weekly** - Catch issues early

### Pre-Release Phase

Before shipping to users:
1. **Run full security analysis** - Identify all vulnerabilities
2. **Verify test coverage** - Ensure critical paths are tested
3. **Run compliance analysis** - Meet all legal requirements
4. **Generate user documentation** - Help users get started

### Maintenance Phase

For established products:
1. **Schedule regular security scans** - Stay ahead of new vulnerabilities
2. **Review quality metrics monthly** - Track technical debt
3. **Update documentation quarterly** - Keep it current with changes
4. **Run compliance checks before audits** - Be prepared for reviews

### Team Priority Scenarios

**Quality-Focused Teams:**
- Emphasize code quality and testing analysis
- Run checks with every pull request
- Use metrics to track improvement over time

**Security-First Projects:**
- Schedule frequent security scans
- Run compliance checks regularly
- Prioritize vulnerability fixes immediately

**Fast-Moving Startups:**
- Focus on testing analysis for safety
- Run quality checks before releases
- Generate documentation to reduce onboarding time

**Enterprise Organizations:**
- Comprehensive compliance analysis
- Detailed documentation for all stakeholders
- Regular audits across all analysis types

## Making Your Choice

Ask yourself these questions:

- **What keeps you up at night?** If it's bugs, focus on testing. If it's security, prioritize security analysis.
- **What does your team struggle with?** Poor code quality suggests quality analysis. Slow onboarding suggests documentation.
- **What are your business requirements?** Regulated industries need compliance analysis. Customer-facing products need user documentation.
- **What phase is your project in?** Early projects need quality and testing. Mature projects need security and compliance.

Remember: You don't have to choose just one. Combine different analyses based on your current needs and run them at different frequencies. Start with what matters most right now, and expand your analysis coverage over time.