package member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Board {
    private int seq; //게시글번호
    private final String subject;
    private final String content;
    private String poster;

}
