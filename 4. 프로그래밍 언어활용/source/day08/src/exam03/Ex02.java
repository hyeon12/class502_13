package exam03;

import java.sql.SQLOutput;

public class Ex02 {
    public static void main(String[] args) {
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(10);
        System.out.printf("num1 주소: %d%n", System.identityHashCode(num1));
        System.out.printf("num2 주소: %d%n", System.identityHashCode(num2));
        //객체를 새로 만들어 num1, num2 주소가 다르다! -> 자원의 낭비!!

    }
}
