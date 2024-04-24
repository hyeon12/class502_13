package exam01;

import java.util.HashSet;

//동등성비교 - 중복제거 예시
public class Ex05 {
    public static void main(String[] args) {
        HashSet<String> data = new HashSet<>();
        data.add("AAA");
        data.add("BBB");
        data.add("CCC");
        data.add("AAA");
        System.out.println(data);
    }
}
