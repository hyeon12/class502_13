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
        Long seq = form.getSeq();
        BoardData boardData = null;

        if (seq != null){ // 수정
            boardData = boardDataRepository.findById(seq).orElse(null);
            if(boardData != null) {
                boardData.setPoster(form.getPoster());
                boardData.setSubject(form.getSubject());
                boardData.setContent(form.getContent());
            }
        }

        // 추가
        if (boardData == null) boardData = new ModelMapper().map(form, BoardData.class);

        boardDataRepository.saveAndFlush(boardData);
        //BoardData boardData = new ModelMapper().map(form, BoardData.class);
        //save(boardData);
    }

    public void save(BoardData data){
        boardDataRepository.saveAndFlush(data);
    }
}
