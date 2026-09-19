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

### 주요 기능

- 프로젝트 관리
- 프로젝트별 팀원 관리
- 업무(Task) 및 일정 관리
- 업무 담당자 지정
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

개발 과정을 날짜별 목차로 정리합니다.

### 2026-09

- [09-19](./docs/processing/2026-09-19.md)
- 09-20
- 09-21
- ...

---

## 트러블 슈팅

개발 중 발생한 오류와 해결 과정을 날짜별 목차로 정리합니다.

### 2026-09

- [09-19](./docs/troubleshooting/2026-09-19.md)
- 09-20
- 09-21
- ...

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
- README의 날짜 목차에 해당 문서를 연결
