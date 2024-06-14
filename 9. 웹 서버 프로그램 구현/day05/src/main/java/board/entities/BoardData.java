package board.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
//매개변수가 없는 기본 생성자를 자동으로 생성
@AllArgsConstructor
//클래스에 대해 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
//빌더 패턴 : 직접 객체 생성x(new X)
//내부 빌더 클래스에서 객체를 생성 -> 값 설정 -> 객체 반환
public class BoardData {
    private long seq;
    private String subject;
    private String content;
    private String poster;
    private LocalDateTime regDt;
}
