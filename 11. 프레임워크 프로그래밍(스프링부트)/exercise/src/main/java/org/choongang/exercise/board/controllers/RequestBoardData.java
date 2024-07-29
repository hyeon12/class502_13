package org.choongang.exercise.board.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestBoardData {
    @NotBlank
    private String poster;

    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
