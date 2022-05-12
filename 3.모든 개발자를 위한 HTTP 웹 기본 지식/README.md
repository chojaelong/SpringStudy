# 1주차

날짜: 2022년 5월 14일

## 인터넷 네트워크

### 인터넷 통신

### IP(Internet Protocol)

- 지정한 IP주소(IP Address)에 데이터 전달
- 패킷(Packet) 이라는 통신 단위로 데이터 전달
    - Client 패킷을 전달 완료 시 Server 패킷을 Client에게 전달

### IP 프로토콜의 한계

- 비연결성
    - 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송
- 비신뢰성
    - 중간에 패킷이 사라지면?
    - 패킷이 순서대로 안오면?
- 프로그램 구분
    - 같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상이면?

### 인터넷 프로토콜 스택의 4계층

- 애플리케이션 계층 - HTTP, FTP
    - 웹 브라우저, HTTP Client
- 전송 계층 - TCP, UDP
    - OS, TCP 정보 생성
    - 출발지 Port, 목적지 Port, 전송 제어, 순서, 검증 정보, 전송 데이터
- 인터넷 계층 - IP
    - OS, IP 정보 생성
    - 출발지 IP, 목적지 IP 및 기타 데이터 포함 (택배와 비슷)
- 네트워크 인터페이스 계층
    - LAN 드라이버, LAN 장비

![Untitled](1%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20f9afc63466f143379babfd84d5860723/Untitled.png)

### TCP 특징

전송 제어 프로토콜(Transmission Control Protocol)

