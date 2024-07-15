package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Slf4j
@Controller
@RequestMapping("/member2") //공통 요청
@RequiredArgsConstructor
public class MemberController2 {

    private final MessageSource messageSource;
    private final HttpServletRequest request;

    @ModelAttribute("commonValue") // 해당 컨트롤러 내에서 사용 가능한 공통 데이터
    public String commonValue(){
        return "공통 속성값 . . . ";
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies(){
        return List.of("취미1", "취미2", "취미3", "취미4");
    }

    @ModelAttribute("hobbies2")
    public List<CodeValue> hobbies2(){
        return List.of(
                new CodeValue("취미1", "hobby1"),
                new CodeValue("취미2", "hobby2"),
                new CodeValue("취미3", "hobby3"),
                new CodeValue("취미4", "hobby4")
        );
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("command") RequestJoin form){

        Locale locale = request.getLocale();
        //요청헤더 Accept-Language 브라우저에 설정된 언어 정보
        String message = messageSource.getMessage("EMAIL", null, locale);
        log.info(message);

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@ModelAttribute("command") RequestJoin form){
        //커맨드 객체(RequestJoin) - 서비스 기능 처리, 데이터 넘겨줌
        // -> (클래스명) EL 속성으로 자동 추가
        //log.info(form.toString());

        return "member/join";
    }

    @GetMapping("/login")
    public String login(RequestLogin2 form){
        if(form != null) {
            log.info("이메일:{}, 비밀번호:{}",form.email(),form.password());
        }
        return "member/login";
    }

    //private final Logger log = LoggerFactory.getLogger(MemberController.class);
    //로거 연동 (레벨 별 메서드 O)
/*

    (공부할 때 참고 소스 ---- 순서 없음... ㅎ)

    @GetMapping("/join")
    public String join(Model model){
    //get 방식일 때는 주입된 커맨드 객체가 없음
    // -> jsp 쪽에 EL식 변수로 넘어올 데이터 없다...! 빈 값으로 두면 오류...!
    //값이 없더라도 커스텀 태그를 사용하는 양식을 쓰는 경우, 무언가 값을 넘겨줘야 함 => Model

    RequestJoin form = new RequestJoin();
    model.addAttribute("requestJoin", form);
    //명칭이 유지되는 빈 객체(요청 데이터 없는)를 만들어줘야 오류가 생기지 않는 것

    return "member/join";
    }


        @PostMapping("/join")
    public String joinPs(RequestJoin form){

        //return "redirect:/member/login"; // Location : /day05/member/login
        return "forward:/member/login"; //버퍼 치환
    }


    @GetMapping("/join")
    public String join1(){

        //log.info("mode 없음");

        log.info("{}, {} 없음", "mode1", "mode2");


        return "member/join";
    }

    //@RequestMapping(path = "/member/join", method = {RequestMethod.GET, RequestMethod.POST})
    //GET, POST 모두 가능한 방식 (method 를 따로 설정하지 않으면, 모든 요청 메서드에 매핑 가능)
    @GetMapping(path="/join", params={"mode=join"})
    public String join(){ //join 메서드 -> '/join' 경로에 대한 GET 요청을 처리하도록 @GetMapping 처리

        log.info("mode=join");

        return "member/join";
    }

    @PostMapping(path = "/join", headers="appKey=1234", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    // headers - 요청 쪽 appKey=1234 라는 값이 들어와야 유입 가능
    // consumes - 요청 쪽 contentType 을 지정하여 제한!
    // produces - 응답헤더 쪽 contentType
    public String joinPs(RequestJoin form){
        //POST -> 사용자가 넘긴 데이터 값을 활용하게 됨 -> 커맨드 객체

        log.info("joinPs 실행 ....");

        return "redirect:/member/login";
        //contextPath 뒤에 붙어서, 주소 이동을 하는 것!
        //templates 아님.
    }

 */

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

