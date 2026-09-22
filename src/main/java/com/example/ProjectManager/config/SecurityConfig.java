package com.example.ProjectManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Spring의 설정 클래스
@EnableWebSecurity // Spring Security 활성화
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        // 비밀번호를 BCrypt 방식으로 암호화한다.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                // REST API 테스트를 위해 CSRF를 비활성화한다.
                .csrf(csrf -> csrf.disable())

                // 요청별 접근 권한을 설정한다.
                .authorizeHttpRequests(auth -> auth

                        // 회원가입은 인증 없이 허용한다.
                        .requestMatchers(HttpMethod.POST, "/members")
                        .permitAll()

                        // 회원 조회는 인증 없이 허용한다.
                        .requestMatchers(
                                HttpMethod.GET,
                                "/members",
                                "/members/**"
                        )
                        .permitAll()

                        // 회원 수정은 Leader만 허용한다.
                        .requestMatchers(HttpMethod.PUT, "/members/**")
                        .hasRole("Leader")

                        // 회원 삭제도 Leader만 가능하다.
                        .requestMatchers(HttpMethod.DELETE, "/members/**")
                        .hasRole("Leader")

                        // 그 외 요청은 인증이 필요하다.
                        .anyRequest().authenticated()
                )

                // Basic Auth를 사용하여 아이디와 비밀번호를 인증한다.
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}