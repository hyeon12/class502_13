package org.hyeon.day90.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hyeon.day90.board.constants.BoardData;
import org.hyeon.day90.board.repositories.BoardDataRepository;
import org.hyeon.day90.board.services.BoardDataDeleteService;
import org.hyeon.day90.board.services.BoardDataService;
import org.hyeon.day90.board.services.BoardInfoService;
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
    private final BoardInfoService infoService;

    @GetMapping("/list")
    public String list(Model model){

        //모델로 속성에 추가 - addAttribute
        List<BoardData> list = boardDataRepository.findAll(Sort.by(Sort.Direction.ASC, "seq"));
        model.addAttribute("boardList", list);
        model.addAttribute("addCss", new String[] {"list"});

        return "board/list";
    }


    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
//        Optional<BoardData> data = boardDataRepository.findById(id);
//        data.orElse(null);
//        model.addAttribute("view", data);
        BoardData boardData = infoService.get(id);
        model.addAttribute("boardData", boardData);
        model.addAttribute("addCss", new String[] {"view"});
        return "board/view";
    }

    @GetMapping("/write")
    public String write(@ModelAttribute RequestBoardData form){

        return "board/write";
    }

    @PostMapping("/write")
    public String writePs(@Valid RequestBoardData form, Errors errors){

        //model.addAttribute("addCss", new String[] {"write"});
        // 검증(NotBlanked)
        boardDataValidator.validate(form, errors);

        if(errors.hasErrors()){
            return "board/write";
        }

        // 서비스 - 저장 기능 추가
        boardDataService.save(form);

        return "redirect:/board/list";
    }

    @GetMapping("/update/{seq}")
    public String update(@PathVariable("seq") Long seq, Model model){
        RequestBoardData form = infoService.getForm(seq);
        model.addAttribute("requestBoardData", form);

        return "board/update";
    }

    @PostMapping("/update")
    public String updatePs(@Valid RequestBoardData form, Errors errors){
        boardDataValidator.validate(form, errors);

        if(errors.hasErrors()){
            return "board/update";
        }
        // 검증 추가하기
        boardDataService.save(form);

        return "redirect:/board/list";
    }

    @GetMapping("/delete/{seq}")
    public String delete(@PathVariable("seq") Long seq, Model model) {
        BoardData boardData = infoService.get(seq);
        if( boardData != null ){
            deleteService.delete(seq);
        }

        model.addAttribute("script", "parent.location.reload()");
        return "redirect:/board/list";
    }


    /*
    @PostMapping("/delete")
    public String delete(@RequestParam("seq") List<Long> ids, Model model) {
        deleteService.delete(ids);

        //deleteService.delete(seq);
        // String script = "parent.location.reload();";
        //model.addAttribute("script", script);
        //return "redirect:/board/list";
        model.addAttribute("script", "parent.location.reload()");
        return "common/_script";
    }*/

}
