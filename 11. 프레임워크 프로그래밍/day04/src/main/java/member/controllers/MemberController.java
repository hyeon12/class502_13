package member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/member/join")
    // public String join(@RequestParam(name="name", required = false) String name) - 값 없을때 null 값 대입
    public String join(@RequestParam(name="name", defaultValue = "기본값") String name){
        System.out.println("name:" + name);
        return "member/join";
    }
}
