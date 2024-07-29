package org.choongang.exercise.board.service;

import org.choongang.exercise.board.controllers.RequestBoardData;
import org.choongang.exercise.board.entities.BoardData;
import org.choongang.exercise.board.repositories.BoardDataRepository;
import org.choongang.exercise.board.services.BoardDataService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DisplayName("게시글 등록 테스트")
@SpringBootTest
//@Transactional
//@ActiveProfiles("test")
public class BoardSaveServiceTest {
    @Autowired
    private BoardDataService saveService;
    @Autowired
    private BoardDataRepository repository;

    @Test
    void saveTest(){
        //QBoardData boardData = QBoardData.boardData;
        RequestBoardData data = new RequestBoardData();
        data.setPoster("작성자");
        data.setSubject("제목");
        data.setContent("내용 어쩌고저쩌고 내용입니다.");

        saveService.save(data);
        repository.flush();

        List<BoardData> blist = repository.findAll();
        blist.forEach(System.out::println);
        //repository.flush();
    }
}
