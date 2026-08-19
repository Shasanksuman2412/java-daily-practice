# Day 47 - Networking Basics (Sockets)

## What I learned

### 1. What's a socket?
An endpoint for sending/receiving data over a network. A SERVER listens on
a port for connections; a CLIENT connects to that address and port. Once
connected, both sides read/write data as streams - very similar to Day 18's
file I/O.

### 2. A simple TCP server
```java
ServerSocket serverSocket = new ServerSocket(5000); // listen on port 5000
Socket clientSocket = serverSocket.accept(); // BLOCKS until a client connects

BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
```

### 3. A simple TCP client
```java
Socket socket = new Socket("localhost", 5000); // connect to that server
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
```

### 4. Closing sockets - AutoCloseable again (Day 42)
```java
try (ServerSocket serverSocket = new ServerSocket(5000);
     Socket clientSocket = serverSocket.accept()) {
    // ...
} // both close automatically
```

### 5. Handling multiple clients - one thread per connection
```java
while (true) {
    Socket clientSocket = serverSocket.accept();
    new Thread(() -> handleClient(clientSocket)).start(); // Day 21's multithreading
}
```

### 6. InetAddress - resolving hostnames
```java
InetAddress address = InetAddress.getByName("localhost");
address.getHostAddress(); // e.g. 127.0.0.1
```

### 7. Common exceptions
- `UnknownHostException` - hostname couldn't be resolved
- `ConnectException` - nothing is listening on that address/port
- `IOException` - general read/write failure

## How to actually run this

This is the FIRST day needing TWO programs running at once, in SEPARATE
terminal windows.

### Single client/server test
**Terminal 1:**
```bash
javac SimpleServer.java
java SimpleServer
```
It will print "Server waiting for a connection..." and WAIT (this is
normal - it's blocked on `accept()`).

**Terminal 2 (open a NEW terminal window, same folder):**
```bash
javac SimpleClient.java
java SimpleClient
```
You should see the client connect, send a message, and print the
server's reply. Check back on Terminal 1 - it should show the received
message too, then the server program will exit (since it only handles
one connection).

### Multi-client test
**Terminal 1:**
```bash
javac MultiClientServer.java
java MultiClientServer
```

**Terminal 2, 3, 4... (run SimpleClient multiple times, but pointed at port 5001):**
You'll need to temporarily change `SimpleClient.java`'s port from 5000 to
5001 to test against `MultiClientServer`, OR just run it several times
quickly to see multiple threads handling connections in Terminal 1's output.

## Commands I ran
See above - always TWO terminals for this topic.

## Questions / things to revisit
- Why does `serverSocket.accept()` BLOCK (pause the program) until a client connects, instead of just returning immediately with "no client yet"?
- Why does `MultiClientServer` need a NEW THREAD per client, instead of just handling clients one after another in a loop?
- What's the practical difference between `ConnectException` (client tries to connect, nobody's listening) and `UnknownHostException` (the hostname itself couldn't even be resolved)?