- 연결지향 - [TCP 3way handshake](https://www.notion.so/1-a29a4818871b4f20a18f51c59b3868b9) (가상 연결)
- 데이터 전달 보증
- 순서 보장
- 신뢰할 수 있는 프로토콜
- 현재는 대부분 TCP 사용

### TCP 3way handshake

1. Client → Server SYN
2. Server → Client SYN + ACK
3. Client → Server ACK

![Untitled](1%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20f9afc63466f143379babfd84d5860723/Untitled%201.png)

<aside>
💡 SYN : 접속 요청
ACK : 요청 수락
참고 : 3.ACK와 함께 데이터 전송 가능

</aside>

### UDP

사용자 데이터그램 프로토콜(User Datagram Protocol)

- 연결지향 x
- 데이터 전달 보증 x
- 순서 보장 x
- 데이터 전달 및 순서가 보장되지 않지만, 단순하고 빠름
- 정리
    - IP와 거의 같다 + Port + 체크섬 정도만 추가
    - 애플리케이션에서 추가 작업 필요

### Port

- 한번에 둘 이상 연결해야 하면?
- 같은 IP내에서 프로세스 구분
    - 게임 : 8090, 화상 통화 : 21000, 웹 브라우저 : 10010
- 0 ~ 65535 할당 가능
- 0 ~ 1023 : 잘 알려진 포트, 사용하지 않는 것이 좋음
    - FTP : 20, 21
    - TELNET - 23
    - HTTP - 80
    - HTTPS - 443

### DNS

도메인 네임 시스템(Domain Name System)

- IP는 기억하기 어렵고, 변경될 수 있다.
- 전화번호부
- 도메인 명을 IP 주소로 변환

URI? URL? URN?

![Untitled](1%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20f9afc63466f143379babfd84d5860723/Untitled%202.png)

### URI

Uniform Resource Identifier

- 자원의 구분, URL과 URN을 포함

### URN

Uniform Resource Name

- 자원의 이름, 잘 쓰이지 않음

### URL

Uniform Resource Locator

- 자원의 위치
- scheme://[userinfo@]host[:port][/path][?query][#fragment]
    - [https://www.google.com:443/search?q=hello&hl=ko](https://www.google.com/search?q=hello&hl=ko)
    - 포트는 생략 가능
    - https는 http에 강력한 보안 적용
    - userinfo@ : URL에 사용자 정보를 포함해서 인증, 거의 사용 안함
    - host : 도메인 명, IP주소 직접 입력 가능
    - path : 리소스 경로(path), 계층적 구조
        - /home,file1.jpg
        - /members
        - /members/100, items/iphone12
    - ?query : key=value 형태
        - 문자 형태
        - ?로 시작, &로 추가 가능
        - ?keyA=valueA&keyB=valueB
    - #fragment
        - html 내부 북마크 등에 사용
        - 서버에 전송하는 정보 아님

### HTTP 기본

### HTTP

HyperText Transfer Protocol

- 모든 것을 HTTP로 전송
    - HTML, Text
    - Image, 음성, 영상, 파일
    - JSON, XML(API)
    - 거의 모든 형태의 데이터 전송 가능
    - 서버간에 데이터를 주고 받을 때도 대부분 HTTP 사용
- 클라이언트 서버 구조
- 무상태 프로토콜, 비연결성
- HTTP 메시지
- 단순함, 확장 가능

### 클라이언트 - 서버 구조

- Request, Responese 구조
- 클라이언트는 서버에 요청을 보내고, 응답을 대기
- 서버가 요청에 대한 결과를 만들어서 응답

### 무상태 프로토콜 (Stateless)

- 서버가 클라이언트 상태를 보존하지 않음
- 상태 유지 : 중간에 다른 점원으로 바뀌면 안된다.
    - 중간에 다른 점원을 바뀔 때 상태 정보를 다른 점원에게 미리 알려줘야 한다.
- 무상태 : 중간에 다른 점원으로 바뀌어도 된다.
    - 갑자기 고객이 증가해도 점원을 대거 투입할 수 있다.
    - 갑자기 클라이언트 요청이 증가해도 서버를 대거 투입할 수 있다.
    - 무상태는 응답 서버를 쉽게 바꿀 수 있다. → 무한한 서버 증설 가능

### 비연결성

- TCP/IP는 연결을 유지하는 모델
    - 서버는 연결을 계속 유지, 서버 자원 소모
- 비연결성은 연결을 유지하지 않음
    - 서버는 연결 유지 X, 최소한의 자원 사용
- HTTP는 기본이 연결을 유지하지 않는 모델
- 한계
    - TCP/IP 연결을 새로 맺어야 함 - 3 way handshake 시간 추가
    - 지금은 HTTP 지속 연결(Persistent Connections)로 문제 해결
        - 한번 연결에 HTML, 자바스크립트, 이미지 등을 한번에 요청 / 응답 후 종료
    - HTTP/2, HTTP/3에 개선됨
- 최대한 비연결성으로 설계, 어쩔 수 없는 경우에만 연결성으로 설계

### HTTP 메시지

- HTTP 요청 메시지와 응답 메시지는 구조가 다름

![Untitled](1%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20f9afc63466f143379babfd84d5860723/Untitled%203.png)

- 시작 라인
    - 요청 메시지
        - method SP(공백) request-target SP HTTP-version CRLF(엔터)
            - GET : 리소스 조회, POST : 요청 내역 처리
    - 응답 메시지
        - HTTP-version SP status-code SP reason-phrase CRLF
            - HTTP 상태 코드 : 요청 성공, 실패를 나타냄
                - 200 : 성공
                - 400 : 클라이언트 요청 오류
                - 500 : 서버 내부 오류
            - 이유 문구 : 사람이 이해할 수 있는 짧은 상태 코드 설명 글
- HTTP 헤더
    - header-field = field-name: OWS field-value OWS (OWS:띄어쓰기 허용)
    - field-name은 대소문자 구분 X
    - HTTP 전송에 필요한 모든 부가 정보 포함
        - 바디의 내용, 바디의 크기, 압축, 인증, 브라우저 정보, 서버 애플리케이션 정보, 캐시 관리 정보...
        - 표준 헤더가 너무 많음
        - 필요 시 임의의 헤더 추가 가능
- HTTP 메시지 바디
    - 실제 전송 할 데이터
    - HTML 문서, 이미지, 영상, JSON 등등 byte로 표현할 수 있는 모든 정보

### HTTP 메서드

- URI는 리소스를 식별
- 리소스와 해당 리소스를 대상 하는 행위를 분리
    - 리소스 : 회원
    - 행위 : 조회, 등록, 삭제, 변경
- 종류
    - GET
        - 리소스 조회
        - 서버에 전달하고 싶은 데이터는 query를 통해 전달
        - 메시지 바디를 사용해서 데이터를 전달할 수 있지만, 지원하지 않는 곳이 많아서 권장하지 않음
    - POST
        - 요청 데이터 처리
        - 메시지 바디를 통해 서버로 요청 데이터 전달
        - 서버는 요청 데이터를 처리
        - 주로 전달된 데이터로 신규 리소스 등록, 프로세스 처리에 사용
        - 다른 메서드로 처리하기 애매한 경우 POST 사용
    - PUT
        - 리소스를 **완전히** 대체
            - 있으면 대체
            - 없으면 생성
            - 부분 변경이 안되고 새로 받은 데이터로 완전히 바꿔버림
        - 클라이언트가 리소스 위치를 알고 URI지정 한다는 점에서 POST와 차이
    - PATCH
        - 리소스 부분 변경
    - DELETE
        - 리소스 삭제

### HTTP 메서드의 속성

- 안전(Safe)
    - 호출해도 리소스를 변경하지 않는다.
    - GET
- 멱등(Idempotent)
    - 한 번 호출하든 두 번 호출하든 100번 호출하든 결과가 똑같다.
    - GET, PUT, DELETE
    - 활용
        - 자동 복구 메커니즘
- 캐시 가능(Cacheable)
    - 응답 결과 리소스를 캐시해서 사용해도 되는가?
    - GET, HEAD, POST, PATCH 캐시 가능
    - 실제로는 GET, HEAD 정도만 캐시로 사용

### HTTP 메서드 활용

- 클라이언트에서 서버로 데이터 전송
    - 쿼리 파라미터를 통한 데이터 전송
        - GET
        - 주로 정렬 필터(검색어)
    - 메시지 바디를 통한 데이터 전송
        - POST, PUT, PATCH
        - 회원 가입, 상품 주문, 리소스 등록/변경
    - 정적 데이터 조회
        - 이미지, 정적 텍스트 문서
        - 조회는 GET 사용
        - 정적 데이터는 일반적으로 쿼리 파라미터 없이 리소스 경로로 단순하게 조회 가능
    - 동적 데이터 조회
        - 쿼리 파라미터 사용
            - 쿼리 파라미터를 기반으로 정렬 필터 해서 결과를 동적으로 생성
        - 주로 검색, 정렬 필터에 사용
        - 조회는 GET 사용
        - GET은 쿼리 파라미터 사용해서 데이터 전달
    - HTML Form 데이터 전송
        - GET, POST만 지원
        
        ![Untitled](1%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20f9afc63466f143379babfd84d5860723/Untitled%204.png)
        
        ![Untitled](1%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20f9afc63466f143379babfd84d5860723/Untitled%205.png)
        
        - multipart/form-data
            - 각 부분 별로 데이터를 구분하며 잘라줌
    - HTTP API 데이터 전송
        - 서버 to 서버
        - 앱 클라이언트
        - 웹 클라이언트
        - Content-Type: application/json을 주로 사용(사실상 표준)
            - TEXT, XML, JSON 등등

### HTTP API 설계 예시

### 회원 관리 시스템

### API 설계 - POST 기반 등록

- 회원 목록 /members → GET
- 회원 등록 /members → POST
- 회원 조회 /members/{id} → GET
- 회원 수정 /members/{id} → PATCH, PUT, POST
- 회원 삭제 /members/{id} → DELETE

컬렉션 : POST 기반 등록 시 서버에서 URI를 자동 저장시켜줌, 서버에서 관리

### API 설계 - PUT 기반 등록

- 파일 목록 /files → GET
- 파일 조회 /files/{filename} → GET
- 파일 등록 /files/{filename} → PUT
- 파일 삭제 /files/{filename} → DELETE
- 파일 대량 등록 /files POST

스토어 : PUT 기반 등록 시 클라이언트가 리소스의 URI를 알고 저장시킴, 클라이언트에서 관리

### HTML FORM 사용

GET, POST만 지원

제약을 해결하기 위해 동사로 된 리소스 경로 사용

- 회원 목록 /members → GET
- 회원 등록 폼 /members/new → GET
- 회원 등록 /members/new, /members → POST
- 회원 조회 /members/{id} → GET
- 회원 수정 폼 /members/{id}/edit → GET
- 회원 수정 /members/{id}/edit, /members/{id} → POST
- 회원 삭제 /members/{id}/delete → POST

### 참고하면 좋은 URI 설계 개념

- 문서(document)
    - 단일 개념(파일 하나, 객체 인스턴스, 데이터베이스 row)
    - 예) /members/100, /files/star.jpg
- 컬렉션(collection)
    - 서버가 관리하는 리소스 디렉터리
    - 서버가 리소스의 URI를 생성하고 관리
    - 예) /members
