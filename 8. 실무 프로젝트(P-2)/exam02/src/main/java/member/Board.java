package member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private long seq;
    private String poster;
    private String subject;
    private String content;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
