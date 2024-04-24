package exam04;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        //System.out.println(Math.random()); // random : 0~1사이의 무작위 난수
        //System.out.println(Math.random() * 10); // 0,1,2,3,4,5,6,7,8,9 (10미만의 무작위 난수)

        //로또 추첨 : 1~43, 6개의 숫자 뽑기! - 중복 X
        int cnt = 0;
        int[] lotto = new int[6];

        while(cnt < 6){
            int num = getNumber();
            if(chkDuplicate(lotto, num)) {
                continue; //반복하며 중복되는 숫자가 있을때는 건너뛰기!
            }
            lotto[cnt] = num;
            cnt++;
        }

        System.out.println(Arrays.toString(lotto));
    }

    public static int getNumber(){
        return (int)(Math.random() * 43) + 1;
    }
    public static boolean chkDuplicate(int[] lotto, int num){
        for (int n : lotto) {
            if (n == num)
                return true;
        }
        return false;
    }
}
