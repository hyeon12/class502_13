package org.choongang.member.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.entities.Member;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/member") // 공통으로 매핑될 주소
@RequiredArgsConstructor // 생성자 자동 주입 (lombok)
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;

    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form){
        //커맨드 객체 => EL 식으로 추가된다!
        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors){
        //회원 가입 데이터 검증
        joinValidator.validate(form, errors);

        if(errors.hasErrors()){
            // reject, rejectValue 가 한 번이라도 호출되면 true
            // 검증 실패시 다시 양식 페이지 이동
            return "member/join";
        }

        /* 검증 통과 후, 회원가입 처리(process()) */
        joinService.process(form);

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form,
                        @CookieValue(name="savedEmail", required = false) String savedEmail
                        /*@SessionAttribute(name="member", required = false) Member member*/ ){
        /*if(member != null){
        log.info(member.toString());}
        */

        if(savedEmail != null){
            form.setSaveEmail(true);
            form.setEmail(savedEmail);
        }
        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors){

        loginValidator.validate(form, errors);

        if(errors.hasErrors()){
            return "member/login";
        }

        //로그인 처리
        loginService.process(form);

        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); //세션 비우기
        return "redirect:/member/login";
    }

    /*
    @InitBinder
    public void initBinder(WebDataBinder binder){
        //특정 컨트롤러에만 공통 적용될 Validator
        binder.setValidator(joinValidator);
    }
     */
}
