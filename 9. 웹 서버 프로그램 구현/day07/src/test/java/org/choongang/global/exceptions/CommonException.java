package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class CommonException extends RuntimeException {//검증에 필요한 예외객체(임의로 발생시키기 위함)

    private int status;//응답코드

    //기본생성자 위치는 위아래 상관 없음
    public CommonException(String message){
        this(message, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        //상태코드 500으로 고정 (상수형태로 넣는 것이 좋다)
    }

    public CommonException(String message, int status){
        super(message); //RuntimeException 에서 발생한 message
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}
