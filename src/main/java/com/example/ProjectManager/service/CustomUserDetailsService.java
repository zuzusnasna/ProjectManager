package com.example.ProjectManager.service;

import com.example.ProjectManager.entity.Member;
import com.example.ProjectManager.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // Spring이 이 클래스를 Service 객체로 관리한다.
public class CustomUserDetailsService implements UserDetailsService {

    // DB에서 회원을 조회하기 위한 Repository
    private final MemberRepository memberRepository;

    // 생성자 주입으로 Repository를 받는다.
    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 로그인할 때 전달받은 아이디로 DB에서 회원을 찾는다.
    @Override
    public UserDetails loadUserByUsername(String loginId) {

        // loginId와 일치하는 회원을 찾는다.
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("회원을 찾을 수 없습니다."));

        // 찾은 회원 정보를 Spring Security가 사용할 UserDetails로 변환한다.
        return User.builder()
                .username(member.getLoginId())
                .password(member.getPassword())
                .roles(member.getRole().name())
                .build();
    }
}
