package com.atpanqi.springbootaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/17 17:28
 */
@Aspect
@Slf4j
@Component
public class AspectTestAop {

  @Pointcut("execution(* com.atpanqi.springbootaop.service.*.*(..))")
  public void putcut() {
  }

  @Before("putcut()")
  public void before(JoinPoint joinPoint) {

    log.info("*********************************before = {}", joinPoint.getSignature().getName());
  }

  @After("putcut()")
  public void after() {
    log.info("*********************************after");
  }

  @Around("putcut()")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("*********************************around 方法前");
    Object proceed = joinPoint.proceed();
    log.info("*********************************around 方法后");
    return proceed;
  }
}
