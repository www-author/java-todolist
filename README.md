# :sparkles: :white_check_mark: 투두 리스트 :sparkles:

--- 

## :dart: 프로젝트 목표

데이터 접근 기술 중 하나인 JDBC API를 이용한 순수 자바 콘솔 프로그램을 구현한다. <br>
:heavy_check_mark: 이를 통해, 기본적인 SQL 작성, API 연결 과정을 익히고, <br>
:heavy_check_mark: SQL 종속적인 데이터 접근 기술의 한계에 대하여 알아보고자 한다. <br>
:heavy_check_mark: 또한, Spring 프레임워크 없이 순수 자바 콘솔로 mvc 패턴을 구현하는 과정을 체험한다.

---
## :memo: 요구사항 분석 및 설계

## 시퀀스 다이어그램

### 회원 가입
```mermaid
sequenceDiagram
    actor Users
    participant View
    participant Controller
    participant Service
    participant DAO
    participant DB
    Users ->> View: 메뉴 선택 (회원가입)
    View ->> Users: 회원가입 정보 입력 요청
    Users ->> View: 회원 가입 정보 입력 (Usersname, email, pw)
    View ->> Controller: 회원가입 요청 (입력 정보 전달)
    Controller ->> Service: 회원가입 처리 요청
    Service ->> DAO: 가입된 회원 여부를 위한 정보 조회 (이메일 정보 전달)
    DAO ->> Service : 회원 정보 반환
    alt 존재하지 않는 회원일 경우
        Service ->> DAO : 회원 정보 저장 요청
        DAO ->> DB: 회원 데이터 저장
        DB -->> DAO: 데이터 저장 성공 여부 반환
        DAO -->> Service: 데이터 저장 완료 응답
        Service -->> Controller: 회원가입 성공 응답
        Controller ->> View: 회원가입 성공 화면 출력 요청
        View ->> Users: 회원가입 완료 메시지 출력
    else 이미 존재하는 회원일 경우
        Service -->> Controller: 중복 회원 에러 메시지 전달
        Controller ->> View: 중복 회원 에러 메시지 출력 요청
        View ->> Users: 중복 회원 에러 메시지 출력
    end
```

### 로그인

```mermaid
sequenceDiagram
    actor Users
    Users ->>View: 로그인 메뉴 선택
    View ->> Users : 로그인 정보 요청 (ID,PW)
    Users ->> View: 로그인 정보 입력
    View ->> Controller: 로그인 요청 전달 (로그인 정보 전달)
    Controller->>Service: 로그인 정보 전달
    Service->>DAO: 이메일을 통한 회원 정보 조회
    DAO ->> DB : 회원 정보 조회 요청 
    DB ->> DAO : 회원 정보 전달   
    DAO ->> Service: 회원 정보 반환
    alt 회원 정보가 있는 경우 
	  Service ->> Domain : PW 일치 여부 요청
	  Domain ->> Service : PW 일치 여부 응답 
		Service->> Controller: 로그인 결과 반환
		Controller ->> View : 메인 화면 출력 요청 및 로그인 정보 전달  
		View ->> Users : 메인 화면 출력 
    else 회원 정보가 존재하지 않는 경우 
    Service ->> Controller : 에러 메시지 전달 (존재하지 않는 회원)
    Controller ->> View : 에러 메시지 출력 요청 
    end 
```
### 투두 리스트

> 투두 리스트 목록 조회, 완료 여부 상태 변경, 삭제 기능

### 투두리스트 완료 여부 상태 변경

### 투두리스트 삭제




## ERD


## ERD

```mermaid
erDiagram
user ||--o{ todo_list : has

user {
    int user_id PK
    varchar(100) name
    varchar(255) password
    varchar(255) email
    timestamp created_at
    timestamp updated_at
    tinyint is_deleted
}

todo_list {
    int todo_list_id PK
    text content
    tinyint is_completed
    int user_id FK
    timestamp created_at
    timestamp updated
}
```


## :computer: :art:  화면 (UI/UX) 설계

|                           최초 화면                           |                              
|:---------------------------------------------------------:|
| <img src="./src/main/resources/img/root.png" width="300"> |
| <img src="./src/main/resources/img/exit.png" width="300"> |

<br>

|회원 가입|
|:----------:|
| <img src="./src/main/resources/img/signup.png" width="300"> | 

<br>

|                            로그인                             |
|:----------------------------------------------------------:|
| <img src="./src/main/resources/img/login.png" width="300"> |

<br>

|                      투두 리스트 화면 (메인 화면)                       |
|:------------------------------------------------------------:|
| <img src="./src/main/resources/img/main.png" width="300">  |
| <img src="./src/main/resources/img/mark.png" width="300">  |
| <img src="./src/main/resources/img/delete.png" width="300">  |
| <img src="./src/main/resources/img/logout.png" width="300">  |



 
