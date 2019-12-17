package com.fmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CORSConfig {

    public CORSConfig() {}

    @Bean
    public CorsFilter corsFilter() {
        System.out.println("-------------------> Cors filter start");
        // 1. 添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:9999");

        // 2. 设置请求相关信息
        config.setAllowCredentials(true);

        // 3. 设置允许请求的方式
        config.addAllowedMethod("*");

        // 4. 设置请求header
        config.addAllowedHeader("*");

        // 5. 添加路径映射
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(corsConfigurationSource);
    }
}
