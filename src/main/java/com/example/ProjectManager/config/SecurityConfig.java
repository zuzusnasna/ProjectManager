package com.example.ProjectManager.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration // spring의 설정 클래스
@EnableWebSecurity //웹 보안기능 활성화
public class SecurityConfig {

    @Bean //이 메서드에서 만들어지는 객체를 Spring이 관리하게 해줌
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        //SecurityFilterChain HTTP 요청을 검사하는 보안 규칙 묶음

        http
                // POST 요청을 테스트하기 위해 CSRF 비활성화
                .csrf(csrf -> csrf.disable())

                // URL별 접근 권한 설정
                .authorizeHttpRequests(auth -> auth

                        // 회원가입은 로그인하지 않아도 접근 가능
                        .requestMatchers("/members").permitAll()

                        // 나머지 요청은 로그인 필요
                        .anyRequest().authenticated()
                );

        return http.build();
    }

}
