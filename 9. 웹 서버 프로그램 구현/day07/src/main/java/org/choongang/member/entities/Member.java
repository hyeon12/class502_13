package org.choongang.member.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private long userNo;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime regDt; //회원가입일자
    private LocalDateTime modDt; //회원정보 수정일자
}
