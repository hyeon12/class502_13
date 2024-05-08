package exam02;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ex07 {
    public static void main(String[] args) {
        LocalTime nowtime = LocalTime.now();
        LocalTime time = LocalTime.of(23, 30, 13);
        System.out.println(nowtime);//현재시간
        System.out.println(time);//직접지정한시간
    }
}
