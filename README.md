# ProjectManager

> 팀 프로젝트의 **프로젝트 · 업무 · 팀원 · 작업 결과 · 질문/공지**를 관리하기 위한 프로젝트 관리 웹 애플리케이션

현재 **Spring Boot + Oracle** 기반으로 백엔드를 개발하고 있으며, 이후 **React**를 프론트엔드로 연동할 예정입니다.

---

## 📌 프로젝트 개요

| 항목 | 내용 |
|---|---|
| 프로젝트명 | **ProjectManager** |
| 목적 | 팀 프로젝트의 업무와 팀원을 효율적으로 관리 |
| Backend | Java, Spring Boot, Spring Data JPA, Hibernate, Spring Security |
| Database | Oracle Database |
| Frontend | React **(예정)** |
| API 테스트 | Postman |
| 개발 환경 | IntelliJ IDEA, Oracle SQL Developer |
| 형상관리 | Git / GitHub |

### 👥 사용자 역할

| 역할 | 담당 기능 |
|---|---|
| **Leader** | 프로젝트 관리, 팀원 관리, 업무 관리, 공지 작성, 질문 확인 및 댓글 |
| **Member** | 참여 프로젝트 조회, 담당 업무 조회, 업무 상태 변경, 작업 결과 작성, 질문 작성 |

### ⚙️ 주요 기능

| 기능 | 내용 |
|---|---|
| 프로젝트 관리 | 프로젝트 생성 / 조회 / 삭제 |
| 팀원 관리 | 팀원 등록 / 조회 / 삭제 / 역할 관리 |
| 업무 관리 | 업무 생성, 담당자 지정, 기간 관리 |
| 업무 상태 | 미진행 / 진행중 / 완료 |
| 작업 결과 | 구현 내용 및 작업 결과 작성 |
| 피드백 | 팀장 댓글 및 피드백 |
| 질문 게시판 | 질문 작성, 조회, 댓글 |
| 공지사항 | 팀장 공지 작성 |
| 권한 관리 | 역할에 따른 접근 권한 관리 |
| 프론트엔드 | React 연동 예정 |

---

## 📅 프로젝트 진행현황

개발 과정을 날짜별로 기록합니다.

| 날짜 | 진행 내용 |
|---|---|
| **2026-09-19** | [회원 Entity / Repository / Service / Controller 구현 및 Oracle 연동](./docs/processing/2026-09-19.md) |
| **2026-09-20** | 진행 내용 작성 예정 |
| **2026-09-21** | 진행 내용 작성 예정 |
| **...** | 새로운 개발 내용 추가 |

---

## 🛠️ 트러블 슈팅

개발 중 발생한 오류와 해결 과정을 날짜별로 기록합니다.

| 날짜 | 주요 내용 |
|---|---|
| **2026-09-19** | [8080 포트 충돌, Oracle MEMBER 객체 중복, loginId 필드명 오류, ORA-01400, Spring Security 401/403](./docs/troubleshooting/2026-09-19.md) |
| **2026-09-20** | 트러블슈팅 내용 작성 예정 |
| **2026-09-21** | 트러블슈팅 내용 작성 예정 |
| **...** | 새로운 트러블슈팅 추가 |

---

## 🗂️ 프로젝트 구조

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

## 🔄 데이터 처리 흐름

```text
React / Client
      ↓
Controller
      ↓
Service
      ↓
Repository
      ↓
Spring Data JPA
      ↓
Hibernate
      ↓
JDBC
      ↓
Oracle Database
```

---

## 📝 개발 문서 작성 규칙

| 폴더 | 용도 |
|---|---|
| `docs/processing` | 날짜별 프로젝트 진행 내용 기록 |
| `docs/troubleshooting` | 날짜별 오류 및 해결 과정 기록 |

> 새로운 개발일마다 날짜 형식의 Markdown 파일을 추가하고 README의 해당 표에 링크를 연결합니다.
