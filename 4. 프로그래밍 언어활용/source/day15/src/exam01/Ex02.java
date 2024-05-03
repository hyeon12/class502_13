package exam01;

import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) {
        int total = IntStream.rangeClosed(1, 100).sum();
        System.out.println(total);

        //1~100 홀수만 더하기! filter(판별식-참이면 통과!)
        int total2 = IntStream.rangeClosed(1, 100).filter(s -> s % 2 == 1).sum();
        System.out.println(total2);
    }
}
