package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;

@Aspect
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        // joinPointㄱㅏ 멀까,,,,, 시간계산하는건 알겠눈데ㅠ슈
        long start = System.currentTimeMillis();
        System.out.println("start : "+joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long end = System.currentTimeMillis();
            long timeMs = end - start;
            System.out.println("end : "+joinPoint.toString()+" , ms : "+timeMs );
        }
    }


}
