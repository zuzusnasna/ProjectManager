package com.example.ProjectManager.controller;

import com.example.ProjectManager.dto.MemberResponseDTO;
import com.example.ProjectManager.entity.Member;
import com.example.ProjectManager.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // HTTP 요청을 처리하는 Controller
@RequestMapping("/members") // 기본 URL을 /members로 지정
public class MemberController {

    // 회원 관련 비즈니스 로직을 처리하는 Service 객체
    private final MemberService memberService;

    // 생성자 주입을 통해 Spring이 MemberService 객체를 넣어준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 등록
    // POST /members 요청이 들어오면 실행된다.
    @PostMapping
    public MemberResponseDTO saveMember(@RequestBody Member member) {

        // JSON으로 전달받은 회원 정보를 Service에 전달한다.
        return memberService.saveMember(member);
    }

    // 회원 전체 조회
    // GET /members 요청이 들어오면 실행된다.
    @GetMapping
    public List<MemberResponseDTO> getMembers() {

        // Service에서 DTO 목록을 받아 반환한다.
        return memberService.getMembers();
    }

    // 회원 한 명 조회
    // GET /members/{id} 요청이 들어오면 실행된다.
    @GetMapping("/{id}")
    public Optional<MemberResponseDTO> getMember(@PathVariable Long id) {

        // URL에서 받은 id를 Service에 전달한다.
        return memberService.getMember(id);
    }

    // 회원 수정
    // PUT /members/{id} 요청이 들어오면 실행된다.
    @PutMapping("/{id}")
    public MemberResponseDTO updateMember(
            @PathVariable Long id,
            @RequestBody Member member) {

        // URL의 id와 수정할 회원 정보를 Service에 전달한다.
        return memberService.updateMember(id, member);
    }

    // 회원 삭제
    // DELETE /members/{id} 요청이 들어오면 실행된다.
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {

        // Service에 회원 삭제를 요청한다.
        memberService.deleteMember(id);
    }
}
