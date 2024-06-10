package member.validators;

import global.exceptions.ValidationException;
import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;

public class LoginValidator implements Validator<HttpServletRequest>, RequiredValidator {
    @Override
    public void check(HttpServletRequest form) {
//        단일책임의 원칙 - "검증" 이라는 하나의 기능만 구현하도록
//        String email = form.getParameter("email");
//        if(email == null || email.isBlank()){
//            throw new ValidationException("이메일을 입력하세요.");
//        } -> RequiredValidator 인터페이스로 해당 기능 구현

        String email = form.getParameter("email");
        String password = form.getParameter("password");

        /* 필수 항목 검증 S */
        checkRequired(email, new ValidationException("이메일을 입력하세요."));
        checkRequired(password, new ValidationException("비밀번호를 입력하세요."));
        /* 필수 항목 검증 E */

    }
}
