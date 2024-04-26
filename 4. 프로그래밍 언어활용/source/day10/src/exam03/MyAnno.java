package exam03;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({TYPE, METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    int min() default 10; // min 설정 항목, 기본값 10
    int max() default 100; // max 설정 항목
    String[] names() default{"이름1", "이름2"};
    //기본값 설정하지 않으면 반드시 값 넣어야함!
    String value();// 1개만 설정하는 경우 value

}


