package com.example.project.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "3Tier",
                description = "3Tier 프로젝트에 대한 API 명세서",
                version = "1.0.0"
        )
)
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        String[] packages = {"com.example.project"};
        return GroupedOpenApi.builder()
                .group("default")
                .packagesToScan(packages)
                .build();
    }
}