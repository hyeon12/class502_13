package org.choongang;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor //매개변수가 없는 기본생성자
@AllArgsConstructor //매개변수가 있는 생성자
public class SocketData {
    private String from; //보내는쪽
    private String to; //받는쪽
    private String message;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt; //전송시간
    //자바객체만으로는 변환x jackson-datatype-jsr310 추가 필요!
}
