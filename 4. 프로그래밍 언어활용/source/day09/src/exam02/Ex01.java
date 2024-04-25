package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01 {
    public static void main(String[] args) {
        String str = "I like java and javascript";

        Pattern p1 = Pattern.compile("java");//생성자 정의X -> 컴파일통해 객체생성!!
        Matcher m1 = p1.matcher(str);

        System.out.println(m1.find());
        System.out.println(m1.group()); //패턴에 일치하는 문자열

        System.out.println(m1.find());
        System.out.println(m1.group()); //패턴에 일치하는 문자열

        System.out.println(m1.find()); //호출할때마다 커서 이동하면서 찾는다
        System.out.println(m1.group());
    }
}
