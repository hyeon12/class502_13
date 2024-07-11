package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member") //공통요청
public class MemberController {


    //@RequestMapping(path = "/member/join", method = {RequestMethod.GET, RequestMethod.POST})
    //GET, POST 모두 가능한 방식 (method 를 따로 설정하지 않으면, 모든 요청 메서드에 매핑 가능)
    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form){
        //POST -> 사용자가 넘긴 데이터 값을 활용하게 됨 -> 커맨드 객체
        return "redirect:/member/login";
        //contextPath 뒤에 붙어서, 주소 이동을 하는 것!
        //templates 아님.
    }

    /*
    @GetMapping("/member/join")
    public ModelAndView join(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello");
        mv.setViewName("member/join");
        //member/join 쪽을 버퍼에 추가하고 출력해준다..! (View - 템플릿 경로)

        return mv;
    }
     */
}

