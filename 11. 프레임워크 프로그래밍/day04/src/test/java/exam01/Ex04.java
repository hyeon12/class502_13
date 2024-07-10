package exam01;

import config.AppCtx;
import member.controllers.RequestJoin;
import member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
@Transactional //롤백으로 DB 저장x
public class Ex04 {

    @Autowired
    private JoinService service;

    @Test
    void test1(){
        RequestJoin form = new RequestJoin();
        form.setEmail("user99@test.org");
        form.setPassword("12345678");
        form.setConfirmPassword(form.getPassword());
        form.setUserName("김구구");
        form.setAgree(true);
        service.process(form);
    }
}
