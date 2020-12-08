package spirng.redis.springredis.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class AspectLog {

  @Autowired
  RedisTemplate<String, String> redisTemplate;

  @Pointcut("@annotation(spirng.redis.springredis.aspect.LogString)")
  public void pointCut() {
  }

  @Before(value = "pointCut()")
  public void beforMoth(JoinPoint joinPoint) {
    String name = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    LogString systemLog = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(LogString.class);
    String desc = systemLog.desc();

    log.info("前置通知---方法名：{}，注解：{}，参数：{}", name, desc, args);
  }

  @After(value = "pointCut()")
  public void after(JoinPoint joinPoint) {
    String name = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    log.info("after通知---方法名：{}，参数：{}", name, args);
  }

  @AfterReturning(value = "pointCut()", returning = "result")
  public void afterReturning(Object result) {

    log.info("返回通知---出参：{}", result);
  }

  @Around(value = "@annotation(logString)")
  public void around(ProceedingJoinPoint joinPoint, LogString logString) throws Throwable {


    Object[] args = joinPoint.getArgs();

    joinPoint.proceed(args); //执行方法

  }

}
