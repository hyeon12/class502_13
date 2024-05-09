package calendarex;

import java.time.LocalDate;

//매월 1일이 무슨 요일에 시작하는지?
public class Ex01 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate startDate = LocalDate.of(today.getYear(), today.getMonth(), 1);

        int yoil = startDate.getDayOfWeek().getValue(); //1(월)~7(일)
        //요일을 0(일)~6(토) -> yoil % 7 나머지 연산자로 바꿀 수 있다.
        System.out.println(yoil);//시작 요일 구하기!

        LocalDate endDate = startDate.plusMonths(1).minusDays(1);//다음달-1일
        System.out.println(endDate);//마지막 날짜를 구하기!
    }
}
