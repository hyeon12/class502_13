package member.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
public class Member {
    @Id //기본키 명시
    private long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime regDt;
}
