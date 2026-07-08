package com.example.memo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * 스프링 부트 컨텍스트 로딩 테스트.
 * MySQL 미설치 환경에서도 컨텍스트 부팅만 확인하도록 데이터소스만 H2 로 대체.
 */
@SpringBootTest
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
})
class MemoAppApplicationTests {

    @Test
    void contextLoads() { }
}
