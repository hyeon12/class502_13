package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.member.constants.Authority;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
/*
@Table(indexes = {@Index(name="idx_created_at_desc", columnList="createdAt DESC"),
                 @Index(name="uq_email_password", columnList = "email, password", unique = true)})
*/
public class Member {
    @Id @GeneratedValue
    private Long seq;
    private String email;
    private String password;
    private String userName;

    //@Lob
    @Transient // 내부에서 2차 가공해서 넣어줄 데이터
    private String introduction;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @CreationTimestamp
    private LocalDateTime createdAt; //생성 일자

    @UpdateTimestamp
    private LocalDateTime modifiedAt; //수정 일자
}
