package exam03;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex02 {
    public static void main(String[] args) throws ParseException {
        String price = "1,000,000원";

        //Number를 반환값으로 정의한 이유?
        //parse는 형식화된 문자열을 숫자로! but 자료형으로 어떤 자료형이 필요할 지 모름
        //모든 기본자료형의 상위, Number
        //Number(Integer, Double, 등.. 기본 자료형의 Wrapper 클래스의 상위 클래스)

        DecimalFormat df = new DecimalFormat("#,###원");
        Number number = df.parse(price);
        long num = number.longValue();
        System.out.println(num);

    }
}
