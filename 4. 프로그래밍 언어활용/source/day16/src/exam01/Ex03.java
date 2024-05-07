package exam01;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[] scores = { 67, 80, 100, 45, 98, 77 };
        int total = Arrays.stream(scores).reduce(0, (n1, n2) -> {
            System.out.printf("n1=%d, n2=%d%n", n1, n2);
            n1 += n2;
            return n1;//반환값이 첫번째 매개변수(n1)로 반복됨
        });
        System.out.println(total);
    }
}
