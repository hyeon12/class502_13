package org.hyeon.day90.board.services;

import lombok.RequiredArgsConstructor;
import org.hyeon.day90.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardDataDeleteService {
    private final BoardDataRepository boardDataRepository;

    public void delete(Long id){
        boardDataRepository.deleteById(id);
        boardDataRepository.flush(); //기본키일 때는 엔티티에서 직접 불러오지 않아도 된다!
    }

    public void delete(List<Long> ids) {
        boardDataRepository.deleteAllById(ids);
        boardDataRepository.flush();
    }
    /*
    public void delete(long id){
        if (!boardDataRepository.existsById(id)) {
            throw new RuntimeException("게시글이 존재하지 않습니다.");
        } else {
            boardDataRepository.deleteById(id);
        }
    }*/

}
