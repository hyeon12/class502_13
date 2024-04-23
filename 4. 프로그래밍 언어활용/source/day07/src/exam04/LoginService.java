package exam04;

public class LoginService {
    public void login(String userId, String userPw) //예외전가 Ex01
    {
        //userId - user01, userPw - 123456 으로 고정하고 검증
        try {
            if (!userId.equals("user01")) {//user01이 아닌 Id 일때는!
                throw new UserIdException("아이디가 일치하지 않습니다.");//throw로 객체 던진다.
            }

            if (!userPw.equals("123456")) {
                throw new UserPwException("비밀번호가 일치하지 않습니다.");
            }

            System.out.println("로그인 성공");
        } catch (UserIdException | UserPwException e) {
            System.out.println(e.getMessage()); //위에 입력된 문구 = getmessage
        }
    }
}
