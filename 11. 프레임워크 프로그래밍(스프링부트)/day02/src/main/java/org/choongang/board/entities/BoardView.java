package org.choongang.board.entities;

import jakarta.persistence.*;
import lombok.Data;
/*
@Data
@Entity
public class BoardView {
    @EmbeddedId
    private BoardViewId id;
}*/
@Data
@Entity
@IdClass(BoardView.class)
public class BoardView {
    //뷰 카운트를 저장할 수 있는 엔티티
    @Id
    private long seq;

    @Id
    @Column(name="_uid")
    private int uid; //uid - 오라클 예약어 (@Column(name) / "")
}
