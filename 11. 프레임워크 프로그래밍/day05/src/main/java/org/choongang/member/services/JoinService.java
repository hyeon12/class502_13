package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {


    private final MemberMapper mapper;

    public void process(RequestJoin form){
        //유효성 검사

        //비밀번호 해시화
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));

        //DB 저장
        Member member = Member.builder()
                .email(form.getEmail())
                .password(hash) //DB에 해시화된 비밀번호로 저장
                .userName(form.getUserName())
                .build();

        int result = mapper.register(member);
        if(result < 1){
            throw new BadRequestException("👀 회원 가입 실패❌");
        }
    }
}
