package exam02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ex01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2", "이름3", "이름4", "이름5");

        names.forEach(s -> System.out.println(s));
        /*
        names.forEach(new Consumer<String>() {//인터페이스의 객체가 되는 조건을 활용해 매개변수로 활용!
            @Override
            public void accept(String s) {//

            }
        });*/
    }
}
