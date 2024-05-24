package member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

//DB에 있는 데이터를 담기 위한 목적

@Data
@Builder
public class Member {
    //(원칙) DB의 필드 컬럼명과 이름이 같아야 자동 맵핑 가능
    //그런데 자바 변수명 규칙에 맞춰 쓰게 되면, 오류가 발생한다.
    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String mobile;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
