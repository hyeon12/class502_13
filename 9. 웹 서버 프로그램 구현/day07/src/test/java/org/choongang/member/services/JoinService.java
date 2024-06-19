package org.choongang.member.services;

import org.choongang.global.exceptions.BadRequestException;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;

//회원가입기능
public class JoinService {
    //구성
    private Validator<RequestJoin> validator;
    private MemberMapper mapper;

    //개방 폐쇄 원칙 - 생성자 || set
    public JoinService(Validator<RequestJoin> validator, MemberMapper mapper){
        this.validator = validator;
        this.mapper = mapper;
    }

    public void process(RequestJoin form){
        //form(RequestJoin) 유입되면, 검증하는 절차를 거친다!

        //유효성 검사
        validator.check(form);

        //비밀번호 해시화 - BCrypt
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(hash);//비밀번호 설정시, 해시화
        member.setUserName(form.getUserName());

        int result = mapper.register(member);
        if(result < 1){
            throw new BadRequestException("회원가입에 실패하였습니다.");
        }

    }
}
