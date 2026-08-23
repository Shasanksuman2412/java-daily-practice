package com.javadailypractice.taskmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // ---- Password encoding: NEVER store plain-text passwords ----
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // one-way hashing, industry standard
    }

    // ---- Defining users: in-memory for learning purposes (a real app uses a database table) ----
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("password123"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    // ---- The actual access rules: who can do what ----
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // simplified for a REST API tested with curl/Postman
            .authorizeHttpRequests(auth -> auth
                // anyone can view the H2 console for learning purposes today
                .requestMatchers("/h2-console/**").permitAll()

                // any authenticated user (USER or ADMIN) can READ
                .requestMatchers(HttpMethod.GET, "/tasks/**", "/projects/**").authenticated()

                // only ADMIN can CREATE, UPDATE, or DELETE
                .requestMatchers(HttpMethod.POST, "/tasks/**", "/projects/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/tasks/**", "/projects/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/tasks/**", "/projects/**").hasRole("ADMIN")

                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults()) // simple username:password auth via curl -u
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())); // needed for H2 console UI

        return http.build();
    }
}
