package org.hyeon.day90.board.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestBoardData {
    private Long seq;
    @NotBlank
    private String poster;

    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}
