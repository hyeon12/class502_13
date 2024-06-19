package org.choongang.member.services;

import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;

//회원가입기능
public class JoinService {
    //구성
    private Validator<RequestJoin> validator;

    //개방 폐쇄 원칙 - 생성자 || set
    public JoinService(Validator<RequestJoin> validator){
        this.validator = validator;
    }

    public void process(RequestJoin form){
        //form(RequestJoin) 유입되면, 검증하는 절차를 거친다!

        //유효성 검사
        validator.check(form);
    }

}
