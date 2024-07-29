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
public class BoardDataSaveService {
    private final BoardDataRepository boardDataRepository;

    public void save(RequestBoardData form){
        BoardData boardData = new ModelMapper().map(form, BoardData.class);
        save(boardData);
    }

    public void save(BoardData data){
        boardDataRepository.save(data);
        boardDataRepository.flush();
    }
}
