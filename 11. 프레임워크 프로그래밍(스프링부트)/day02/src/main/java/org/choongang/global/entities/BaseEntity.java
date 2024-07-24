package org.choongang.global.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass // 공통 사용할 상위 클래스
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {              // 매번 공통 사용될 경우, 따로 정의 -> 사용 편의성
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime modifiedAt;
}
