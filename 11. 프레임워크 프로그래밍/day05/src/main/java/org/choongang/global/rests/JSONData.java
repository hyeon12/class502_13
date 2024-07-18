package org.choongang.global.rests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@RequiredArgsConstructor //final 과 NonNull 지정 필드를 매개 변수로!
public class JSONData {
    // 성공 시 데이터 전송 | 실패 시 메세지 출력
    private HttpStatus status = HttpStatus.OK; // Http 상태 코드 (데이터 제공 -> 보통 OK)
    private boolean success = true; // 요청에 대한 성공 여부
    private Object message; // 에러 메세지 또는 기타 정보
    @NonNull // * data -> final 쓰지 않은 이유? 값이 교체 가능하도록
    private Object data; //응답 데이터 -> 서버에서 처리된 결과! 실제 전송될 데이터
}

/**
 * JSONData -> 통일성 있는 응답을 위해 틀을 만든 것
 * private Object message; -> result, msg ... 다르지 않도록! message 로 고정
 * Object message -> 필드 - 에러메세지 키와 값 형태 Map으로 출력하기 위해 */