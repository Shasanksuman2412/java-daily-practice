# Day 48 - Practice Exercises: Extend the Chat Server

Like Days 20 and 30, these ask you to MODIFY the actual project files.
No separate Solutions.java - build it yourself.

---

### Exercise 1: Add a `/history` command (Easy-Medium)
In `ClientHandler`, add a special case: if a client sends the exact
message `/history`, instead of broadcasting it, call
`MessageStore.printRecentHistory(10)` on the SERVER side and send those
lines back to JUST that client (not broadcast to everyone).

---

### Exercise 2: List currently online users (Medium)
Add a `List<String> onlineUsers` (or a `Map<String, PrintWriter>` instead
of just a `List<PrintWriter>`) shared across all `ClientHandler` instances.
When a client sends `/who`, reply with a list of currently connected
usernames, sent only to that client.

---

### Exercise 3: Private messaging (Medium-Hard)
Add support for a message format like `/msg username Hello there` that
sends a message to ONLY that specific user (using the Map from Exercise 2
to find their `PrintWriter`), instead of broadcasting to everyone. Handle
the case where the target username doesn't exist.

---

### Exercise 4: Message rate limiting (Medium-Hard)
Add a simple protection: if a client sends more than 5 messages within 10
seconds, temporarily ignore further messages from them for a few seconds,
printing a warning to that client only. (Hint: track a timestamp list per
client, or a simple counter with `System.currentTimeMillis()` checks.)

---

### Exercise 5: Graceful server shutdown (Harder)
Currently, stopping the server (Ctrl+C) doesn't notify connected clients.
Look up `Runtime.getRuntime().addShutdownHook()` and use it to broadcast
a "SERVER: shutting down" message to all connected clients before the
server process actually exits.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 1, why should `/history` reply to ONLY the requesting client, not broadcast to everyone - what would happen to the chat experience if it did broadcast?
- [ ] In Exercise 2, why does switching from `List<PrintWriter>` to `Map<String, PrintWriter>` make Exercise 3 (private messaging) much easier to implement?
- [ ] In Exercise 4, why is tracking timestamps PER CLIENT (not one shared counter for everyone) the correct approach for rate limiting?
- [ ] In Exercise 5, why does a shutdown hook run even if the server is stopped abruptly (Ctrl+C), unlike code placed after the `while(true)` loop which would never normally be reached?

This project is worth returning to as you learn more - real chat systems,
job queues, and multiplayer games are built from exactly this pattern:
persistent state, concurrent connections, and message passing.
