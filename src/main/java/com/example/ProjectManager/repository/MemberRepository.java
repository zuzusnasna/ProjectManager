package com.example.ProjectManager.repository;

import com.example.ProjectManager.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Controller -> MemberService -> MemberRepository -> Oracle

public interface MemberRepository extends JpaRepository<Member, Long> {
    //JpaRepository는 DB에 데이터를 저장, 조회, 수정, 삭제할 수 있는 기능을
    // 기본으로 제공하는 Spring Data JPA 인터페이스

    // loginId로 회원 한 명을 조회한다.
    Optional<Member> findByLoginId(String loginId);
    //Member -> 어떤 Entity를 관리할 지
    //Long -> Member의 PK(id) 타입
}
