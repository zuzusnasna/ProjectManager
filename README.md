# ProjectManager

팀 프로젝트의 프로젝트, 업무(Task), 팀원, 작업 결과, 질문/공지사항을 관리하기 위한 **프로젝트 관리 웹 애플리케이션**입니다.

현재는 **Spring Boot + Oracle**을 기반으로 백엔드 기능을 구현하고 있으며, 이후 **React**를 프론트엔드로 연결할 예정입니다.

## 프로젝트 개요

ProjectManager는 팀장과 팀원이 역할에 따라 프로젝트와 업무를 관리할 수 있도록 만드는 것을 목표로 합니다.

### 주요 사용자

| 역할 | 주요 기능 |
|---|---|
| `Leader` | 프로젝트 관리, 팀원 관리, 업무 관리, 공지 작성, 질문 확인 및 댓글 작성 |
| `Member` | 참여 프로젝트 조회, 담당 업무 조회, 업무 상태 변경, 작업 결과 작성, 질문 작성 |

## 주요 기능

### 프로젝트 관리
- 프로젝트 생성
- 프로젝트 조회
- 프로젝트 삭제
- 프로젝트 기간 관리

### 업무(Task) 관리
- 업무명 및 설명 관리
- 업무 시작일 / 종료일 관리
- 업무 담당 팀원 지정
- 업무 상태 관리
  - 미진행
  - 진행중
  - 완료

### 팀원 관리
- 팀원 등록
- 팀원 조회
- 팀원 삭제
- 역할 구분

### 작업 결과 / 피드백
- 팀원의 구현 내용 및 작업 결과 작성
- 팀장의 댓글 / 피드백 작성

### 질문 게시판
- 팀장 공지 작성
- 팀원 질문 작성
- 질문 및 답변 조회
- 댓글 작성 및 삭제

## 기술 스택

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Spring Security
- Lombok

### Database
- Oracle Database
- Oracle JDBC Driver

### Frontend
- React *(예정)*

### Tools
- IntelliJ IDEA
- Git / GitHub
- Postman
- Oracle SQL Developer

## 현재 구현 상태

현재 백엔드의 **회원 기능 기본 구조**를 구현했습니다.

### 회원 Entity
- `id`
- `loginId`
- `password`
- `name`
- `role`

### 현재 구조

```text
src/main/java/com/example/ProjectManager
├── controller
│   └── MemberController.java
├── service
│   └── MemberService.java
├── repository
│   └── MemberRepository.java
├── entity
│   ├── Member.java
│   └── Role.java
├── config
│   └── SecurityConfig.java
└── DemoApplication.java
```

### 회원 API

#### 회원 등록
```http
POST /members
```

요청 예시:

```json
{
  "loginId": "leader01",
  "password": "1111",
  "name": "팀장",
  "role": "Leader"
}
```

#### 회원 전체 조회
```http
GET /members
```

현재 회원 등록 및 조회 API를 Postman으로 테스트하고 있으며, Oracle `MEMBER` 테이블과 연동되어 있습니다.

## 데이터 흐름

```text
Client / React
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

## 보안

현재 Spring Security를 적용했으며, 개발 단계에서 회원 API를 테스트할 수 있도록 접근 권한을 설정했습니다.

회원가입 API:

```text
POST /members
→ 누구나 접근 가능
```

그 외 API는 추후 로그인 및 역할 기반 권한 관리에 맞춰 세분화할 예정입니다.

## 개발 문서

개발 과정에서 발생한 문제와 진행 상황은 `docs` 아래에 날짜별로 기록합니다.

- [진행 상황](./docs/processing)
- [트러블슈팅](./docs/troubleshooting)

## 향후 개발 계획

1. 회원 조회 / 상세 조회 / 삭제 기능 정리
2. 회원가입 및 로그인 구현
3. 역할 기반 권한 관리
4. 프로젝트 CRUD 구현
5. 프로젝트별 팀원 관리
6. 업무(Task) 및 일정 관리
7. 작업 결과 게시판 및 피드백 기능
8. 질문 / 공지 게시판 구현
9. React 프론트엔드 구축
10. React ↔ Spring Boot REST API 연동
11. 테스트 코드 작성 및 기능 정리

## 목표

Spring Boot, JPA, Oracle, Spring Security, React를 활용하여 **실제 팀 프로젝트에서 사용할 수 있는 프로젝트 관리 시스템**을 직접 설계하고 구현하는 것을 목표로 합니다.
