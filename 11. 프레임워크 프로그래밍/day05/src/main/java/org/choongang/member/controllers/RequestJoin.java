package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestJoin { //데이터 전달용 객체
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    private boolean agree;
}
