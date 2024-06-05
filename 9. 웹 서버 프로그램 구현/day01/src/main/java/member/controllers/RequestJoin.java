package member.controllers;

import lombok.Builder;
import lombok.Data;

//사용자가 입력한 데이터를 전달받을 수 있는 객체(DTO)
@Data
@Builder //set, get, toString, equals and haseCode
public class RequestJoin {
    private String email; //아이디(계정인증을 위한 아이디와 같은 기능)
    private String password; //비번
    private String confirmPassword; //비번 확인
    private String userName; //사용자 이름
    private boolean termsAgree; //회원가입 약관 동의
}
