# Memo App Backend

Spring Boot 기반의 메모 애플리케이션 백엔드 서버입니다.

## Tech Stack

- **Language**: Java
- **Framework**: Spring Boot
- **Build Tool**: Gradle
- **Persistence**: Spring Data JPA
- **Auditing**: JPA Auditing (`@CreatedDate`, `@LastModifiedDate`)

## Project Structure

```
src/main/java/com/example/memo
├── MemoAppApplication.java        # Application entry point
├── config/
│   └── JpaAuditingConfig.java     # JPA Auditing configuration
├── controller/
│   ├── MemoController.java        # REST API endpoints
│   └── GlobalExceptionHandler.java
├── domain/
│   └── Memo.java                  # Memo entity
├── dto/
│   ├── MemoRequest.java           # Request DTO
│   └── MemoResponse.java          # Response DTO
├── repository/
│   └── MemoRepository.java        # Spring Data JPA repository
└── service/
    └── MemoService.java           # Business logic
```

## Getting Started

### Prerequisites

- Java 17+
- Gradle

### Run

```bash
./gradlew bootRun
```

### Build

```bash
./gradlew build
```

## API Endpoints

| Method | URI          | Description        |
|--------|--------------|--------------------|
| GET    | `/memos`     | Get all memos      |
| GET    | `/memos/{id}`| Get memo by id     |
| POST   | `/memos`     | Create a new memo  |
| PUT    | `/memos/{id}`| Update a memo      |
| DELETE | `/memos/{id}`| Delete a memo      |