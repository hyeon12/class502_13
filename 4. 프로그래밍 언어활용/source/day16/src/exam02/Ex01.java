package exam02;

import java.util.Date;

public class Ex01 {
    public static void main(String[] args) {
        Date date = new Date(); //alt+enter
        System.out.println(date);
        int year = date.getYear();
        int month = date.getMonth();
        System.out.printf("year=%d, month=%d%n", year, month + 1);
        long epochTime = date.getTime();
        // 1970.1.1. 자정, 1000분의 1초 단위로 카운팅한 숫자
        System.out.println(epochTime); //UID(Unique ID)를 만들때 자주 활용
    }
}
