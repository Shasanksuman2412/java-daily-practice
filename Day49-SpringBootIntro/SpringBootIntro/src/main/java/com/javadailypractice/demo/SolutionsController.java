package com.javadailypractice.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SolutionsController {

    private final GreetingService greetingService;
    private final MathService mathService; // second injected dependency - Exercise 2

    // ---- Spring automatically provides BOTH dependencies when constructing this controller ----
    public SolutionsController(GreetingService greetingService, MathService mathService) {
        this.greetingService = greetingService;
        this.mathService = mathService;
    }

    // ---- Exercise 1: simple status endpoint ----
    @GetMapping("/status")
    public String status() {
        return "Server is running!";
    }

    // ---- Exercise 2: isPrime using the injected MathService ----
    @GetMapping("/isprime/{number}")
    public boolean isPrime(@PathVariable int number) {
        return mathService.isPrime(number);
    }

    // ---- Exercise 3: multiple query parameters ----
    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b, @RequestParam int c) {
        return mathService.multiply(a, b, c);
    }

    // ---- Exercise 4: returning a record, auto-converted to JSON ----
    @GetMapping("/person/{name}/{age}")
    public Person person(@PathVariable String name, @PathVariable int age) {
        return new Person(name, age); // Spring serializes this to {"name": "...", "age": ...}
    }

    // ---- Exercise 5: returning a List, auto-converted to a JSON array ----
    @GetMapping("/numbers")
    public List<Integer> numbers() {
        return mathService.fibonacciList(10);
    }
}
