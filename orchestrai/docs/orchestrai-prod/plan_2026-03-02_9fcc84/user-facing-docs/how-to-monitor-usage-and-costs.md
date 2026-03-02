# How to Monitor Your Usage and Costs in OrchestrAI

Understanding how many credits you've used — and how many you have left — helps you plan your work and avoid unexpected interruptions. OrchestrAI's Cost Analysis page gives you a complete, real-time picture of your workspace's credit consumption in one convenient place.

---

## Navigating to the Cost Analysis Page

1. Open OrchestrAI and make sure you are inside the workspace you want to check.
2. In the left-hand sidebar, look for the **Settings** or **Billing** section.
3. Click **Cost Analysis**. The page loads your current balance and full usage history automatically.

> 💡 **Tip:** Each workspace has its own Cost Analysis page. If you belong to multiple workspaces, switch to the correct one before viewing costs.

---

## Understanding Your Credit Balance

At the top of the Cost Analysis page you will see a summary of your current credit balance broken down into four categories:

| Credit Type | What It Means |
|---|---|
| **Free Credits** | Credits included with your plan at no charge. These are used first. |
| **Gift Credits** | Bonus credits added to your account (for example, from a promotion or referral). Used after free credits run out. |
| **Paid Credits** | Credits you have purchased as a top-up or as part of a paid plan. Used after free and gift credits are exhausted. |
| **Remaining Balance** | The total credits still available across all three types combined. |

OrchestrAI always draws down your credits in the following order: **Free → Gift → Paid**. This means your purchased credits are always protected until your complimentary credits are fully used.

---

## Reading the Monthly Usage Charts

Below the balance summary, you will find visual charts that show how your credit consumption has changed over time.

- **Monthly bar chart** — Each bar represents one calendar month. The height of the bar shows the total credits consumed that month. Hovering over a bar reveals the exact figure.
- **Trend line** — A line overlaid on the chart shows whether your usage is increasing, decreasing, or staying steady from month to month.
- **Breakdown by credit type** — Each bar is colour-coded to show how much of that month's usage came from free, gift, and paid credits respectively.

### How to Read Your Trend

- If bars are getting **taller each month**, your usage is growing. Consider topping up credits or upgrading your plan before you run out.
- If bars are **roughly the same height**, your usage is stable and predictable.
- A **sudden tall bar** in one month usually means a large job or analysis ran that month — check the usage breakdown to identify what consumed the credits.

---

## What Counts as Credit Usage

Credits are consumed whenever OrchestrAI's AI agents perform active work on your behalf. The following activities use credits:

- **Running an analysis** — Starting any type of analysis (code review, documentation generation, test generation, etc.) consumes credits proportional to the size and complexity of the task.
- **Regenerating results** — Re-running or refreshing an analysis uses credits again, the same as a fresh run.
- **Large repository scans** — Analysing repositories with many files or a large codebase consumes more credits than smaller projects.
- **Multiple agents working in parallel** — When OrchestrAI uses several AI agents simultaneously to complete a job faster, each agent's work is counted toward your usage.

### Operations That Use the Most Credits

| Operation | Relative Credit Cost |
|---|---|
| Full repository analysis | High |
| Test suite generation across many files | High |
| Documentation generation for a large project | Medium–High |
| Single-file code review | Low |
| Viewing results or browsing previously completed analyses | **Free** (no credits consumed) |

> ✅ **Good to know:** Simply browsing your workspace, reading past results, and navigating the OrchestrAI dashboard never consume any credits.

---

## Estimating How Long Your Credits Will Last

Use the monthly chart to calculate a simple forecast:

1. Look at your **average monthly usage** over the past two or three months.
2. Divide your **remaining balance** by that average.
3. The result is approximately how many months your current credits will last.

**Example:** If you have 600 credits remaining and you've been using roughly 200 credits per month, you have approximately **3 months** of usage left at your current rate.

If your usage has been growing month-over-month, factor that into your estimate — your credits may run out sooner than a simple average suggests.

---

## Topping Up Credits or Upgrading Your Plan

If your remaining balance is running low, you can take action directly from the Cost Analysis page without navigating away:

### Add More Credits (Top-Up)
1. On the Cost Analysis page, click the **Add Credits** or **Top Up** button.
2. Select the amount of credits you want to purchase.
3. Confirm your payment details and complete the purchase.

Your new credits appear in your balance immediately and are available for use right away.

### Upgrade to a Higher Plan
1. On the Cost Analysis page, click **Upgrade Plan**.
2. Review the available plans and the credit allowances included with each.
3. Select the plan that best fits your needs and follow the prompts to confirm.

Upgrading your plan typically increases the number of free credits you receive each month, which reduces how quickly you consume paid credits.

---

## Frequently Asked Questions

**What happens if I run out of credits?**
Any in-progress analysis will complete if it was already started. New analyses will be paused until you top up your balance or your free credits renew at the start of the next billing period.

**Do unused free credits roll over to the next month?**
Free credits are typically reset each billing cycle and do not carry forward. Paid and gift credits remain in your account until used.

**Can I see which specific analysis used the most credits?**
The Cost Analysis page shows usage totals and monthly trends. For a breakdown by individual task, check the activity history within each analysis result.

**Is there a way to set a spending limit or get a low-balance alert?**
Check your workspace Settings for notification preferences. OrchestrAI can notify you when your balance drops below a threshold you choose, so you are never caught off guard.