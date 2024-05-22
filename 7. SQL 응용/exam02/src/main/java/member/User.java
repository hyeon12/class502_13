package member;

import java.time.LocalDateTime;

//빌더패턴 - 객체를 직접 생성x, 내부에서 생성!
public class User {

    private String userId;
    private String userNm;
    private String email;
    private LocalDateTime regDt;

    private User(){}

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNm='" + userNm + '\'' +
                ", email='" + email + '\'' +
                ", regDt=" + regDt +
                '}';
    }

    //User 클래스 내부에 정적 클래스 Builder (이 안에 객체 생성)
    public static class Builder {
        private User user = new User(); //내부에 객체 생성 후, 아래 값 할당

        //멤버변수와 동일한 방법으로 사용
        //메서드 체이닝 기법 활용
        //각 메서드 호출이 객체 자신을 반환하도록 하여, 여러 메서드 호출을 하나의 문장으로 연결할 수 있게 함!

        public Builder userId(String userId){
            user.userId = userId;
            return this;
        }

        public Builder userNm(String userNm){
            user.userNm = userNm;
            return this; //내부에 정의된 메서드를 사용
        }

        public Builder email(String email){
            user.email = email;
            return this;
        }

        public Builder regDt(LocalDateTime regDt){
            user.regDt = regDt;
            return this;
        }

        //완성된 객체를 내보내는 build()
        public User build(){
            return user;
        }

    }
}
