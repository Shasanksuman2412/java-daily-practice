# Day 62 - Practice Exercises: CI/CD with GitHub Actions

These require pushing to your actual GitHub repository and watching the
Actions tab. Some intentionally ask you to break things to see CI catch it.

---

### Exercise 1: Get the baseline workflow running (Easy-Medium)
Follow `notes.md`'s setup steps exactly. Push, and confirm "Task Manager
CI" appears in the Actions tab and finishes GREEN. If it fails, read the
log output carefully - it will tell you exactly which step failed.

---

### Exercise 2: Add a status badge to your README (Easy-Medium)
Add a `![CI](...)` badge line near the top of your repo's main
`README.md` (from Day 1!), using YOUR actual GitHub username and repo
name in the URL. Push, and confirm the badge renders and shows the
correct current status (green/red) when you view the repo on GitHub.com.

---

### Exercise 3: Break a test on purpose and watch CI catch it (Medium)
Comment out `@NotBlank` on `Task.title`, commit, and push. Confirm the
Actions tab turns red and the failure log clearly shows which test failed
and why. Then revert the change, push again, and confirm it turns green.

---

### Exercise 4: Add a second job that runs in parallel (Medium-Hard)
Add a THIRD job (alongside `test` and `build-image`) that runs
`mvn -B checkstyle:check` or similar (or just a simple `echo "Linting
placeholder"` step if you don't want to set up a real linter). Make it
run in PARALLEL with `test` (no `needs:`), and confirm both show as
running simultaneously in the Actions tab's visual graph.

---

### Exercise 5: Trigger the workflow ONLY on pull requests, not direct pushes (Harder - conceptual)
Modify the `on:` section so the workflow runs on `pull_request` events
but NOT on direct pushes to `main`. Create a new branch, make a small
change, open a Pull Request on GitHub, and confirm CI runs automatically
on the PR before you'd even consider merging it. Explain in a comment why
many real teams REQUIRE this ("passing CI" as a merge requirement).

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 3, why does the CI failure log show the SAME kind of output you'd see running `mvn test` locally - what is GitHub Actions actually running under the hood?
- [ ] In Exercise 4, why does removing `needs:` from a job make it run in PARALLEL rather than waiting - what does `needs:` actually control?
- [ ] In Exercise 5, why is "require CI to pass before merging" considered a valuable team practice, even for a solo project like this one?
- [ ] Why does a red CI badge (Exercise 2) sitting right on your GitHub repo's homepage matter MORE than just knowing tests pass locally on your own machine?

If you're unsure on any of these, revisit `notes.md`.

Sixty-two days in - the project now tests and packages itself
automatically on every push, the same workflow real engineering teams
rely on daily.
