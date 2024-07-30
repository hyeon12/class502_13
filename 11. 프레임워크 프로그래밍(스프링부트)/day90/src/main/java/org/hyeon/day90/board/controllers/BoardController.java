package org.hyeon.day90.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hyeon.day90.board.constants.BoardData;
import org.hyeon.day90.board.repositories.BoardDataRepository;
import org.hyeon.day90.board.services.BoardDataDeleteService;
import org.hyeon.day90.board.services.BoardDataService;
import org.hyeon.day90.board.validators.BoardDataValidator;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardDataValidator boardDataValidator;
    private final BoardDataService boardDataService;
    private final BoardDataRepository boardDataRepository;
    private final BoardDataDeleteService deleteService;

    @GetMapping("/list")
    public String list(Model model){

        //모델로 속성에 추가 - addAttribute
        List<BoardData> list = boardDataRepository.findAll(Sort.by(Sort.Direction.ASC, "seq"));
        model.addAttribute("boardList", list);

        return "board/list";
    }

    @GetMapping("/write")
    public String write(@ModelAttribute RequestBoardData form){

        return "board/write";
    }

    @PostMapping("/write")
    public String writePs(@Valid RequestBoardData form, Errors errors){
        // 검증(NotBlanked)
        boardDataValidator.validate(form, errors);

        if(errors.hasErrors()){
            return "board/write";
        }

        // 서비스 - 저장 기능 추가
        boardDataService.save(form);

        return "redirect:/board/list";
    }

    @GetMapping("/update")
    public String update(){
        return "board/update";
    }

    @PostMapping("/update")
    public String updatePs(){

        // 검증 추가하기

        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("seq") List<Long> ids, Model model){
        deleteService.delete(ids);

        //deleteService.delete(seq);
       // String script = "parent.location.reload();";
        //model.addAttribute("script", script);
        //return "redirect:/board/list";
        model.addAttribute("script", "parent.location.reload()");
        return "common/_script";
    }

}
