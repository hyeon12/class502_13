package org.choongang.member.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLogin {
    //로그인 사용자가 입력한 정보가 전달될 데이터 클래스
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private boolean saveEmail;
}
