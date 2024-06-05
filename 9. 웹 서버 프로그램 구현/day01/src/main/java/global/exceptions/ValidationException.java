package global.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String message){
        super(message);//생성자 매개변수로 메세지 이용할 수 있게!
    }
}
