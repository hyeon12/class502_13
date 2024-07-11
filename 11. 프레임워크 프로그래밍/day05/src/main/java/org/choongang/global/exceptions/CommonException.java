package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{

    //스프링에서 제공하는 응답 코드 관련 enum 상수
    private HttpStatus status;

    public CommonException(String message){
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);
        //응답 코드가 없는 상태로 호출할 경우, 응답코드 : 500대로 고정
    }

    public CommonException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
