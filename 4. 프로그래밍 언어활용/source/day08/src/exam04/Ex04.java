package exam04;

import java.util.Objects;

//java.util.Objects 클래스의 requiredNonNullElse() 메서드
// -> 특정변수가 null이면 기본값을 부여
public class Ex04 {
    public static void main(String[] args) {
        String str = null;

        str = Objects.requireNonNullElse(str, "");//Null에 대한 오류를 처리하기 위해 사용하는 메서드

        str.toUpperCase(); //NullPointerException 발생 -> Null에 대한 처리가 중요하다..!
    }
}
