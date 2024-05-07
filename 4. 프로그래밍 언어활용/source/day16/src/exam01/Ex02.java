package exam01;

import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        Random rand = new Random();
        int firstOdd = rand.ints(100)
                            .filter(x -> x % 2 == 1)
                            .findFirst() //값이 없을 수도 있어 오류! 무작위 난수가 전부 짝수일 수도 있음.
                            .orElse(-1); //값이 없을 때는 기본값 : -1 반환
        System.out.println(firstOdd);
    }
}
