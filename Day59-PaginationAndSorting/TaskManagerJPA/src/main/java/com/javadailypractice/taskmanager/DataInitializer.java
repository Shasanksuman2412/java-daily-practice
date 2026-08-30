package com.javadailypractice.taskmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// CommandLineRunner: Spring calls run() automatically once on startup,
// after the application context is fully built - a common way to seed data.
@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Solves the chicken-and-egg problem: with zero users in a fresh
        // database, nobody could log in at all. Seed one admin account,
        // but only if it doesn't already exist (so restarts don't duplicate it).
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN");
            userRepository.save(admin);
            System.out.println("Seeded initial admin account: admin / admin123");
        }
    }
}
