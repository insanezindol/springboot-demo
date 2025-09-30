# Spring Boot 데모 프로젝트

## 개요

이 프로젝트는 Spring Boot를 기반으로 한 엔터프라이즈급 웹 애플리케이션 데모입니다. 다양한 기술 스택과 패턴을 활용하여 실무에서 사용할 수 있는 기능들을 구현하였습니다.

## 기술 스택

-   **Java 8**
-   **Spring Boot 2.1.2**
-   **Spring Data JPA**
-   **Spring Data Redis**
-   **Spring Data MongoDB**
-   **Spring Data Elasticsearch**
-   **Spring Kafka**
-   **MyBatis**
-   **MySQL**
-   **Hystrix (Circuit Breaker)**
-   **Swagger**
-   **Docker**
-   **Gradle**

## 주요 기능

-   REST API 개발
-   데이터베이스 연동 (MySQL, MongoDB, Redis, Elasticsearch)
-   메시지 큐 처리 (Kafka, RabbitMQ)
-   캐싱 처리
-   서킷 브레이커 패턴
-   API 문서화 (Swagger)
-   스케줄링 작업
-   AOP 적용
-   모니터링 및 헬스 체크

## 프로젝트 구조

```
src/
├── main/
│   ├── java/
│   │   └── kr/co/lunasoft/
│   │       ├── SpringbootDemoApplication.java
│   │       ├── config/          # 설정 클래스
│   │       ├── controller/      # REST 컨트롤러
│   │       ├── elasticsearch/   # Elasticsearch 관련
│   │       ├── jpa/            # JPA 엔티티 및 리포지토리
│   │       ├── listener/        # 이벤트 리스너
│   │       ├── mapper/          # MyBatis 매퍼
│   │       ├── model/           # 도메인 모델
│   │       ├── schedule/        # 스케줄링 작업
│   │       ├── service/         # 비즈니스 로직
│   │       └── util/            # 유틸리티 클래스
│   ├── resources/
│   │   ├── application.yml      # 애플리케이션 설정
│   │   ├── mapper/              # MyBatis XML 매퍼
│   │   └── static/              # 정적 리소스
│   └── webapp/
│       └── WEB-INF/views/       # JSP 뷰 템플릿
└── test/                        # 테스트 코드
```

## 환경 설정

### 필요 조건

-   Java 8 이상
-   MySQL 8.0
-   Redis
-   Elasticsearch
-   Kafka (선택사항)
-   MongoDB (선택사항)

### 설정 파일

`application.yml` 파일에서 다음 설정들을 환경에 맞게 수정하세요:

-   데이터베이스 연결 정보
-   Redis 연결 정보
-   Elasticsearch 클러스터 정보
-   Kafka 브로커 정보

## 실행 방법

### Gradle을 이용한 실행

```bash
# 의존성 다운로드 및 빌드
./gradlew clean build

# 애플리케이션 실행
./gradlew bootRun
```

### JAR 파일로 실행

```bash
# JAR 파일 생성
./gradlew bootJar

# JAR 파일 실행
java -jar build/libs/springboot-demo-0.0.1-SNAPSHOT.jar
```

### Docker를 이용한 실행

```bash
# Docker 이미지 빌드
docker build -t springboot-demo .

# Docker 컨테이너 실행
docker run -p 8080:8080 springboot-demo
```

## API 문서

애플리케이션 실행 후 다음 URL에서 API 문서를 확인할 수 있습니다:

-   Swagger UI: http://localhost:8080/swagger-ui.html

## 모니터링

Spring Boot Actuator를 통한 애플리케이션 모니터링:

-   Health Check: http://localhost:8080/actuator/health
-   Metrics: http://localhost:8080/actuator/metrics

## 주요 패키지 설명

### config/

Spring Boot 설정 클래스들이 위치합니다.

-   데이터베이스 설정
-   보안 설정
-   Swagger 설정
-   캐시 설정

### controller/

REST API 엔드포인트를 제공하는 컨트롤러 클래스들입니다.

### service/

비즈니스 로직을 처리하는 서비스 계층입니다.

### jpa/

JPA를 이용한 데이터 접근 계층입니다.

-   엔티티 클래스
-   JPA 리포지토리

### elasticsearch/

Elasticsearch와의 연동을 위한 클래스들입니다.

### schedule/

정기적으로 실행되는 작업들을 정의합니다.

## 개발 가이드

### 코딩 스타일

-   Java 8+ 문법 활용
-   Lombok 어노테이션 사용으로 보일러플레이트 코드 최소화
-   RESTful API 디자인 원칙 준수
-   계층형 아키텍처 패턴 적용

### 테스트

```bash
# 단위 테스트 실행
./gradlew test

# 통합 테스트 실행
./gradlew integrationTest
```

### 로그 확인

-   로그 레벨은 `application.yml`에서 설정 가능
-   SQL 로그는 log4jdbc를 통해 확인 가능

## 배포

### 운영 환경 설정

1. `application.yml`에서 `spring.profiles.active`를 `real`로 설정
2. 데이터베이스 연결 정보 업데이트
3. 보안 설정 강화

### CI/CD

프로젝트는 다음과 같은 CI/CD 파이프라인 구성이 가능합니다:

1. 코드 커밋
2. 자동 빌드 및 테스트
3. Docker 이미지 생성
4. 배포 환경에 자동 배포

## 문제 해결

### 일반적인 문제들

1. **데이터베이스 연결 오류**: `application.yml`의 데이터베이스 설정 확인
2. **포트 충돌**: 8080 포트가 이미 사용 중인 경우 `server.port` 설정 변경
3. **메모리 부족**: JVM 힙 메모리 설정 조정 (`-Xmx` 옵션)

### 로그 확인 방법

```bash
# 애플리케이션 로그 확인
tail -f logs/springboot-demo.log

# 특정 패키지 로그 레벨 변경
# application.yml에서 logging.level.[패키지명] 설정
```

## 기여 방법

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다.
