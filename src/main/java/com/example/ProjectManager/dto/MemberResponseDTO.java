package com.example.ProjectManager.dto;

import com.example.ProjectManager.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class MemberResponseDTO {
    // 회원의 DB ID
    private Long id;

    // 로그인에 사용하는 아이디
    private String loginId;

    // 회원 이름
    private String name;

    // 회원 권한
    private Role role;


}
