package org.hyeon.day90;

import org.hyeon.day90.board.constants.BoardData;
import org.hyeon.day90.board.controllers.RequestBoardData;
import org.hyeon.day90.board.repositories.BoardDataRepository;
import org.hyeon.day90.board.services.BoardDataDeleteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
@DisplayName("DELETE 테스트")
public class Ex03 {

    @Autowired
    private BoardDataRepository boardDataRepository;
    @Autowired
    private BoardDataDeleteService deleteService;
    @Autowired(required = false)
    private RequestBoardData requestBoardData;

    @BeforeEach
    void init(){
        List<BoardData> items = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> BoardData.builder()
                        .poster("작성자" + i)
                        .subject("제목" + i)
                        .content("내용" + i)
                        .build()).toList();

        boardDataRepository.saveAllAndFlush(items);
    }

    @Test
    void test1(){
        //boardDataRepository.findById(1L)
        //requestBoardData.getPoster();
        deleteService.delete(1L);
        boardDataRepository.flush();

        List<BoardData> all = boardDataRepository.findAll();
        all.forEach(System.out::println);
    }
}
