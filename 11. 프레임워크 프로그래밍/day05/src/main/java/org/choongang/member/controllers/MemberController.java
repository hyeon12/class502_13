package org.choongang.member.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.member.validators.JoinValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member") // 공통으로 매핑될 주소
@RequiredArgsConstructor // 생성자 자동 주입 (lombok)
public class MemberController {

    private final JoinValidator joinValidator;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form){
        //커맨드 객체 => EL 식으로 추가된다!
        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form, Errors errors){
        //회원 가입 데이터 검증
        joinValidator.validate(form, errors);

        if(errors.hasErrors()){
            // reject, rejectValue 가 한 번이라도 호출되면 true
            // 검증 실패시 다시 양식 페이지 이동
            return "member/join";
        }

        return "redirect:/member/login";
    }
}