- 스토어(store)
    - 클라이언트가 관리하는 자원 저장소
    - 클라이언트가 리소스의 URI를 알고 관리
    - 예) files
- 컨트롤러(controller), 컨트롤 URI
    - 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행
    - 동사를 직접 사용
    - 예) /members/{id}/delete

### HTTP 상태 코드

클라이언트가 보낸 요청의 처리 상태를 응답에서 알려주는 기능

- 1xx : 요청이 수신 되어 처리 중 거의 사용하지 않음
- 2xx : 요청 정상 처리
    - 200 OK
    - 201 Created
        - 요청으로 인해 새로운 리소스가 만들어짐
    - 202 Accepted
        - 요청이 접수되었으나 처리가 완료되지 않았음
        - 배치 처리 같은 곳에서 사용
    - 204 No Content
        - 서버가 요청을 성공적으로 수행했지만, 응답 페이로드 본문에 보낼 데이터가 없음
- 3xx : 요청을 완료하려면 추가 행동이 필요
    - 리다이렉션 : 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동(리다이렉트)
        - 영구 리다이렉션 - 특정 리소스의 URI가 영구적으로 이동
            - 301 Moved Permanently
                - 리소스의 URI가 영구적으로 이동
                - 원래의 URL를 사용 X, 검색 엔진 등에서도 변경 인지
                - 리다이렉트 시 요청 메서드가 GET으로 변하고 본문이 제거될 수 있음
            - 308 Permanent Redirect
                - 301과 기능은 같음
                - 리다이렉트 시 요청 메서드와 본문 유지 (처음 POST로 보내면 리다이렉트도 POST)
        - 일시 리다이렉션 - 일시적인 변경
            - 주문 완료 후 주문 내역 화면으로 이동
            - PRG : Post/Redirect/Get
                - POST로 주문 후에 웹 브라우저를 새로고침 하면?
                - 새로고침은 다시 요청
                - POST로 주문 후에 주문 결과 화면을 GET 메서드로 리다이렉트
                - 새로고침해도 결과 화면을 GET으로 조회
            - 302 Found
                - 리다이렉트 시 요청 메서드가 GET으로 변하고 본문이 제거될 수 있음
            - 307 Temporary Redirect
                - 302와 기능은 같음
                - 리다이렉트 시 요청 메서드와 본문 유지(요청 메서드를 변경하면 안된다.)
            - 303 See Other
                - 302와 기능은 같음
                - 리다이렉트 시 요청 메서드가 GET으로 변경
        - 특수 리다이렉션
            - 결과 대신 캐시를 사용
            - 304 Not Modified
                - 캐시를 목적으로 사용
                - 클라이언트에게 리소스가 수정되지 않았음을 알려준다. 따라서 클라이언트는 로컬 PC에 저장된 캐시를 재사용한다. (캐시로 리다리렉트 한다.)
                - 304 응답은 응답에 메시지 바디를 포함하면 안된다. (로컬 캐시를 사용해야 하므로)
                - 조건부 GET, HEAD 요청 시 사용
    
    ![Untitled](1%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20f9afc63466f143379babfd84d5860723/Untitled%206.png)
    
