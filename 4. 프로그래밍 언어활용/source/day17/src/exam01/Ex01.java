package exam01;

import java.util.Calendar;

public class Ex01 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance(); //정적메서드로 객체 생성
        printDate(cal);

        //cal.set(Calendar.MONTH, 11); //12월 //원 객체를 바꿈
        cal.add(Calendar.DAY_OF_MONTH, 150); //150일 후
        printDate(cal);

        cal.add(Calendar.DAY_OF_MONTH, -100); //100일 전
        printDate(cal);
    }

    public static void printDate(Calendar cal){
        int year = cal.get(Calendar.YEAR);//정적 상수로
        int month = cal.get(Calendar.MONTH);//0~11, 1월=0
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.printf("year=%d, month=%d, day=%d%n", year, month+1, day);
    }
}