package com.example.memo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 메모 생성 / 수정 요청 DTO.
 * 컨트롤러에서 @Valid 와 함께 검증합니다.
 */
public record MemoRequest(

        @NotBlank(message = "제목은 필수입니다.")
        @Size(max = 100, message = "제목은 100자 이하여야 합니다.")
        String title,

        @NotBlank(message = "내용은 필수입니다.")
        String content
) { }
