package chapter05.exercise;

public class MyDateTest {
    public static void main(String[] args) {
        //setDay()의 switch(month) ~ case 구문에서 case2인 경우 day는 1~29까지만 유효하므로
        MyDate date1 = new MyDate(1, 2, 2000);
        //isValid메서드는 false가 된다.
        System.out.println(date1.isValid());

        MyDate date2 = new MyDate(0, 10, 2006);
        System.out.println(date2.isValid());

        //LocalDateTime.now().getYear() 현재 연도까지의 달력에서 존재하지 않는 연도 입력 시에만 유효
        MyDate date3 = new MyDate(2, 10, 2300);
        //2300년은 현재 달력까지의 날짜에서 없는 날짜이므로, false!
        System.out.println(date3.isValid());
    }
}
