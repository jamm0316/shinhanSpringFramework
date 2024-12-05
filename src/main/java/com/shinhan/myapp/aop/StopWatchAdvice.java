package com.shinhan.myapp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
@Aspect  //Pointcut + Advice
public class StopWatchAdvice {

//    @Pointcut("execution(* select*(..))")
    @Pointcut("within(com.shinhan.myapp.contoller.EmpController)")
    public void deptTimer() { }

    @Around("deptTimer()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        log.info("******" + jp.getSignature().getName() + "메서드 호출 전");
        StopWatch watch = new StopWatch("계산시간");
        watch.start();
        log.info("------------------before-----------------");

        Object obj = jp.proceed();

        log.info("------------------after-----------------");
        log.info("*****" + jp.getSignature().getName() + "메서드 호출 후");
        watch.stop();
        log.info("주업무 수행 시간:" + watch.getTotalTimeMillis());
        log.info(watch.prettyPrint());

        return obj;
    }
}