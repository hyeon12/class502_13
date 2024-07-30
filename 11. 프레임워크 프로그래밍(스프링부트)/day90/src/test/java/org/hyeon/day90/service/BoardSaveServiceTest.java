package org.hyeon.day90.service;

import org.hyeon.day90.board.constants.BoardData;
import org.hyeon.day90.board.controllers.RequestBoardData;
import org.hyeon.day90.board.repositories.BoardDataRepository;
import org.hyeon.day90.board.services.BoardDataService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DisplayName("게시글 등록 테스트")
@SpringBootTest
@Transactional
@ActiveProfiles("test")
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
