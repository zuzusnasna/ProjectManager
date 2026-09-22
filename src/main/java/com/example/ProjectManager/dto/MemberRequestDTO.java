package com.example.ProjectManager.dto;

import com.example.ProjectManager.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Getter 메서드를 자동으로 생성한다.
@Setter // JSON 요청 데이터를 객체에 저장할 수 있도록 Setter를 자동으로 생성한다.
@NoArgsConstructor // JSON 데이터를 객체로 변환할 때 사용할 기본 생성자를 자동으로 생성한다.
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
