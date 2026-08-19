# Day 47 - Practice Exercises: Networking Basics

These require running TWO terminal windows for most exercises - a
server in one, a client in another.

---

### Exercise 1: Echo server (Easy-Medium)
Modify `SimpleServer` into an "echo" server: whatever message the client
sends, the server sends the SAME message right back (instead of a
different reply). Test with `SimpleClient` sending a custom message.

---

### Exercise 2: Client sends multiple messages in a loop (Easy-Medium)
Modify `SimpleClient` to send 3 different messages in a row (using
multiple `out.println()` calls) before closing. Modify the server to read
3 lines with `in.readLine()` (called 3 times) and print each one.

---

### Exercise 3: Server responds differently based on input (Medium)
Modify the server so that if the client sends "PING", it replies "PONG",
but for any other message, it replies "Unknown command: [message]". Test
with a client sending "PING" and one sending something else.

---

### Exercise 4: Keep the connection open for a back-and-forth conversation (Medium-Hard)
Modify BOTH the server and client to loop: the client sends a message,
waits for a reply, then sends ANOTHER message (you can hardcode 3
exchanges), until finally sending "BYE" - at which point the server closes
the connection. Trace through the exact order of blocking `readLine()`
calls on both sides.

---

### Exercise 5: Port already in use (Harder - conceptual)
Start `SimpleServer` in one terminal. WITHOUT closing it, try starting
ANOTHER instance of `SimpleServer` in a second terminal (same port). You
should get a `BindException` - the port is already taken. Catch this
exception specifically and print a friendly message like "Port 5000 is
already in use - is another server instance already running?"

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 4, why must the CLIENT'S `readLine()` call happen AFTER the server's `println()` reply - what would happen if the order were reversed on one side?
- [ ] Why does Exercise 1's echo server need ZERO extra logic beyond just sending back what it received - what does this reveal about how simple `println()`/`readLine()` really are underneath?
- [ ] In Exercise 5, why does a SECOND server on the SAME port fail, but a second CLIENT connecting to an EXISTING server work completely fine?
- [ ] Why would a real chat application need something more sophisticated than "hardcode 3 exchanges then send BYE" (Exercise 4) - what's genuinely unpredictable about real conversations that this doesn't handle?

If you're unsure on any of these, revisit `notes.md` before moving to Day 48.
