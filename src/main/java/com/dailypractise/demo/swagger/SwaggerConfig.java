package com.dailypractise.demo.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot CRUD API Practise",
                description = "Spring Boot demo project for CRUD operations",
                summary = "This API will perform CRUD operations on MySQL DB",
                termsOfService = "T&C",
                contact = @Contact(
                        name = "DailyPractise",
                        email = "dailypractise@test.com"
                ),
                license = @License(
                        name = "Test License"
                ),
                version = "v1"
        ),
        servers = {
                @Server(
                        description = "Dev",
                        url = "http://localhost:9111"
                ),
                @Server(
                        description = "Test",
                        url = "http://localhost:9111"
                )
        }

)
public class SwaggerConfig {

    /**
     * Swagger URL :- http://localhost:9111/swagger-ui/index.html
     */
}
