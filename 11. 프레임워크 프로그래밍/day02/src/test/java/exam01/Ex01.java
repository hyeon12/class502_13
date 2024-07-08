package exam01;

import config.AppCtx;
import member.controllers.RequestJoin;
import member.services.InfoService;
import member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {

    @Test
    void test1(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        //ApplicationContext = 스프링 컨테이너 / AnnotationConfig - 설정 방식(애노테이션으로 설정)
        JoinService joinService = ctx.getBean(JoinService.class);
        //전달 객체를 만들어 가입 + 출력까지 해보자
        InfoService infoService = ctx.getBean(InfoService.class);
        RequestJoin form = RequestJoin.builder()
                        .email("test01@test.org")
                        .password("12345678")
                        .confirmPassword("12345678")
                        .userName("사용자01")
                        .build();
        joinService.process(form);
        infoService.printList();

        ctx.close();
    }
}
