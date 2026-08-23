package com.javadailypractice.taskmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // NOTE: no UserDetailsService bean here anymore! CustomUserDetailsService
    // is already annotated @Service, so Spring Security automatically finds
    // and uses it as the ONE UserDetailsService in the application context -
    // no manual wiring needed.

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/auth/register").permitAll() // anyone can register, no login needed

                .requestMatchers(HttpMethod.GET, "/tasks/**", "/projects/**").authenticated()
                .requestMatchers(HttpMethod.POST, "/tasks/**", "/projects/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/tasks/**", "/projects/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/tasks/**", "/projects/**").hasRole("ADMIN")

                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    }
}
