package com.example.memo.controller;

import com.example.memo.dto.MemoRequest;
import com.example.memo.dto.MemoResponse;
import com.example.memo.service.MemoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * 메모 REST API 컨트롤러.
 *
 *  POST   /api/memos          메모 생성
 *  GET    /api/memos          메모 목록
 *  GET    /api/memos/{id}     메모 단건 조회
 *  PUT    /api/memos/{id}     메모 수정
 *  DELETE /api/memos/{id}     메모 삭제
 */
@RestController
@RequestMapping("/api/memos")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    /** 생성 */
    @PostMapping
    public ResponseEntity<MemoResponse> create(@Valid @RequestBody MemoRequest request) {
        MemoResponse response = MemoResponse.from(memoService.create(request));
        return ResponseEntity
                .created(URI.create("/api/memos/" + response.id()))
                .body(response);
    }

    /** 목록 */
    @GetMapping
    public List<MemoResponse> list() {
        return memoService.list().stream()
                .map(MemoResponse::from)
                .toList();
    }

    /** 단건 */
    @GetMapping("/{id}")
    public MemoResponse get(@PathVariable Long id) {
        return MemoResponse.from(memoService.get(id));
    }

    /** 수정 */
    @PutMapping("/{id}")
    public MemoResponse update(@PathVariable Long id,
                               @Valid @RequestBody MemoRequest request) {
        return MemoResponse.from(memoService.update(id, request));
    }

    /** 삭제 */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        memoService.delete(id);
    }
}
