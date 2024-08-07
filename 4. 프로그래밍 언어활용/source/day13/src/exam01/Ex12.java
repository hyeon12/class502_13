package exam01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex12 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름3", "이름1", "이름2", "이름4");
        Collections.sort(names);
        //기본정렬기준(Natural Order-java.lang.Comparable, int compareTo(...)
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);

        Collections.reverse(names);
        System.out.println(names);
    }
}
