package com.reservation.reservation_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해
                .allowedOrigins("http://localhost:3000") // 프론트 도메인
                .allowedMethods("*") // GET, POST, PUT 등 전부 허용
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
