package global.exceptions;

public class ValidationException extends RuntimeException{
    //로그인 검증 실패 시, ValidationException 발생
    public ValidationException(String message){
        super(message); //상위 클래스에서 메세지 처리

    }
}
