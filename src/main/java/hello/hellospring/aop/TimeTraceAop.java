package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") // targeting용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        // method 실행시 항상 걸림

        long start = System.currentTimeMillis();
        System.out.println("start : "+joinPoint.toString());
        try{
            // 조건문 생성후 예외처리 가능
            return joinPoint.proceed();
        }finally {
            long end = System.currentTimeMillis();
            long timeMs = end - start;
            System.out.println("end : "+joinPoint.toString()+" , ms : "+timeMs );
        }
    }

}
