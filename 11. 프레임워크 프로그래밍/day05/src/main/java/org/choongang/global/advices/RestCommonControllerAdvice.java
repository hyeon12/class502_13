package org.choongang.global.advices;

import org.choongang.global.exceptions.CommonException;
import org.choongang.global.rests.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class RestCommonControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONData> errorHandler(Exception e) {
        // 발생하는 응답 코드(에러)가 다르기 때문에 매번 달라질 수 있도록...! ResponseEntity

        Object message = e.getMessage(); //Exception 객체로부터 메시지를 가져와 message 변수에 저장 (일반적인 기본 메시지)

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500 - 기본 예외 발생한 경우..

        if (e instanceof CommonException commonException) { //CommonException(내가 정의한!!!) 타입의 예외 발생 시
            status = commonException.getStatus(); // 해당 예외에서 정의한 상태 코드와 오류 메시지를 사용

            Map<String, List<String>> errorMessages = commonException.getErrorMessages();
            // 내가 설정한!! 상태 코드 가져옴
            if(errorMessages != null) message = errorMessages;
            //일반 문구 x, Map 형태의 커맨드 객체 검증 메세지로 교체!
        }

        JSONData data = new JSONData();
        data.setSuccess(false);
        data.setMessage(message);
        data.setStatus(status); //달라진 응답 코드를 JSON 형식에도 담는 것

        e.printStackTrace();

        return ResponseEntity.status(status).body(data);
    }
}
