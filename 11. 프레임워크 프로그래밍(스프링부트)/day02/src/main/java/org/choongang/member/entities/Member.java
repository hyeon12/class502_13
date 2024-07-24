package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.constants.Authority;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
//@Table(name="CH_MEMBER") // 테이블 이름이 클래스 명과 다른 경우
/*
@Table(indexes = {
        @Index(name="idx_created_at_desc", columnList="createdAt DESC"),
        @Index(name="uq_email_password", columnList = "email, password", unique = true)
        })*/

public class Member extends BaseEntity {
    @Id /* @GeneratedValue(strategy=GenerationType.AUTO) */ @GeneratedValue
    private Long seq;

    @Column(length=60, nullable = false, unique = true)
    private String email;

    @Column(length=65, nullable = false)
    private String password;

    @Column(length=40, nullable = false, name="name")
    private String userName;

    @Column(length=10)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    //@Lob
    @Transient // 내부에서 2차 가공해서 넣어줄 데이터
    private String introduction;

    /*
    @CreationTimestamp
    private LocalDateTime createdAt; //생성 일자

    @UpdateTimestamp
    private LocalDateTime modifiedAt; //수정 일자
     */

    /*
    @Temporal(TemporalType.DATE) //날짜만
    private Date date;
     */
}