- 4xx : 클라이언트 오류, 잘못된 문법 등으로 서버가 요청을 수행할 수 없음
    - 오류의 원인이 클라이언트에 있음
    - 클라이언트가 이미 잘못된 요청, 데이터를 보내고 있기 때문에, 똑같은 재시도가 실패함
    - 400 Bad Request
        - 요청 구문, 메시지 등등 오류
    - 401 Unauthorized
        - 인증이 되지 않음
    - 403 Forbidden
        - 서버가 요청을 이해했지만 승인을 거부함
        - 인증 자격 증명은 있지만, 접근 권한이 불충분한 경우
    - 404 Not Found
        - 요청 리소스가 서버에 없음
        - 또는 클라이언트가 권한이 부족한 리소스에 접근할 때 해당 리소스를 숨기고 싶을 때
- 5xx : 서버 오류, 서버가 정상 요청을 처리하지 못함
    - 오류의 원인이 서버에 있음
    - 서버에 문제가 있기 때문에 재시도 하면 성공할 수도 있음(복구가 되거나 등등)
    - 500 Internal Server Error
        - 서버 내부 문제로 오류 발생
    - 503 Service Unavailable
        - 일시적인 과부하, 또는 예정된 작업으로 잠시 요청을 처리할 수 없음

### HTTP 헤더

### 일반 헤더

- HTTP 전송에 필요한 모든 부가 정보
- Entity → Representation
- 표현 : 표현 메타데이터 + 표현 데이터

### HTTP BODY

