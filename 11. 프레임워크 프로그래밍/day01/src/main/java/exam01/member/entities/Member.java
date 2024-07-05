package exam01.member.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

//VO : 데이터 전달용 객체
@Data
@Builder
public class Member {
    private long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime regDt;
}
