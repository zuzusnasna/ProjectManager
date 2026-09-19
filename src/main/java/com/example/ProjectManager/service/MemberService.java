package com.example.ProjectManager.service;

import com.example.ProjectManager.entity.Member;
import com.example.ProjectManager.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Controller -> MemberService -> MemberRepository -> Oracle

@Service // 비즈니스 로직을 담당하는 Service 객체임을 어노테이션으로 선언
public class MemberService {
    private final MemberRepository memberRepository;

    //MemberService가 생성될 때 MemberRepository를 전달 받는다
    //생성자 주입을 통해 Service에서 Repository를 사용할 수 있게 된다.
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원 정보를 DB에 저장하는 메서드
    public Member saveMember(Member member){

        //member 객체를 MemberRepository에 전달해 DB 저장을 요청한다.
        return memberRepository.save(member);
    }

    //DB에 저장된 모든 회원을 조회한다.
    public List<Member> getMember(){

        //Repository의 findAll()을 사용하여 모든회원을 조회한다.
        return memberRepository.findAll();
    }
    //컨트롤러 -> saveMember(member) -> JPA -> Hibernate -> JDBC -> Oracle
}
