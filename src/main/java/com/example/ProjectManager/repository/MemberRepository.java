package com.example.ProjectManager.repository;

import com.example.ProjectManager.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// Controller -> MemberService -> MemberRepository -> Oracle

public interface MemberRepository extends JpaRepository<Member, Long> {
    //JpaRepository는 DB에 데이터를 저장, 조회, 수정, 삭제할 수 있는 기능을
    // 기본으로 제공하는 Spring Data JPA 인터페이스

    //Member -> 어떤 Entity를 관리할 지
    //Long -> Member의 PK(id) 타입
}
