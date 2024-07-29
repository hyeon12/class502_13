package org.choongang.exercise.board;

import org.choongang.exercise.board.entities.BoardData;
import org.choongang.exercise.board.repositories.BoardDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
public class Ex02 {

    @Autowired
    private BoardDataRepository boardDataRepository;

    void init(){
        List<BoardData> items = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> BoardData.builder()
                        .poster("작성자" + i)
                        .subject("제목" + i)
                        .content("내용" + i)
                        .build()).toList();
        boardDataRepository.saveAllAndFlush(items);
    }

    @Test
    void test0(){
        //DB에 가상 데이터 넣을 용도 --- 실패...~!
    }
}
