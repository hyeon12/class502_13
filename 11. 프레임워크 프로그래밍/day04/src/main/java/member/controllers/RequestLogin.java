package member.controllers;

import lombok.Data;

@Data
public class RequestLogin {
    //로그인 사용자가 입력한 정보가 전달될 데이터 클래스
    private String email;
    private String password;
    private boolean saveEmail;
}
