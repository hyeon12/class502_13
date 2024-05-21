package member;

import lombok.*;

import java.time.LocalDateTime;

//@Getter @Setter @ToString @EqualsAndHashCode
//Getter, Setter 애노테이션 정의 -> 멤버변수에 대한 get,set 메서드 정의
@Data
@NoArgsConstructor //(access=AccessLevel.PRIVATE) //기본생성자 (접근제어범위)
@AllArgsConstructor
//데이터 클래스 - 값을 담아 설정하고, 조회할 수 있는 클래스
public class Member {
    //멤버변수 정의
    private String userId;
    private String userNm;
    private String email;
    private LocalDateTime regDt;
}

