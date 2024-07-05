package exam01.config;

import exam01.member.services.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx3 {
    @Bean
    public LoginService loginService(){
        return new LoginService();
    }
}
