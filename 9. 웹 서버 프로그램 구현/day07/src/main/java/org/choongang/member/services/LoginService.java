package org.choongang.member.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.choongang.global.validators.Validator;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;

public class LoginService {

    //개방폐쇄원칙
    private Validator<HttpServletRequest> validator;
    private MemberMapper mapper;

    public LoginService(Validator<HttpServletRequest> validator, MemberMapper mapper){
        this.validator = validator;
        this.mapper = mapper;
    }

    public void process(HttpServletRequest request){
        //로그인 유효성 검사
        validator.check(request);

        //로그인 처리(위의 유효성 검사를 통과한 값이 넘어옴)
        //(1)회원 정보 조회 (2)세션에 유지
        String email = request.getParameter("email");
        Member member = mapper.get(email);

        //개인이 사용할 수 있는 공간(세션)에 유지하기 위해....!!!
        HttpSession session = request.getSession();
        session.setAttribute("member", member);//member 들어가있으면 login 상태인것!(index.jsp 참고)
    }
}
