package exam01.config;

import exam01.member.dao.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "exam01.member") - 스캔할 범위를 지정
//@ComponentScan(value = "exam01.member")
@ComponentScan("exam01.member")
public class AppCtx3 {
    //@Bean
    public MemberDao memberDao() {
        System.out.println("수동 등록 빈!");
        return new MemberDao();
    }



    // 수동 등록 빈이랑 어떤 부분에서 충돌이 난다고 하신거지..?
}