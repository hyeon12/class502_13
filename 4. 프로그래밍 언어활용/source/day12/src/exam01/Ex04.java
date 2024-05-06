package exam01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex04 {
    public static void main(String[] args) {
        //Set<String> names = new HashSet<>();

        /*
        Comparator<String> comp = new Comparator<String>() {//인터페이스 객체구현
            @Override
            public int compare(String o1, String o2) {
                //return o1.compareTo(o2); // 오름차순
                //return o2.compareTo(o1); //내림차순
                return o1.compareTo(o2) * -1; //내림차순
            }
        };
         */

        //Set<String> names = new TreeSet<>(comp);
        Set<String> names = new TreeSet<>(Comparator.reverseOrder());//정렬역순
        names.add("이름2");
        names.add("이름2");
        names.add("이름1");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        //set - 중복 X, 순서 중요X
        //Hash.. 검색이 주 목적이므로, 안에서 검색에 최적화된 순서로 정렬되어 나옴.
        System.out.println(names); //names.toString() 재정의
    }
}
