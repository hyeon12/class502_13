package org.choongang.member.controllers;

import lombok.Data;

import java.util.List;

@Data
public class RequestJoin { //데이터 전달용 객체
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    //private String[] hobby;
    //private Set<String> hobby;
    //private List<String> hobby;
    private String hobby;
    private boolean agree;

    private Address addr;
}
