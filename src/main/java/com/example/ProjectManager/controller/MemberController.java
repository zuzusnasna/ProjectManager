package com.example.ProjectManager.controller;

import com.example.ProjectManager.entity.Member;
import com.example.ProjectManager.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //HTTP요청을 처리하는 컨트롤러
@RequestMapping("/members") //기본 URL을 /members 로 지정
public class MemberController {

    //서비스로의 전달 객체
    public final MemberService memberService;

    //Spring이 MemberService를 자동으로 넣어준다 -> 생성자 의존성 주입
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //회원 등록
    @PostMapping //HTTP POST요청을 받는다
    public Member saveMember(@RequestBody Member member){// HTTP요청의 JSON데이터를 객체로 변환해서 받음
        return memberService.saveMember(member);
    }

    //회원 조회
    @GetMapping
    public List<Member> getMembers(){

        //Service에 회원 전체 조회를 요청한다.
        return memberService.getMember();
    }
}
