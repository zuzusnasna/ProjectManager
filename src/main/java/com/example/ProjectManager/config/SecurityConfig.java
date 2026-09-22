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
@EnableWebSecurity // Spring Security의 웹 보안 기능을 활성화한다.
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        // 비밀번호를 BCrypt 방식으로 암호화하는 객체를 Spring Bean으로 등록한다.
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // SecurityFilterChain은 HTTP 요청에 대한 보안 규칙을 설정한다.
        http
                // REST API 테스트를 위해 CSRF를 비활성화한다.
                .csrf(csrf -> csrf.disable())

                // URL별 접근 권한을 설정한다.
                .authorizeHttpRequests(auth -> auth

                        // PUT 방식의 회원 수정은 Leader 권한을 가진 사용자만 허용한다.
                        .requestMatchers(HttpMethod.PUT, "/members/**")
                        .hasRole("Leader")

                        // 그 외 회원 API는 현재 테스트 단계에서 허용한다.
                        .requestMatchers("/members", "/members/**")
                        .permitAll()

                        // 나머지 API는 인증된 사용자만 접근할 수 있다.
                        .anyRequest().authenticated()
                )

                // Postman에서 loginId / password를 Basic Auth로 전달할 수 있도록 한다.
                .httpBasic(Customizer.withDefaults());

        // 설정한 보안 규칙을 Spring Security에 등록한다.
        return http.build();
    }
}
