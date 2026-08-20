package com.javadailypractice.demo;

import org.springframework.stereotype.Service;

@Service // marks this class as a Spring-managed bean, available for injection elsewhere
public class GreetingService {

    public String getGreeting(String name) {
        return "Hello, " + name + "! Welcome to Spring Boot.";
    }

    public int add(int a, int b) {
        return a + b;
    }
}
