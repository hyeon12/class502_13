package config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointcut {
    //자주 쓰는 Pointcut 의 경우, 따로 정의하여 사용할 수 있음

    @Pointcut("execution(* exam01..*(..))")
    public void publicTarget(){

    }
}
