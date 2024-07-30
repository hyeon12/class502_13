package org.hyeon.day90.board.services;

import lombok.RequiredArgsConstructor;
import org.hyeon.day90.board.constants.BoardData;
import org.hyeon.day90.board.controllers.RequestBoardData;
import org.hyeon.day90.board.repositories.BoardDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardInfoService {

    private final BoardDataRepository repository;

    public BoardData get(Long seq){
        return repository.findById(seq).orElse(null);
    }

    public RequestBoardData getForm(Long seq){
        BoardData boardData = get(seq);
        RequestBoardData form = new ModelMapper(). map(boardData, RequestBoardData.class);

        return form;
    }
}
