package com.example.memo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 메모 1건에 대한 JPA 엔티티.
 * - ID: 자동 증가 BIGINT
 * - title / content: 제목/본문
 * - createdAt / updatedAt: 생성/수정 시각 (JPA Auditing)
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /** 메모 수정 (더티 체킹 활용). */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
