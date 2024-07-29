package org.choongang.exercise.board;

import org.choongang.exercise.board.entities.BoardData;
import org.choongang.exercise.board.entities.QBoardData;
import org.choongang.exercise.board.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

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
        List<BoardData> items = boardDataRepository.findBySubjectContaining("제목");
    }

    @Test
    void test3(){
        QBoardData boardData = QBoardData.boardData;
        String subject = "제목3";
        boardDataRepository.exists(boardData.subject.eq(subject));
    }

    @Test
    void test4(){
        //QBoardData boardData = QBoardData.boardData;
        boardDataRepository.deleteById(1L);
        boardDataRepository.flush();

        List<BoardData> items = boardDataRepository.findAll();
        items.forEach(System.out::println);
    }

    @Test
    void test5(){
        QBoardData boardData = QBoardData.boardData;
    }


}
