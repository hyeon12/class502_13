package org.choongang.exercise.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.exercise.board.entities.BoardData;
import org.choongang.exercise.board.repositories.BoardDataRepository;
import org.choongang.exercise.board.services.BoardDataSaveService;
import org.choongang.exercise.board.validators.BoardDataValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardDataRepository boardDataRepository;
    private final BoardDataValidator boardDataValidator;
    private final BoardDataSaveService saveService;

    @GetMapping("/list")
    public String list(Model model){

        List<BoardData> list = boardDataRepository.findAll();
        model.addAttribute("boardList", list);

        return "board/list";
    }

    @GetMapping("/write")
    public String write(@ModelAttribute RequestBoardData form){

        return "board/write";
    }

    @PostMapping("/write")
    public String writePs(@Valid RequestBoardData form, Errors errors){
        //log.info(form.getSubject());

        boardDataValidator.validate(form, errors);

        if(errors.hasErrors()){
            return "board/write";
        }
        //서비스에서 저장 처리!! (아직 추가 전)
        saveService.save(form);

        return "redirect:/board/list";
    }

    @GetMapping("/update")
    public String update(){
        return "board/update";
    }

    public String updatePs(){
        return "redirect:/board/list";
    }
}
