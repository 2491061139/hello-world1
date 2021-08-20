package com.example.helloworld.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhangLiZhi
 * @Date: 2021/8/13
 */

@EnableAspectJAutoProxy
@Aspect
@Component
@Slf4j
public class TestAop {

    @Before("execution(* com.example.helloworld.controllers.*.*(..))")
    public void aop1(JoinPoint joinPoint) {
        log.info("start to use " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.helloworld.controllers.*.*(..))")
    public void aop2(JoinPoint joinPoint) {
        log.info("end to use " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.helloworld.controllers.*.*(..))")
    public void aop4(JoinPoint joinPoint) {
        log.info("error in " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.helloworld.controllers.*.*(..))")
    public void aop5(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + " returned");
    }

}
