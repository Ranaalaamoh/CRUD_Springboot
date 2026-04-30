package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PaginationConfig {

    @Bean
    public PageableHandlerMethodArgumentResolverCustomizer customizePagination() {
        return resolver -> {
            resolver.setOneIndexedParameters(false); 
        };
    }
}