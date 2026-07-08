package com.example.memo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 메모앱 백엔드 진입점 (Spring Boot).
 * http://localhost:8080 에서 REST API 서비스 제공.
 */
@SpringBootApplication
public class MemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemoAppApplication.class, args);
    }
}
