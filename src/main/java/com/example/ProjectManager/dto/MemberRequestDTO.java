package com.example.ProjectManager.dto;

import com.example.ProjectManager.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequestDTO {

    // 로그인에 사용할 아이디
    private String loginId;

    // 회원 비밀번호
    private String password;

    // 회원 이름
    private String name;

    // 회원 권한
    private Role role;
}
