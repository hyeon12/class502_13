package exam03;

import java.text.SimpleDateFormat;
import java.util.Date;

//지금은 dateTimeFormatter 를 더 많이 사용하지만 알고 있어야 함.
public class Ex03 {
    public static void main(String[] args) {
        //ALT + ENTER -> import java.util.Date
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm");
        String strDate = sdf.format(date);
        System.out.println(strDate);
    }
}
