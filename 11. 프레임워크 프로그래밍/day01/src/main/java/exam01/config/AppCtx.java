package exam01.config;

import exam01.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 프레임워크쪽 애노테이션(@Configuration : 설정 클래스)
// 설정 클래스 - 스프링 컨테이너가 관리할 객체를 정의, 설정
@Configuration
public class AppCtx {

    @Bean //대신 관리해주지만, @Bean 을 붙여 관리하는 객체임을 명시
    public Greeter greeter(){
        return new Greeter();
    }
}
