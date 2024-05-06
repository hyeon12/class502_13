package exam01;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Ex07 {
    public static void main(String[] args) {
        ToIntFunction<String> func1 = s -> s.length(); //문자열 투입, 문자길이 반환
        ToIntFunction<String> func2 = String::length;
        System.out.println(func1.applyAsInt("가나다"));
        System.out.println(func2.applyAsInt("가나다"));

        BiPredicate<String, String> cond1 = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> cond2 = String::equals;
    }

}
