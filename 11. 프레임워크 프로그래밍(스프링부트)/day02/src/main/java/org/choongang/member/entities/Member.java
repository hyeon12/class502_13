package org.choongang.member.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(indexes = {@Index(name="idx_created_at_desc", columnList="createdAt DESC"),
                 @Index(name="uq_email_password", columnList = "email, password", unique = true)})

public class Member {
    @Id // 기본 키 지정
    private Long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime createdAt; //생성 일자
    private LocalDateTime modifiedAt; //수정 일자
}
