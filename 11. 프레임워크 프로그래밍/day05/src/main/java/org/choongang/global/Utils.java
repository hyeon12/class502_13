package org.choongang.global;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Utils { //검증 실패 시 호출할 메세지
    // 필드명과 에러 메세지를 가공
    // 에러 코드가 넘어오면 해당되는 메세지 출력될 수 있도록

    private final MessageSource messageSource;
    private final HttpServletRequest request;


    //getAllErrors 로 가져오는 대신, FiledErrors / GlobalErrors 나눠서 가져옴!
    // All - 단순하나... 어느 필드에서 에러가 발생했는지 명확히 알 수 없고,
    // 필드 발생 에러 / 폼 발생 에러를 구별하기 어려움

    //조금 더 자세하고 명확한 메세지 출력을 위해 ...!!!!
    // String(필드명) / List<String> 에러 메세지
    public Map<String, List<String>> getErrorMessages(Errors errors){
        // FiledErrors - 개별 필드에 특정된 에러 (어느 필드에서 문제가 발생했는지 알려줌)
        Map<String, List<String>> messages = errors.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, e -> getCodeMessages(e.getCodes()) ));

        // GlobalErrors - 전체 폼에 관련된 에러 (특정 필드에 국한 x)
        List<String> gMessages = errors.getGlobalErrors()
                .stream()
                .flatMap(e -> getCodeMessages(e.getCodes()).stream()).toList();
        if(!gMessages.isEmpty()){
            messages.put("global", gMessages);
        }

        return messages;
    }

    public List<String> getCodeMessages(String[] codes){
        ResourceBundleMessageSource ms = (ResourceBundleMessageSource) messageSource;
        ms.setUseCodeAsDefaultMessage(false);
        // 없는 메세지일 경우 예외 발생 대신, 코드를 기본 메세지로 하는 메서드,
        // MessageConfig 쪽에서 true 설정 -> 오류 코드로 출력됨 => false로 변경

        List<String> messages = Arrays.stream(codes)
                .map(c -> {
                    try{
                        return ms.getMessage(c, null, request.getLocale());
                        //getMessage -> args : 치환될 부분 ex)) LOGIN_MSG = {0}({1}) logged in...
                        //그러나 에러 메세지는 그대로 사용되고, 교체될 부분이 없기 때문에 args : null 로 설정

                    }catch (Exception e){
                        return "";
                    }
                })
                .filter(s -> s != null && !s.isBlank())
                .toList();

        ms.setUseCodeAsDefaultMessage(true); //싱글톤으로 관리되기 때문에 사용후에 다시 true
        return messages;
    }
}
