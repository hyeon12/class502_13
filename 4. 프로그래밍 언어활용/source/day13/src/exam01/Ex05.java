package exam01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {
        char[] chars1 = new char[10];
        Arrays.fill(chars1, '*');
        System.out.println(Arrays.toString(chars1));

        // Id: user01 -> use****
        String userId = "user01";
        char[] chars2 = userId.toCharArray();
        Arrays.fill(chars2, 3, userId.length(), '*');
        System.out.println(Arrays.toString(chars2));
        userId = String.valueOf(chars2);

        System.out.println(userId);
        //System.out.println(chars2);
    }
}
