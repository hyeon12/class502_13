package exam02;

public class Ex01 { //exam02.Ex01
    public static void main(String[] args) {
        Schedule s1 = new Schedule();
        //s1.year = 2024;
        //s1.month = 2;
        //s1.day = 31; // 변수에 직접 대입 -> 통제 불가능! 지양해야함.

        s1.setYear(2024);
        s1.setMonth(2);
        s1.setDay(31);

        int month = s1.getMonth(); //은닉되어있는 정보에 접근 가능
        System.out.println(month);

        s1.showDate();
    }
}