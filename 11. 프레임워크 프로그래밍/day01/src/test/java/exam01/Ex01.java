package exam01;

import exam01.config.AppCtx;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void test(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        // 스프링 컨테이너 객체 - 설정 클래스.clz 를 매개변수로 어떤 객체를 관리할지 정보를 제공

        Greeter g1 = ctx.getBean("greeter", Greeter.class);//1 : 메서드명(Bean 의 이름) / 2 : 클래스 clz
        g1.hello("스프링");

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        g2.hello("자바");

        System.out.println(g1 == g2); //주소 비교 (true) : 싱글톤패턴

        ctx.close();
    }

    @Test
    void test2(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        //싱글톤으로 기본 관리하므로 객체가 한개만 있는 경우가 많다
        //Class 클래스만 있어도 찾는다.
        Greeter g1 = ctx.getBean(Greeter.class);
        g1.hello("싱글톤");

        ctx.close();
    }
}
