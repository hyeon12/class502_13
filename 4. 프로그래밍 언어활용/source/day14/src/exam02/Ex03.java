package exam02;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        /* 3가지 작업 처리해보자!
        (1) 문자열 앞 뒤로 * ...*
        (2) 대문자 변환
        (3) 출력
         */

         String[] fruits = {"apple", "orange", "mango", "melon"};
         Arrays.stream(fruits).map(s -> "*" + s + "*") //(1)
                            .map(String::toUpperCase) //(2)
                            .forEach(System.out::println); //(3)
    }
}
