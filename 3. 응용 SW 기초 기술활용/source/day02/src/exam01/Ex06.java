package exam01;

public class Ex06 {
    public static void main(String[] args) {
        int total = 0;
        int i = 0, j = 10;
        for (; ; i++, j += 2){
            if (i > 100) { // 조건식 : 반복을 진행/중단 시키는 조건
                break;
            }
            total += i;
            System.out.println("j:" + j);
        }

        System.out.println("합계 : " + total);

    }


    //for ( ; ; ) { } == while(true) { ... }
}
