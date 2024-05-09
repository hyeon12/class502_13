package exam01;

import java.time.Instant;

public class Ex01 {
    public static void main(String[] args) {
        Instant today = Instant.now();
        System.out.println(today);

        long time1 = today.getEpochSecond(); // 초 단위 - timeStamp
        long time2 = today.toEpochMilli(); //밀리초 단위 - EpochTime
        //매우 짧은 단위 - 중복x -> uniqueID 만들때 사용

        System.out.printf("time1=%d, time2=%d%n", time1, time2);
    }
}
