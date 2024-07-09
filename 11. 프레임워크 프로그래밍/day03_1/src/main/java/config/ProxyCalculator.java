package config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect //aop 공통 기능 정의 클래스
public class ProxyCalculator {

    @Pointcut("execution(* exam01..*(..))") //공통 기능을 적용할 범위 / 메서드 패턴
    public void publicTarget(){}

    @Before("publicTarget()")
    public void before(JoinPoint joinPoint){
        System.out.println("Before..");
    }

    @After("publicTarget()")
    public void after(JoinPoint joinPoint){
        System.out.println("After..");
    }

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
        //반환값을 범용적인 형태인 Object로 지정

        /*
        Signature sig = joinPoint.getSignature();
        System.out.println(sig.toLongString()); //호출된 메서드 정의 정보

        Object[] args = joinPoint.getArgs(); //인수 정보
        System.out.println(Arrays.toString(args));

        Object obj = joinPoint.getTarget(); //호출된 메서드를 가지고 있는 객체
        System.out.println(obj.getClass());
         */

        long stime = System.nanoTime(); //공통기능
        try {
            Object result = joinPoint.proceed(); // 핵심 기능 대신 실행 - factorial

            return result;
        } finally {
            long etime = System.nanoTime(); //공통기능
            System.out.printf("걸린 시간 : %d%n ", etime - stime);
        }

    }
}
