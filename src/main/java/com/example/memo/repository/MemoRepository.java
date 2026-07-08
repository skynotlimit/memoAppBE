package com.example.memo.repository;

import com.example.memo.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 메모 레포지토리.
 * JpaRepository 를 상속받아 기본 CRUD / 페이징 메서드가 자동 생성됩니다.
 *  - save, findById, findAll, deleteById, count ...
 */
public interface MemoRepository extends JpaRepository<Memo, Long> {
}