- 메시지 본문(BODY)을 통해 표현 데이터 전달
- 메시지 본문 = 페이로드(payload)
- 표현 헤더는 표현 데이터를 해석할 수 있는 정보 제공
    - 데이터 유형, 데이터 길이, 압축 정보 등등

### 표현 헤더

- Content-Type : 표현 데이터의 형식
    - XML, JSON 등등
    - text/html; charset=utf-8
    - application/json
    - image/png
- Content-Encoding: 표현 데이터의 압축 방식
    - 데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가
    - 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제
    - gzip, deflate, identity
- Content-Language: 표현 데이터의 자연 언어
    - ko, en, en-US
- Content-Length: 표현 데이터의 길이
    - 바이트 단위

<aside>
💡 표현 헤더는 전송, 응답 둘 다 사용

</aside>

### 협상 헤더(콘텐츠 네고시에이션)

클라이언트가 선호하는 표현 요청

- Accept: 클라이언트가 선호하는 미디어 타입 전달
- Accept-Charset: 클라이언트가 선호하는 문자 인코딩
- Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
- Accept-Language:  클라이언트가 선호하는 자연 언어

<aside>
💡 협상 헤더는 요청 시에만 사용

</aside>

### 협상과 우선 순위1

- Quality Values(q) 값 사용
- 0~1, 클수록 높은 우선 순위
- 생략하면 1
- Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,enlq=0.7
    1. ko-KR;q=1 (q생략)
    2. ko;q=0.9
    3. en-US;q=0.8
    4. en:q=0.7

### 협상과 우선 순위2

- 구체적인 것이 우선한다.
- Accept: text/*, text.plain, text/plain;format=flowed, */*
    1. text/plain;format=flowed
    2. text/plain
    3. text/*
    4. */*

### 협상과 우선 순위3

- 구체적인 것을 기준으로 미디어 타입을 맞춘다.

### 전송 방식

- 단순 전송
    - 한번에 요청, 한번에 받음
- 압축 전송
    - 압축을 사용하여 전송, Content-Encoding 추가
- 분할 전송
    - 나눠서 보냄
    - Transfer-Encoding: chunked 입력
    - Content-Length 보내면 안됨
- 범위 전송
    - 받을 범위를 지정해 요청
    - 중간부터 받을 수 있음

### 일반 정보

- From
    - 유저 에이전트의 이메일 정보
    - 잘 사용 안함
- Referer
    - 현재 요청된 페이지의 이전 웹 페이지 주소
    - A → B에서 이동하는 경우 B를 요청할 때 Refer: A 를 포함해서 요청
    - 요청에서 사용
    - referer는 단어 referrer의 오타
- user-agent
    - 클라이언트의 애플리케이션 정보
    - 요청에서 사용
- Server
    - 요청을 처리하는 ORIGIN 서버의 소프트웨어 정보
    - Server: Apache/2.2.22(Debian)
    - 응답에서 사용
- Date
    - 메시지가 발생한 날짜와 시간
    - 응답에서 사용

### 특별한 헤더

- Host
    - 요청한 호스트 정보(도메인)
    - 필수
- Loacation
    - 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면 자동 이동
- Allow
    - 허용 가능한 HTTP 메서드
    - 405 (Method Not Allowed)에서 응답에 포함해야함
    - 잘 안씀
- Retry-After
    - 유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간
    - 503 (Service Unavailable)일 때 서버스가 언제까지 불능인지 알려줄 수 있음
- Authorization
    - 클라이언트 인증 정보를 서버에 전달
    - 401 에러가 날 때 WWW-Authenticate 헤더 포함

### 쿠키

- Set-Cookie: 서버에서 클라이언트로 쿠키 전달(응답)
- Cookie: 클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청 시 서버로 전달
- HTTP는 무상태 프로토콜
    - 요청과 응답을 주고 받으면 연결이 끊어져 이전 요청을 기억하지 못한다.
