package exam03;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        Class cls = Ex02.class;

        MyAnno anno = (MyAnno)cls.getAnnotation(MyAnno.class);
        //정의했던 추상메서드의 구현된 값을 볼 수 있다!

        int min = anno.min();
        int max = anno.max();
        //외부에서 정의할 수 있다? 객체가 되었다는 것!
        //Class 클래스에서 설정값을 반환값으로 하는 객체가 내부적으로 정의
        System.out.printf("min=%d, max=%d%n", min, max);

        String[] names = anno.names();
        System.out.println(Arrays.toString(names));

        String value = anno.value();
        System.out.println(value);
    }
}
