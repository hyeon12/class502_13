package org.choongang.exercise.board.entities;

import jakarta.persistence.*;
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

    @Lob
    private String content;
}
