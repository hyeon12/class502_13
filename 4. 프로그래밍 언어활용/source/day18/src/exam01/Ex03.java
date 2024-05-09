package exam01;

import java.time.Duration;
import java.time.LocalTime;
import java.util.function.DoubleFunction;

public class Ex03 {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime endTime = LocalTime.of(17, 50);

        Duration du = Duration.between(now, endTime);
        long seconds = du.getSeconds();
        LocalTime time = LocalTime.of(0, 0, 0);
        LocalTime time2 = time.plusSeconds(seconds);
        int hours = time2.getHour();
        int minutes = time2.getMinute();
        int sec = time2.getSecond();
        System.out.printf("수업 종료까지 %d시간, %d분, %d초 남았습니다.😎%n", hours, minutes, sec);
    }
}
