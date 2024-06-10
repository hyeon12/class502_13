package member.services;

import global.Mailer;
import global.exceptions.ValidationException;
import global.validators.Validator;
import jakarta.servlet.http.HttpServletRequest;

public class LoginService {
    //개방 폐쇄 원칙 + 상위 인터페이스 원칙 ...!
    private Validator<HttpServletRequest> validator;
    private Mailer mailer;

    public LoginService(Validator<HttpServletRequest> validator){
        this.validator = validator;
    }

    public void setMailer(Mailer mailer){
        this.mailer = mailer;
    }

    public void process(HttpServletRequest request){ //사용자가 보낸 데이터가 들어오게 됨

        validator.check(request);

        // 로그인 성공 가정
        // 성공시 메일 전송
        if(mailer != null){ //의존 관계가 아닌, 연관 관계이므로 null일 수도 있음.
            String email = request.getParameter("email");
            mailer.send(email);
            //mailer.send(email); test 쪽에서 only() - 한번만 호출 가능하므로 오류 발생
        }

//        //아이디 : email, 비밀번호 : password
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        if(email == null || email.isBlank()){
//            throw new ValidationException("이메일을 입력하세요.");
//        } //-> 단일책임의 원칙으로 따로 validator 클래스를 만들어 기능을 부여하는 것이 좋다.
    }
}