- 쿠키가 생성되면 모든 요청에 쿠키 정보 자동 포함
- set-cookie: sessionId=abcde1234; expires=Sat, 26-Dec-2020 00:00:00 GMT; path=/; [domain=.google.com](http://domain%3D.google.com/); Secure
- 사용처
    - 로그인 세션 관리
    - 광고 정보 트래킹
- 쿠키 정보는 항상 서버에 전송됨
    - 네트워크 트래픽 추가 유발
    - 최소한의 정보만 사용(세션 id, 인증 토큰)
    - 서버에 전송하지 않고, 웹 브라우저 내부에 데이터를 저장하고 싶으면 웹 스토리지 참고
- 생명주기
    - SetCookie: expires=Sat, 26-Dec-2020 04:39:21 GMT
    - 만료일이 되면 쿠키 삭제
    - 만료날짜를 생략하면 브라우저 종료 전까지 유지
- 도메인
    - 명시한 문서 도메인 + 서브 도메인에 포함
    - 생략 시 현재 문서 기준 도메인만 적용
- 경로
    - 도메인으로 필터 후 경로로 추가 필터
    - 경로를 포함한 하위 경로 페이지만 쿠키 접근
    - 일반적으로 루트로 지정
    - path=/
- 보안
    - Secure
        - 적용 시 https인 경우에만 전송
    - HttpOnly
        - XSS 공격 방지
        - 자바스크립트에서 접근 불가
        - HTTP 전송에만 사용
    - SameSite
        - XSRF 공격 방지
        - 요청한 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송

### 캐시

### 캐시와 조건부 요청

- 캐시가 없을 때
    - 데이터가 변경되지 않아도 계속 네트워크를 통해서 데이터를 받아야 한다
    - 느려짐
- 캐시가 있을 때
    - 캐시 가능 시간 동안 캐시에 데이터가 있으면 캐시에서 가져옴
    - 빠름

### 검증 헤더와 조건부 요청

캐시 만료 후에도 서버에서 데이터를 변경하지 않음

- 검증 해더 추가
- Last-Modified
    - Last-Modified에 날짜 값을 기록함
    - 시간 초과 시 해더에 if-modified-since에 날짜 값을 넣어줌
    - 서버에서 최종 수정일과 캐시의 수정일이 같으면 로컬 캐시 사용
        - 304 Not Modified 전송 및 HTTP BODY 없이 응답
        - 캐시 시간 갱신
    - 정리
        - 캐시 유효 시간이 초과해도, 서버의 데이터가 갱신되지 않으면
        - 304 Not Modified + 헤더 메타 정보만 응답(바디 X)
        - 클라이언트는 케시 메타데이터 갱신
- ETag
    - 캐시용 데이터에 임의의 고유한 버전 이름과 Hash를 저장함
    - 데이터가 변경되면 이름과 Hash를 다시 생성
    - 해쉬가 다르면 다시 받음
    - 시간 초과 시 If-None-Match 헤더에 이름을 넣어 보냄
    - 변경되지 않으면 304 및 Body 미전송
- 검증 헤더
    - 캐시 데이터와 서버 데이터가 같은지 검증하는 데이터
    - Last-Modified, ETag
- 조건부 요청 헤더
    - 검증 헤더로 조건에 따른 분기

### 캐시와 조건부 요청 헤더

- 캐시 제어 헤더
    - Cache-Control
        - 캐시 제어
        - Cache-Control: max-age
            - 캐시 유효 시간, 초 단위
        - Cache-Control: no-cache
            - 데이터는 캐시해도 되지만, 항상 원 서버에 검증하고 사용
        - Cache-Control: no-store
            - 데이터에 민감한 정보가 있으므로 저장하면 안됨
    - Pragma: 캐시 제어 (하위 호환)
        - Pragma: no-chache
    - Expires 캐시 유효 기간 (하위 호환)
        - Expires는 정확한 시간을 지정
        - 지금은 더 유연한 max-age로 권장
        - max-age가 있을 시 무시
- 검증 헤더
    - ETag
    - Last-Modified
- 조건부 요청 헤더
    - If-Match, If-None-Match: ETag 값 사용
    - if-Modified-Since, If-Unmodified-Since: Last-Modified 값 사용

### 프록시 캐시

![Untitled](1%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20f9afc63466f143379babfd84d5860723/Untitled%207.png)

중간에 프록시 서버를 두어 원 서버에 갈 필요 없이 프록시 캐시 서버에서 데이터 다운로드

- Cache-Control: public
    - 응답이 public 캐시에 저장되어도 됨
- Cache-Contorl: private
    - 응답이 해당 사용자에만 저장되어야 함

### 캐시 무효화

웹 브라우저가 임의로 캐시를 저장하기 때문에 캐시 되지 않으려면 이것을 해야함

- Cache-Control: no-cache, no-store, must-revalidate
- Pragma: no-cache
- Cache-Control: must-revalidate
    - 캐시 만료 후 최초 조회 시 원 서버에 검증 해야 함
    - 원 서버에 접근 불가 시 504 Gateway Timeout을 리턴