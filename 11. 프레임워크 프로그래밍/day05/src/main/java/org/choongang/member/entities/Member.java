package org.choongang.member.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table //테이블 명이 다를 경우, @Table("테이블 명") 으로 매칭

public class Member {
    @Id //기본키 명시
    //@Column("ID")
    private Long seq;

    private String email;

    private String password;

    private String userName;

    private LocalDateTime regDt;
}
