package org.choongang.exercise.board.repositories;

import org.choongang.exercise.board.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor<BoardData> {
    @Query("SELECT b FROM BoardData b")
    List<BoardData> getAllList();

    List<BoardData> findBySubjectContaining(String key);

}
