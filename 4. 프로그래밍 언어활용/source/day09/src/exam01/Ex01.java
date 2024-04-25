package exam01;

import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 6; i++){
            int num = rand.nextInt(); //정수범위내에서 무작위 난수 호출
            System.out.println(num);
            boolean bool = rand.nextBoolean();
            System.out.println(bool); //true,false 무작위 호출
            //double doub = rand.nextDouble();
            //System.out.println(doub);
        }
    }
}
