package org.hyeon.day90.board.services;

import lombok.RequiredArgsConstructor;
import org.hyeon.day90.board.constants.BoardData;
import org.hyeon.day90.board.controllers.RequestBoardData;
import org.hyeon.day90.board.repositories.BoardDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardDataService {
    private final BoardDataRepository boardDataRepository;

    public void save(RequestBoardData form){
        BoardData boardData = new ModelMapper().map(form, BoardData.class);
        save(boardData);
    }

    public void save(BoardData data){
        boardDataRepository.saveAndFlush(data);
    }
}
