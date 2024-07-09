package config;

import exam01.Calculator;
import exam01.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //설정 클래스
@EnableAspectJAutoProxy //AOP 자동 설정 애노테이션
public class AppCtx {

    @Bean
    public ProxyCalculator proxyCalculator(){
        return new ProxyCalculator();
    }

    @Bean //수동 등록 빈
    public Calculator cal (){
        return new RecCalculator();
    }
}
