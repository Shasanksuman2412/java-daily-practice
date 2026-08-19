# Day 48 - Capstone Project #3: Multi-Client Chat Server

This closes out the "core Java" phase - a genuinely real, working system
combining networking, persistence, and concurrency all at once.

## What this project demonstrates

| Concept | Day learned | Where it's used |
|---|---|---|
| Sockets (server/client) | Day 47 | `ChatServer`, `ChatClient` |
| Multithreading | Day 21 | One `Thread` per connected client in `ChatServer`; a listener thread in `ChatClient` |
| AutoCloseable / try-with-resources | Day 42 | `Socket`, `ServerSocket`, JDBC `Connection` all auto-close |
| JDBC persistence | Day 45 | `MessageStore` saves every message to SQLite |
| Text blocks | Day 39 | The `CREATE TABLE` SQL in `MessageStore` |
| Collections (thread-safe) | Day 16 + 21 | `Collections.synchronizedList()` for the shared broadcast list |
| Exception handling | Day 15 | `IOException`/`SQLException` handled throughout |
| Scanner input | Day 31 | `ChatClient` reads user messages interactively |
| JAR packaging concepts | Day 46 | This project COULD be packaged into runnable JARs the same way |

## Architecture

- `MessageStore.java` - all JDBC logic: initializing the table, saving
  messages, printing recent history. Nothing else touches the database
  directly - this keeps persistence logic in ONE place.
- `ClientHandler.java` - runs on its OWN thread per connected client.
  Reads that client's username, then loops reading messages, saving each
  one and broadcasting it to everyone.
- `ChatServer.java` - the main server loop: accepts new connections
  forever, spinning up a new `ClientHandler` thread for each one.
- `ChatClient.java` - connects, spawns a background thread just for
  LISTENING to incoming broadcasts (since reading and writing both block,
  you genuinely need two threads to do both at once), while the main
  thread handles sending what the user types.

## Why the broadcast list needs `synchronized`

Multiple `ClientHandler` threads add/remove themselves from `allWriters`
concurrently, and also iterate over it to broadcast. Without
`Collections.synchronizedList()` and the `synchronized` blocks in
`ClientHandler`, this is exactly the kind of race condition demonstrated
back on Day 21 - unpredictable, hard-to-reproduce bugs.

## How to run this (Maven + THREE terminal windows)

**Terminal 1 - start the server:**
```bash
cd Day48-CapstoneProject3/ChatServer
mvn compile exec:java -Dexec.mainClass="ChatServer"
```

**Terminal 2 - first client:**
```bash
mvn compile exec:java -Dexec.mainClass="ChatClient"
```
Enter a username, then type messages.

**Terminal 3 - second client:**
```bash
mvn compile exec:java -Dexec.mainClass="ChatClient"
```
Enter a DIFFERENT username. Messages typed in Terminal 2 should appear
in Terminal 3, and vice versa - broadcast working in real time.

Type `EXIT` in a client terminal to disconnect that client cleanly.

After stopping the server and restarting it, run `MessageStore.printRecentHistory(10)`
(already called automatically on server startup) - you'll see the
conversation history persisted from the PREVIOUS run, proving the SQLite
storage genuinely survives a restart.

## Questions / things to revisit
- Why does `ChatClient` need a SEPARATE thread just for reading incoming messages, instead of just alternating "read user input, then check for new messages" in one loop?
- Why is `Collections.synchronizedList()` alone not quite enough safety here - why do the `broadcast()` and `run()` methods in `ClientHandler` ALSO wrap their loop in `synchronized (allWriters)`?
- If you wanted to add a feature where users can see WHO is currently online, what would you need to add - trace through which files would need changes.
- Looking back across the whole month: which single project (Day 20's Student Manager, Day 30's Library System, or this Chat Server) combines the MOST distinct concepts from different days? Why?

## Forty-eight days
Day 1 printed one line. Day 48 is a networked, multithreaded, persistent
chat application - built entirely from concepts introduced one at a time,
each building on the last. That's what daily, compounding practice
actually produces.
