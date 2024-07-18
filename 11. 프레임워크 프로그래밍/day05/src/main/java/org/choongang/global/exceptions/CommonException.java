package org.choongang.global.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Getter @Setter // status, errorMessages -> get(), set() 사용 가능
public class CommonException extends RuntimeException{

    //스프링에서 제공하는 응답 코드 관련 enum 상수
    private HttpStatus status;

    private Map<String, List<String>> errorMessages;

    public CommonException(String message){
        this(message, HttpStatus.INTERNAL_SERVER_ERROR);
        //응답 코드가 없는 상태로 호출할 경우, 응답코드 : 500대로 고정
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
