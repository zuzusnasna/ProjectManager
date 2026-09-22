package com.example.ProjectManager.service;

import com.example.ProjectManager.dto.MemberRequestDTO;
import com.example.ProjectManager.dto.MemberResponseDTO;
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
    // 생성자 주입을 통해 Repository와 PasswordEncoder를 사용할 수 있게 된다.
    public MemberService(MemberRepository memberRepository,
                         PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원 정보를 DB에 저장한다.
    public MemberResponseDTO saveMember(MemberRequestDTO requestDTO) {

        // Request DTO의 데이터를 Member Entity로 변환한다.
        Member member = new Member();

        // 로그인 ID를 저장한다.
        member.setLoginId(requestDTO.getLoginId());

        // 입력받은 평문 비밀번호를 BCrypt 방식으로 암호화한다.
        member.setPassword(
                passwordEncoder.encode(requestDTO.getPassword())
        );

        // 회원 이름을 저장한다.
        member.setName(requestDTO.getName());

        // 회원 권한을 저장한다.
        member.setRole(requestDTO.getRole());

        // Entity를 DB에 저장한다.
        Member savedMember = memberRepository.save(member);

        // 저장된 Entity를 응답용 DTO로 변환한다.
        return toResponseDTO(savedMember);
    }

    // DB에 저장된 모든 회원을 조회한다.
    public List<MemberResponseDTO> getMembers() {

        // Repository의 findAll()을 사용하여 모든 회원을 조회한다.
        return memberRepository.findAll()
                .stream()
                // 조회한 Entity를 각각 응답용 DTO로 변환한다.
                .map(this::toResponseDTO)
                .toList();
    }

    // ID를 이용하여 특정 회원 한 명을 조회한다.
    public Optional<MemberResponseDTO> getMember(Long id) {

        // 전달받은 ID와 일치하는 회원을 Repository에서 조회한다.
        return memberRepository.findById(id)
                // 조회한 Entity를 응답용 DTO로 변환한다.
                .map(this::toResponseDTO);
    }

    // 특정 회원의 정보를 수정한다.
    public MemberResponseDTO updateMember(Long id, MemberRequestDTO requestDTO) {

        // 수정할 회원이 실제로 존재하는지 조회한다.
        Member member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("회원을 찾을 수 없습니다."));

        // 로그인 ID를 수정한다.
        member.setLoginId(requestDTO.getLoginId());

        // 새로운 비밀번호를 BCrypt로 암호화한 후 수정한다.
        member.setPassword(
                passwordEncoder.encode(requestDTO.getPassword())
        );

        // 이름을 수정한다.
        member.setName(requestDTO.getName());

        // 권한을 수정한다.
        member.setRole(requestDTO.getRole());

        // 수정된 회원 정보를 DB에 저장한다.
        Member updatedMember = memberRepository.save(member);

        // 수정된 Entity를 응답용 DTO로 변환한다.
        return toResponseDTO(updatedMember);
    }

    // 특정 회원을 삭제한다.
    public void deleteMember(Long id) {

        // 먼저 삭제할 회원이 존재하는지 확인한다.
        Member member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("회원을 찾을 수 없습니다."));

        // 존재하는 회원을 삭제한다.
        memberRepository.delete(member);
    }

    // Member Entity를 MemberResponseDTO로 변환한다.
    private MemberResponseDTO toResponseDTO(Member member) {

        // 비밀번호는 제외하고 필요한 정보만 DTO에 담는다.
        return new MemberResponseDTO(
                member.getId(),
                member.getLoginId(),
                member.getName(),
                member.getRole()
        );
    }
}
