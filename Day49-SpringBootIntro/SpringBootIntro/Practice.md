# Day 49 - Practice Exercises: Introduction to Spring Boot

Try to solve these YOURSELF first, without looking at DemoApplication.java,
GreetingService.java, GreetingController.java, or Solutions.java.

All of these require running the app with `mvn spring-boot:run` and
testing endpoints in a browser or with `curl`.

---

### Exercise 1: Add a new simple endpoint (Easy-Medium)
Add a `@GetMapping("/status")` endpoint to `GreetingController` that
returns the String `"Server is running!"`. Test it in your browser.

---

### Exercise 2: A new Service with business logic (Easy-Medium)
Create a new `@Service` class `MathService` with a method
`boolean isPrime(int n)` (reuse logic from Day 05/24). Inject it into
`GreetingController` (add it as a SECOND constructor parameter) and
create an endpoint `/isprime/{number}` using `@PathVariable` that returns
`true` or `false`.

---

### Exercise 3: Multiple query parameters (Medium)
Create an endpoint `/multiply` that takes THREE `@RequestParam` integers
(`a`, `b`, `c`) and returns their product. Test with
`/multiply?a=2&b=3&c=4` and confirm you get `24`.

---

### Exercise 4: Returning a custom object as JSON (Medium-Hard)
Create a simple `record Person(String name, int age)` (Day 35!). Add an
endpoint `/person/{name}/{age}` using TWO `@PathVariable`s that returns a
`Person` object directly (not a String). Spring automatically converts it
to JSON - visit the endpoint and observe the JSON response in your browser.

---

### Exercise 5: A List endpoint (Harder)
Create an endpoint `/numbers` that returns a `List<Integer>` of the first
10 Fibonacci numbers (reuse Day 09's recursive Fibonacci, or write it
iteratively). Confirm Spring serializes the List as a JSON array
automatically when you visit the endpoint.

---

## Self-check
You should be able to answer these without looking anything up:
- [ ] In Exercise 2, why does adding `MathService` as a SECOND constructor parameter work without any extra configuration - what is Spring actually doing when it sees TWO parameters needing injection?
- [ ] In Exercise 4, why does returning a plain `record` from a `@RestController` method automatically produce JSON, when Day 39's text blocks needed you to manually format JSON as a String?
- [ ] Why does changing `@PathVariable` types (like Exercise 4's `int age` from the URL) automatically convert the URL text into the correct Java type, without you calling `Integer.parseInt()` yourself?
- [ ] What's fundamentally different about how Exercise 5's endpoint "sends data" compared to Day 47's raw socket `println()` calls - what is Spring doing underneath that you don't have to think about anymore?

If you're unsure on any of these, revisit `notes.md` before moving to Day 50.
