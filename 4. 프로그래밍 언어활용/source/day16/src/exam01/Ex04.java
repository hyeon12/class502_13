package exam01;

import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) {
        int[] scores = {67, 80, 100, 45, 98, 77};
        int max = Arrays.stream(scores)
                        //.reduce((a, b) -> a > b? a : b)
                        .reduce((a, b) -> {
                            System.out.printf("a=%d, b=%d%n", a, b);
                            int m = a > b? a : b;
                            return m; //반환값 m이 a에 대입됨.
                        })
                        .getAsInt();
        System.out.println(max);
    }
}
