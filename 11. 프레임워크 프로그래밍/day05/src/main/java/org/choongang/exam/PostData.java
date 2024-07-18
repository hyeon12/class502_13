package org.choongang.exam;

import lombok.Data;

@Data // Ex01-test2 데이터
public class PostData {
    private long userId;
    private long id;
    private String title;
    private String body;
}
