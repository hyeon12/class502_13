package org.hyeon.day90.board.constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
public class BoardData {
    @Id @GeneratedValue
    private Long seq;

    @Column(nullable = false)
    private String poster;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;
}
