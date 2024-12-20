package com.example.seminar5.config;

import com.example.seminar5.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalOauth2UserService principalOauth2UserService;
    private final CorsConfig coresConfig;

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http, CorsConfig corsConfig) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.addFilter(corsConfig.corsFilter());
        http.authorizeHttpRequests(au->au.anyRequest().permitAll());
        http.oauth2Login(oauth -> oauth.loginPage("/loginForm").defaultSuccessUrl("/home").userInfoEndpoint(userInfo->userInfo.userService(principalOauth2UserService)));
        return http.build();
    }
}
