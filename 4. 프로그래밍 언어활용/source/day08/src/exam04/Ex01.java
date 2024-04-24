package exam04;

import static java.lang.Math.*;
//유용한 클래스 - java.lang.Math
public class Ex01 {
    public static void main(String[] args) {
        System.out.println(abs(-10)); // Math.abs(-10) 절대값 : 10 -> import 통해 Math 생략 가능
        System.out.println(ceil(10.2)); // 올림 : 11.0
        System.out.println(floor(10.2)); // 버림 : 10.0
        System.out.println(round(10.5)); // 반올림 : 11
        System.out.println(pow(2,4)); // 2의 4승 : 16.0
        System.out.println(sqrt(9)); // root값 : 3.0
    }
}
