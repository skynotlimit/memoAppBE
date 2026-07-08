package com.example.memo.dto;

import com.example.memo.domain.Memo;

import java.time.LocalDateTime;

/**
 * 메모 응답 DTO.
 * 엔티티를 직접 노출하지 않고 필요한 필드만 반환합니다.
 */
public record MemoResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static MemoResponse from(Memo memo) {
        return new MemoResponse(
                memo.getId(),
                memo.getTitle(),
                memo.getContent(),
                memo.getCreatedAt(),
                memo.getUpdatedAt()
        );
    }
}
