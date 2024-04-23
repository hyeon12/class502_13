package exam04;

public class UserIdException extends RuntimeException {

    public UserIdException(String message){
        super(message); //super()는 메세지 처리가 안돼서, super(message);
    }
}
