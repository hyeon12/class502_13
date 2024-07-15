package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberMapper mapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // Bean Validation 검증 실패시에는 다음 검증을 진행 X
        if(errors.hasErrors()){
            return;
        }

        /**
         * 필수 항목 검증(email, password) => 커맨드 객체 쪽에 정의
         *
         *
         * email로 회원이 조회되는지 검증 (exists)
         *조회된 회원의 비밀번호가 입력한 비밀번호 값과 일치하는지 검증 (equals)
         * */

        RequestLogin form = (RequestLogin) target;
        String email = form.getEmail();
        String password = form.getPassword();

        if(StringUtils.hasText(email)){
            Member member = mapper.get(email);
            if(member == null){
                //errors.rejectValue("email", "Check.emailPassword");
                errors.reject("Check.emailPassword");
            }

            if(member != null && StringUtils.hasText(password) && !BCrypt.checkpw(password, member.getPassword())){
                //errors.rejectValue("password", "Check.emailPassword");
                errors.reject("Check.emailPassword");
            }

        }



        // 회원 조회 StringUtils.hasText(email) && mapper.exists(email) != 0L
        /*
        if(!StringUtils.hasText(email) && mapper.exists(email)!=0L){
            errors.rejectValue("email", "MisMatch");
        }

        if(!StringUtils.hasText(password) && !password.equals(mapper.get(password))){
        }
         */
    }
}
