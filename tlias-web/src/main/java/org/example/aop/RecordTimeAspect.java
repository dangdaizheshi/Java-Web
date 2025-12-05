package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // 将当前类标识为一个 aop 类
@Component
public class RecordTimeAspect {

    @Pointcut("execution(* org.example.service.impl.*.*(..))")
    public void pt() {}
    @Around("execution(* org.example.service.impl.*.*(..))") // 标明对哪些方法生效
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        // 记录方法运行的开始时间
        long start = System.currentTimeMillis();
        // 运行原始方法
        Object result = pjp.proceed();
        // 记录方法运行的结束时间
        long end = System.currentTimeMillis();
        // 输出方法运行时间
        System.out.println(String.format("方法%s运行时间：%d ms", pjp.getSignature(), (end - start)));
        return result;
    }

    @Before("pt()")
    public void before () {
        System.out.println("before");
    }
}
