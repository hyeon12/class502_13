package org.choongang.survey.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/survey")
@SessionAttributes("requestSurvey")
public class SurveyController {
    // 여러 페이지로 구성된 양식

    @ModelAttribute
    public RequestSurvey requestSurvey(){
        return new RequestSurvey();
    }

    //첫번째 스텝 페이지
    @GetMapping("/step1")
    public String step1(){
        return "survey/step1";
    }

    /*
    //첫번째 스텝 페이지
    @GetMapping("/step1")
    public String step1(@ModelAttribute RequestSurvey form){
        //새 'RequestSurvey' 객체를 생성하고 모델에 추가
        return "survey/step1";
    }
     */

    /* step1 에서 step2 로 양식을 넘기자! => POST */

    //폼 데이터 처리 -> step1의 RequestSurvey 가 폼 데이터를 통해 전달
    @PostMapping("/step2")
    public String step2(RequestSurvey form, @SessionAttribute("requestSurvey") RequestSurvey form2){
        //값 1, 2번 유지
        log.info("form : " + form.toString());
        log.info("form2 : " + form2.toString());

        return "survey/step2";
    }

    /* step2 에서 step3 로 양식을 넘기자! => POST */

    @PostMapping("/step3")
    public String step3(RequestSurvey form, @SessionAttribute("requestSurvey") RequestSurvey form2, SessionStatus status, HttpSession session, HttpServletRequest request){

        log.info("form: " + form.toString());
        log.info("form2: " + form2.toString());

        status.setComplete(); //세션 비우기 -> requestSurvey 세션 비우기

        System.out.println("세션 비우기 후: " + request.getSession().getAttribute("requestSurvey"));

        return "survey/step3";
    }
}
