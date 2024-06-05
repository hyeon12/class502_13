package member.services;

import global.validators.Validator;
import member.controllers.RequestJoin;


public class JoinService {

    private Validator<RequestJoin> validator;

    //개방폐쇄의 원칙을 이용하여 통제 가능하도록
    public JoinService(Validator<RequestJoin> validator){
        this.validator = validator;
    }

    //process 회원가입 양식 매개변수로 추가 -> 데이터가 넘어오면 검증
    public void process(RequestJoin form){
        validator.check(form);
    }

        /**
         *필수요소 5개 -> 아래와 같은 코드로 반복하는 것이 좋을까?
         * 예상가능한 검증 틀을 만들어 사용하는 것이 좋다
         * 공통적인 설계틀 ... 인터페이스! 지네릭스!
         * 코드의 지속적인 리팩토링을 통해 즉각적인 수정 보완이 중요하다!!
         * global 쪽의 validators 에 .. 리팩토링 해보잡
         */
        /*
        public void process(RequestJoin form){
            String email = form.getEmail();
            //email이 null이거나, 문자열이지만 공백일때
            if(email == null || email.isBlank()){
                throw new ValidationException("이메일을 입력하세요.");
            }
            String password = form.getPassword();
            if(password == null || password.isBlank()){
                throw new ValidationException("비밀번호를 입력하세요.");
            }
        }
         */

}
