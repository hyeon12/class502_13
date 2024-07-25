package org.choongang.board.repositories;

import jakarta.persistence.Entity;
import org.choongang.board.entities.BoardData;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor<BoardData> {
    @Query("SELECT b FROM BoardData b LEFT JOIN FETCH b.member")
    List<BoardData> getAllList();

    @EntityGraph(attributePaths = "member")
    //바로 조회 할 엔티티 명시 / Board Data의 member 엔티티, 배열 형태가 많으면 중괄호 형태로 입력
    List<BoardData> findBySubjectContaining(String key);
}
