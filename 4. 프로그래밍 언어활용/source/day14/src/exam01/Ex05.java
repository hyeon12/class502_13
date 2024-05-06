package exam01;

import java.util.function.Function;
import java.util.function.IntFunction;

public class Ex05 {
    public static void main(String[] args) {
        Function<String, Integer> func1 = s -> s.length(); //문자열길이
        Function<Integer, Integer> func2 = x -> x * x; //제곱

        Function<String, Integer> func3 = func1.andThen(func2); //함수결합(func1->func2 실행)
        Function<String, Integer> func4 = func2.compose(func1); //함수결합(func2->func1 실행)

        int num = func3.apply("가나다"); //가나다 -> 3(문자열길이) -> 9
        System.out.println(num);

        int num2 = func4.apply("가나다");
        System.out.println(num2);




        //Function<String, Integer> func1 = s -> s.length();
        //int len = func1.apply("가나다");
        //System.out.println(len);
    }
}
