package com.example.HW5.config;

import com.example.HW5.PrincipalOauth2UserService;
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
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable); // CSRF 비활성화
        http.addFilter(coresConfig.corsFilter()); // CORS 필터 추가

        // 모든 요청 허용 설정
        http.authorizeHttpRequests(authorize ->
                authorize.anyRequest().permitAll());

        // OAuth2 로그인 설정
        http.oauth2Login(oauth ->
                oauth.loginPage("/loginForm") // 사용자 정의 로그인 페이지
                        .defaultSuccessUrl("/home") // 로그인 성공 시 리디렉션 경로
                        .userInfoEndpoint(userInfo ->
                                userInfo.userService(principalOauth2UserService))); // 사용자 서비스 설정

        return http.build();
    }
}
