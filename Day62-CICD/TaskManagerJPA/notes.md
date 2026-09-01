# Day 62 - CI/CD with GitHub Actions

We've got tests (Day 58) and a Docker image (Day 61) - today automates
both: every push to GitHub runs tests and builds a Docker image
automatically, with zero manual steps.

## What I learned

### 1. What is CI/CD?
- **Continuous Integration** - automatically build and test code on every
  push, catching breakage immediately
- **Continuous Deployment** - automatically deploy (or package) the app
  after tests pass

### 2. GitHub Actions - workflows as YAML files
Any file in `.github/workflows/*.yml` in a repo defines an automated
pipeline, triggered by events like `push` or `pull_request`.

### 3. A basic CI workflow
```yaml
on:
  push:
    branches: [main]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - run: mvn test
```
Runs on GitHub's own servers automatically, every push - the same
`mvn test` from Day 58/59, just triggered without typing anything.

### 4. Caching dependencies for faster builds
```yaml
- uses: actions/setup-java@v4
  with:
    cache: 'maven' # caches ~/.m2 between runs
```

### 5. Building a Docker image as part of CI
```yaml
build-image:
  needs: test # only runs if the test job succeeds first
```
`needs: test` creates a DEPENDENCY CHAIN - the image only gets built if
tests pass, preventing broken code from ever being packaged.

### 6. Scoping the workflow to a subfolder
Since this project lives inside a larger learning repo:
```yaml
on:
  push:
    paths:
      - 'Day62-CICD/TaskManagerJPA/**'

jobs:
  test:
    defaults:
      run:
        working-directory: Day62-CICD/TaskManagerJPA
```

### 7. A status badge for the README
```markdown
![CI](https://github.com/username/repo/actions/workflows/ci.yml/badge.svg)
```
A live green/red badge showing whether the latest code actually passes.

## How to actually see this run

The workflow file lives at the REPO ROOT (`.github/workflows/ci.yml`),
not inside this project folder - GitHub only looks for workflows in that
exact location.

**Step 1 - copy the workflow file to the right place:**
```bash
cd ~/Downloads/java-daily-practice
mkdir -p .github/workflows
```
Copy `ci.yml` (from today's download) into `.github/workflows/ci.yml`
at the ROOT of your `java-daily-practice` repo.

**Step 2 - copy the project folder as usual:**
```bash
mkdir -p Day62-CICD/TaskManagerJPA
# copy today's TaskManagerJPA files in, same as every previous day
```

**Step 3 - commit and push:**
```bash
git add .
git commit -m "Day 62: CI/CD with GitHub Actions"
git push
```

**Step 4 - watch it run:**
Go to your repository on GitHub.com, click the **Actions** tab. You
should see "Task Manager CI" running (a yellow dot), then turning green
(success) or red (failure) within a minute or two.

**Try breaking it on purpose:**
Comment out `@NotBlank` on `Task.title` again (like Day 58's exercise),
commit, and push. Watch the Actions tab turn RED - the exact failing test
will be shown right there in the log, without you needing to run anything
locally first.

## Commands I ran
```bash
git push
```
(then watched the Actions tab on GitHub.com)

## Questions / things to revisit
- Why does the `paths:` filter matter so much for THIS specific repo - what would happen (in terms of wasted CI minutes) without it, given how many unrelated Day folders exist?
- Why does `build-image` declare `needs: test` instead of just being a separate, independent job - what problem does that dependency prevent?
- Why is caching (`cache: 'maven'`) genuinely valuable for CI specifically, even though it doesn't change what the workflow actually DOES - what resource is it saving?
