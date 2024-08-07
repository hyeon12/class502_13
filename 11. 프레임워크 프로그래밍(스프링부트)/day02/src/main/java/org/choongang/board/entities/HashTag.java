package org.choongang.board.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class HashTag {
    @Id
    private String tag;

    /*
    @ToString.Exclude
    @ManyToMany(mappedBy = "tags")
    private List<BoardData> items;
     */
}
