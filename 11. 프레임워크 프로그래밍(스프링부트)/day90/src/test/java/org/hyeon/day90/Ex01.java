package org.hyeon.day90;

import org.hyeon.day90.board.constants.BoardData;
import org.hyeon.day90.board.constants.QBoardData;
import org.hyeon.day90.board.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@DisplayName("레포지토리 명령어 작동 테스트")
@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01 {
    @Autowired
    private BoardDataRepository boardDataRepository;

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
        List<BoardData> items = boardDataRepository.findAll();
    }

    @Test
    void test2(){
        QBoardData boardData = QBoardData.boardData;
        String subject = "제목3";
        boardDataRepository.exists(boardData.subject.eq(subject));    }

    @Test
    void test3(){
        //QBoardData boardData = QBoardData.boardData;
        boardDataRepository.deleteById(1L);
        boardDataRepository.flush();

        List<BoardData> items = boardDataRepository.findAll();
        items.forEach(System.out::println);
    }

}

