package exam01.member.controllers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RequestJoin { //전달 객체(join 서비스의 값이 전달될 데이터들)
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    private LocalDateTime regDt;
}
