package com.example.memo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * JPA Auditing 활성화 설정.
 * Memo 엔티티의 @CreatedDate / @LastModifiedDate 가 동작하려면 필요합니다.
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig { }
