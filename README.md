# ProjectManager

팀 프로젝트의 프로젝트, 업무(Task), 팀원, 작업 결과, 질문/공지사항을 관리하기 위한 **프로젝트 관리 웹 애플리케이션**입니다.

현재는 **Spring Boot + Oracle**을 기반으로 백엔드 기능을 구현하고 있으며, 이후 **React**를 프론트엔드로 연결할 예정입니다.

---

## 프로젝트 개요

ProjectManager는 팀장과 팀원이 역할에 따라 프로젝트와 업무를 관리할 수 있도록 만드는 것을 목표로 합니다.

### 역할

| 역할 | 주요 기능 |
|---|---|
| `Leader` | 프로젝트 관리, 팀원 관리, 업무 관리, 공지 작성, 질문 확인 및 댓글 작성 |
| `Member` | 참여 프로젝트 조회, 담당 업무 조회, 업무 상태 변경, 작업 결과 작성, 질문 작성 |

### 예정 기능

- 프로젝트 생성 / 조회 / 삭제
- 프로젝트별 팀원 관리
- 업무(Task) 생성 및 담당자 지정
- 업무 기간 관리
- 업무 상태 변경
- 작업 결과 작성
- 팀장 피드백 및 댓글
- 질문 게시판
- 공지사항
- 역할 기반 권한 관리
- React 프론트엔드 연동

### 기술 스택

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Security
- Oracle Database
- React (예정)
- Git / GitHub
- Postman
- IntelliJ IDEA
- Oracle SQL Developer

---

## 프로젝트 진행현황

개발 과정을 날짜별로 기록합니다.

### 2026-09-19

[진행 내용 보기](./docs/processing/2026-09-19.md)

- Spring Boot 프로젝트 기본 구조 구성
- Oracle DB 연결
- Member Entity 구현
- Role Enum 구현
- MemberRepository 구현
- MemberService 구현
- MemberController 구현
- 회원 등록 API 구현
- 회원 전체 조회 API 구현
- Spring Security 기본 설정
- Postman을 이용한 회원 등록 / 조회 테스트

### 2026-09-20

진행 내용 작성 예정

---

## 트러블 슈팅

개발 중 발생한 오류와 해결 과정을 날짜별로 기록합니다.

### 2026-09-19

[트러블슈팅 내용 보기](./docs/troubleshooting/2026-09-19.md)

- Spring Boot 실행 시 8080 포트 충돌
- Oracle `MEMBER` 객체 중복 오류
- `longId` / `loginId` 필드명 불일치
- Oracle `ORA-01400` 오류
- Spring Security 401 / 403 응답 확인

### 2026-09-20

트러블슈팅 내용 작성 예정

---

## 프로젝트 구조

```text
ProjectManager
├── src
│   └── main
│       ├── java
│       │   └── com.example.ProjectManager
│       │       ├── controller
│       │       ├── service
│       │       ├── repository
│       │       ├── entity
│       │       └── config
│       └── resources
│
└── docs
    ├── processing
    │   └── 날짜별 진행 기록
    └── troubleshooting
        └── 날짜별 트러블슈팅 기록
```

---

## 개발 문서 규칙

- `docs/processing` : 날짜별 프로젝트 진행 내용을 기록
- `docs/troubleshooting` : 날짜별 오류 및 해결 과정을 기록
- 새로운 개발일마다 해당 날짜의 Markdown 파일을 추가
- README의 날짜 목록에도 해당 문서를 연결

