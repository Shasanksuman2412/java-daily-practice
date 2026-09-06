# Day 63 - Practice Exercises: Cloud Deployment

These require an actual Render account (or an equivalent platform, if you
prefer). All ask you to interact with a REAL live deployment.

---

### Exercise 1: Complete the deployment (Easy-Medium)
Follow `notes.md`'s step-by-step walkthrough exactly. Confirm you get a
live public URL and can successfully log in via curl against it.

---

### Exercise 2: Test the Swagger UI live (Easy-Medium)
Visit your deployed app's `/swagger-ui.html` in a browser. Use the
Authorize button with a token obtained from the LIVE `/auth/login`
endpoint (not localhost). Try out at least one GET and one POST endpoint
directly against the deployed instance.

---

### Exercise 3: Watch the free tier "spin down" behavior (Medium)
Deploy successfully, then don't touch the app for 15+ minutes. Make a
request again and time how long the FIRST response takes (likely 30-60
seconds as it wakes up), then make a SECOND request immediately after and
confirm it's fast. Write a comment explaining why this happens.

---

### Exercise 4: Prove data doesn't survive a redeploy (Medium-Hard)
Register a new user on your live deployment. Confirm you can log in as
them. Then trigger a redeploy (push any small change, like editing a
comment, and push again). Once the redeploy finishes, try logging in as
that same user again - confirm it FAILS (user is gone), while the SEEDED
admin account still works (since `DataInitializer` re-seeds it on every
startup). Explain in a comment why this specifically happens.

---

### Exercise 5: Add a custom domain or explore render.yaml Blueprint deploys (Harder)
Either: (a) explore Render's custom domain settings (you don't need to
actually own a domain - just read through what the process would involve),
or (b) delete your manually-configured service and redeploy using the
"Blueprint" option with `render.yaml` instead, confirming it produces an
equivalent working deployment with less manual configuration.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 3, why does the FIRST request after inactivity take so much longer than a normal request - what's actually happening during that delay (think about what "spin down" means for a container)?
- [ ] In Exercise 4, why does the SEEDED admin account survive a redeploy while a REGISTERED user doesn't - both are stored in the same H2 database, so what's different about how each gets created?
- [ ] Why does `rootDir` in `render.yaml` (or the "Root Directory" field in the UI) need to point at the SPECIFIC subfolder, rather than Render just automatically finding the Dockerfile somewhere in a large repo?
- [ ] What's the actual FIX for Exercise 4's data-loss problem, if you wanted a genuinely persistent live deployment (hint: think about what Day 51 originally replaced, and what a "managed" version of that would look like)?

If you're unsure on any of these, revisit `notes.md`.

Sixty-three days in, and this project is now live on the actual internet
- reachable by anyone, anywhere, not just on your own machine. That's a
genuinely significant milestone in the build-test-ship lifecycle.
