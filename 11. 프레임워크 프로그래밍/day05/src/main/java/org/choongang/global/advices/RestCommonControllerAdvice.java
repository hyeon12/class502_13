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

        Object message = e.getMessage();

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
        if (e instanceof CommonException commonException) {
            status = commonException.getStatus();

            Map<String, List<String>> errorMessages = commonException.getErrorMessages();
            if(errorMessages != null) message = errorMessages; //커맨드 객체 검증 메세지
        }

        JSONData data = new JSONData();
        data.setSuccess(false);
        data.setMessage(message);
        data.setStatus(status); //달라진 응답 코드를 JSON 형식에도 담는 것

        e.printStackTrace();

        return ResponseEntity.status(status).body(data);
    }
}
