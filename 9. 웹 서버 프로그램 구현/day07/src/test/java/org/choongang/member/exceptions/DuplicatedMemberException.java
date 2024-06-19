package org.choongang.member.exceptions;

import org.choongang.global.exceptions.BadRequestException;

public class DuplicatedMemberException extends BadRequestException {
    public DuplicatedMemberException(){
        //예외의 경우에도, 제한적인 케이스의 경우 -> 문구 고정해도 된다!
        //어차피 유연하게 사용하지 못하는 케이스이기 때문!
        super("이미 가입된 회원입니다.");
    }
}
