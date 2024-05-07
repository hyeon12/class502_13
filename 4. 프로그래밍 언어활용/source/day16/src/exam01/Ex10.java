package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2", "이름3");
        List<String> fruits = Arrays.asList("Apple", "Orange", "Melon");

        //스트림 안에 스트링이 들어간, 중첩된 형태
        Stream<Stream<String>> stm = Stream.of(names.stream(), fruits.stream());
        //stm.forEach(System.out::println); //스트림객체 반환, 문자열X
        /*
        stm.forEach(st -> {
            st.forEach(System.out::println);
        });
        */
        //stm.flatMap(s -> s).forEach(System.out::println); //중첩된 형태를 평탄화
        String[] strs = stm.flatMap(s -> s).toArray(String[]::new);
        System.out.println(Arrays.toString(strs));
    }
}
