package exam01.member.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestLogin { //로그인 서비스에 필요한 데이터
    private String email;
    private String password;
}
