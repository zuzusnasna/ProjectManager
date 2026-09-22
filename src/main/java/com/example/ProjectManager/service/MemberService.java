package com.example.ProjectManager.service;

import com.example.ProjectManager.entity.Member;
import com.example.ProjectManager.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Controller -> MemberService -> MemberRepository -> Oracle

@Service // 비즈니스 로직을 담당하는 Service 객체임을 어노테이션으로 선언
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // MemberService가 생성될 때 필요한 객체를 전달받는다.
    // 생성자 주입을 통해 Service에서 Repository와 PasswordEncoder를 사용할 수 있게 된다.
    public MemberService(MemberRepository memberRepository,
                         PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원 정보를 DB에 저장하는 메서드
    public Member saveMember(Member member) {

        // 회원가입 시 입력받은 평문 비밀번호를 BCrypt 방식으로 암호화한다.
        member.setPassword(
                passwordEncoder.encode(member.getPassword())
        );

        // 암호화된 회원 정보를 Repository에 전달해 DB에 저장한다.
        return memberRepository.save(member);
    }

    // DB에 저장된 모든 회원을 조회한다.
    public List<Member> getMembers() {

        // Repository의 findAll()을 사용하여 모든 회원을 조회한다.
        return memberRepository.findAll();
    }

    // ID를 이용하여 특정 회원 한 명을 조회한다.
    public Optional<Member> getMember(Long id) {

        // 전달받은 ID와 일치하는 회원을 Repository에서 조회한다.
        return memberRepository.findById(id);
    }

    // 특정 회원의 정보를 수정한다.
    public Member updateMember(Long id, Member updateMember) {

        // 수정할 회원이 실제로 존재하는지 조회한다.
        Member member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("회원을 찾을 수 없습니다."));

        // 로그인 ID를 수정한다.
        member.setLoginId(updateMember.getLoginId());

        // 새로운 비밀번호를 BCrypt로 암호화한 후 수정한다.
        member.setPassword(
                passwordEncoder.encode(updateMember.getPassword())
        );

        // 이름을 수정한다.
        member.setName(updateMember.getName());

        // 권한을 수정한다.
        member.setRole(updateMember.getRole());

        // 수정된 회원 정보를 DB에 저장한다.
        return memberRepository.save(member);
    }

    // 컨트롤러 -> Service -> Repository -> JPA -> Hibernate -> JDBC -> Oracle
}
