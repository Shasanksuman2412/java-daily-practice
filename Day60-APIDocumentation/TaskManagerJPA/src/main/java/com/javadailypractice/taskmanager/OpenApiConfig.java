package com.javadailypractice.taskmanager;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Task Manager API")
                        .version("1.0")
                        .description("A REST API for managing tasks and projects, " +
                                "built incrementally across Days 49-60 of daily Java practice. " +
                                "Covers CRUD, validation, relationships, DTOs, JWT security, " +
                                "testing, and pagination.")
                        .contact(new Contact()
                                .name("Java Daily Practice")
                                .email("example@example.com")))
                // Tells Swagger UI HOW to authenticate - this is what makes
                // the "Authorize" button appear, letting you paste a JWT
                // once and have it applied to every "Try it out" call.
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
