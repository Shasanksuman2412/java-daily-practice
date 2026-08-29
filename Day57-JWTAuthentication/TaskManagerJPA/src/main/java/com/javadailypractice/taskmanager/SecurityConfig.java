package com.javadailypractice.taskmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ---- Exposes an AuthenticationManager so AuthController can verify login credentials ----
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
                                                          PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return new org.springframework.security.authentication.ProviderManager(provider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            // STATELESS: no server-side session storage at all - every
            // request must carry its own valid token, nothing is remembered
            // between requests like Day 55's httpBasic implicitly allowed.
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/auth/register", "/auth/login").permitAll() // no token needed to register or log in

                .requestMatchers(HttpMethod.GET, "/tasks/**", "/projects/**").authenticated()
                .requestMatchers(HttpMethod.POST, "/tasks/**", "/projects/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/tasks/**", "/projects/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/tasks/**", "/projects/**").hasRole("ADMIN")

                .anyRequest().authenticated()
            )
            // insert our custom filter BEFORE Spring's default username/password
            // filter, so the token gets checked first on every request
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    }
}
