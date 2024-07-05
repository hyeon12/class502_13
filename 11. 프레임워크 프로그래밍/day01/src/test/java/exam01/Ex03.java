package exam01;

import exam01.config.AppCtx;
import exam01.config.AppCtx2;
import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.services.InfoService;
import exam01.member.services.JoinService;
import exam01.member.services.LoginService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {

    @Test
    void test1(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);

        JoinService joinService = ctx.getBean(JoinService.class);
        InfoService infoService = ctx.getBean(InfoService.class);

        RequestJoin form = RequestJoin.builder()
                        .email("user01@test.org")
                        .password("12345678")
                        .confirmPassword("12345678")
                        .userName("사용자01")
                        .build();
        joinService.process(form);

        infoService.printList();

        ctx.close();
    }

    @Test
    @DisplayName("AppCtx + AppCtx2")
    void test2(){
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class, AppCtx2.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        JoinService joinService = ctx.getBean(JoinService.class); //AppCtx2
        InfoService infoService = ctx.getBean(InfoService.class); //AppCtx2

        RequestJoin form = RequestJoin.builder()
                .email("user01@test.org")
                .password("12345678")
                .confirmPassword("12345678")
                .userName("사용자01")
                .build();
        joinService.process(form);

        infoService.printList();

        Greeter g1 = ctx.getBean(Greeter.class); //AppCtx
        g1.hello("테스트");

        LoginService l1 = ctx.getBean(LoginService.class);
        System.out.println(l1);

        ctx.close();
    }


}
