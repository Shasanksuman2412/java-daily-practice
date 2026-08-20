package com.javadailypractice.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // combines @Controller + @ResponseBody: every method's return value becomes the HTTP response body
public class GreetingController {

    private final GreetingService greetingService;

    // ---- Constructor injection: Spring automatically provides a GreetingService instance ----
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // ---- Simple GET endpoint: visit http://localhost:8080/hello ----
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    // ---- @PathVariable: pulls a value straight out of the URL ----
    // visit http://localhost:8080/greet/Shasank
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return greetingService.getGreeting(name);
    }

    // ---- @RequestParam: pulls values from query string parameters ----
    // visit http://localhost:8080/add?a=5&b=3
    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return greetingService.add(a, b);
    }
}
