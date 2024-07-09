package config;

import exam01.Calculator;
import exam01.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //설정 클래스
//@EnableAspectJAutoProxy(proxyTargetClass = true) //AOP 자동 설정 애노테이션
@EnableAspectJAutoProxy
public class AppCtx {

    @Bean
    public ProxyCalculator2 proxyCalculator(){
        return new ProxyCalculator2();
    }

    /*
    @Bean //수동 등록 빈
    public RecCalculator cal (){
        return new RecCalculator();
    }
     */

    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }
}
