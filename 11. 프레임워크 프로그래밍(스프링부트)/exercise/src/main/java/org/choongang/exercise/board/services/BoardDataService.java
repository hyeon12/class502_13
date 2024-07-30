package org.choongang.exercise.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.exercise.board.controllers.RequestBoardData;
import org.choongang.exercise.board.entities.BoardData;
import org.choongang.exercise.board.repositories.BoardDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardDataService {
    private final BoardDataRepository boardDataRepository;
    //private final RequestBoardData data;

    public void save(RequestBoardData form){
        BoardData boardData = new ModelMapper().map(form, BoardData.class);
        save(boardData);
    }

    public void save(BoardData data){
        boardDataRepository.save(data);
        boardDataRepository.flush();
    }

    public void delete(long id){
        if (boardDataRepository.existsById(id)) {
            boardDataRepository.deleteById(id);
        } else {
            // 게시글이 존재하지 않는 경우 처리
            throw new RuntimeException("게시글이 존재하지 않습니다.");
        }
    }
}
