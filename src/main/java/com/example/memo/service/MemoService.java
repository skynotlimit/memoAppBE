package com.example.memo.service;

import com.example.memo.domain.Memo;
import com.example.memo.dto.MemoRequest;
import com.example.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 메모 비지니스 로직.
 * - @Transactional(readOnly = true) : 읽기 메서드는 읽기 전용 트랜잭션 (성능 최적화)
 * - 쓰기(생성/수정/삭제) 메서드만 별도로 @Transactional 적용
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemoService {

    private final MemoRepository memoRepository;

    /** 메모 생성 */
    @Transactional
    public Memo create(MemoRequest request) {
        Memo memo = Memo.builder()
                .title(request.title())
                .content(request.content())
                .build();
        return memoRepository.save(memo);
    }

    /** 메모 단건 조회 */
    public Memo get(Long id) {
        return memoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("메모를 찾을 수 없습니다. id=" + id));
    }

    /** 메모 목록 조회 (최신순) */
    public List<Memo> list() {
        return memoRepository.findAll()
                .stream()
                .sorted((a, b) -> b.getId().compareTo(a.getId()))
                .toList();
    }

    /** 메모 수정 */
    @Transactional
    public Memo update(Long id, MemoRequest request) {
        Memo memo = get(id);
        memo.update(request.title(), request.content());
        return memo; // 더티 체킹으로 자동 반영
    }

    /** 메모 삭제 */
    @Transactional
    public void delete(Long id) {
        memoRepository.deleteById(id);
    }
}
