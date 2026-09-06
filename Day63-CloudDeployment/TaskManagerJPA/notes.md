# Day 63 - Deploying to the Cloud

The natural finish line for build -> test -> containerize -> CI: getting
this live on a real public URL anyone can hit. This day needs YOUR OWN
free-tier cloud account, so today is a precise walkthrough rather than
code I can run for you.

## What I learned

### 1. What cloud deployment actually means
Running the app on someone else's server, reachable at a public URL
instead of just localhost. Day 61's Dockerfile does the hard part already
- most modern platforms deploy directly FROM a Dockerfile.

### 2. Picking a platform - Render
AWS/GCP/Azure need credit cards and have steeper learning curves. Render
has a genuinely free tier, deploys directly from a Dockerfile, and
connects straight to GitHub.

### 3. The $PORT problem - a real deployment gotcha
```properties
server.port=${PORT:8080}
```
Cloud platforms typically assign a DYNAMIC port via an environment
variable, not always 8080. This reads `PORT` if set, falls back to 8080
locally where `PORT` is never set.

### 4. Being honest about data persistence
Free-tier hosting typically uses EPHEMERAL disks - anything written to
disk (our H2 file) gets wiped on every redeploy/restart. A real
production app would swap H2 for a managed database (PostgreSQL) instead
- a natural next topic, out of scope for today. Treat today's live
deployment as a DEMO, not permanent storage.

### 5. render.yaml - infrastructure as code
Describes the deployment declaratively instead of manual UI clicking -
reproducible, version-controlled, reviewable in a pull request.

## Step-by-step: deploying to Render

### Step 1 - push today's code to GitHub
```bash
cd ~/Downloads/java-daily-practice
git add .
git commit -m "Day 63: Cloud Deployment"
git push
```

### Step 2 - create a free Render account
Go to **render.com**, sign up (GitHub sign-in is easiest - it connects
your account automatically).

### Step 3 - create a new Web Service
- Click **New +** -> **Web Service**
- Choose **Build and deploy from a Git repository**
- Select your `java-daily-practice` repo (you may need to grant Render
  access to it if this is your first time)

### Step 4 - configure the service
- **Name**: `task-manager-api` (or anything you like - this becomes part
  of your public URL)
- **Root Directory**: `Day63-CloudDeployment/TaskManagerJPA`
  (IMPORTANT - without this, Render looks for a Dockerfile at your repo's
  root, which doesn't exist, since this project lives in a subfolder)
- **Runtime**: Render should auto-detect **Docker** once it sees the
  Dockerfile in that root directory
- **Instance Type**: Free

### Step 5 - add environment variables
Under **Environment Variables**, add:
- Key: `JWT_SECRET`
- Value: any long random string of your choosing (this OVERRIDES the
  default fallback value baked into application.properties)

### Step 6 - deploy
Click **Create Web Service**. Render will:
1. Pull your repo
2. Build the Docker image using your Dockerfile (same multi-stage build
   from Day 61)
3. Start the container
4. Assign you a public URL like `https://task-manager-api-xxxx.onrender.com`

This takes a few minutes the first time. Watch the build logs live in the
Render dashboard - they look almost identical to what you saw locally
with `docker compose up --build`.

### Step 7 - test the live API
Once deployed (status shows "Live"), replace `localhost:8080` with your
actual Render URL:
```bash
curl -X POST https://task-manager-api-xxxx.onrender.com/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'
```

Visit the live Swagger UI too:
```
https://task-manager-api-xxxx.onrender.com/swagger-ui.html
```

### Step 8 (optional) - use render.yaml for a "Blueprint" deploy instead
Render can read `render.yaml` directly and configure everything
automatically ("New +" -> "Blueprint" -> select your repo). This is the
infrastructure-as-code alternative to manually filling in Steps 4-5 by
hand every time.

## A note on the free tier
Render's free web services "spin down" after periods of inactivity - the
FIRST request after idle time can take 30-60 seconds while it wakes back
up. This is normal, not a bug. Also remember: since we're using ephemeral
H2 storage, redeploying (or the service restarting after inactivity, on
some plans) may reset your data back to the seeded admin account.

## Commands I ran
```bash
git push
```
(then configured and deployed via the Render dashboard)

## Questions / things to revisit
- Why does `server.port=${PORT:8080}` need to exist at all - what would happen if the app were hardcoded to `server.port=8080` and Render assigned a different port?
- Why does setting **Root Directory** correctly matter so much for THIS specific repo structure - what would Render try to build without it?
- Why is it honest (not just a caveat, but a genuinely important limitation) to say H2 data won't reliably persist on a free-tier deployment - what would actually need to change to fix this properly?
