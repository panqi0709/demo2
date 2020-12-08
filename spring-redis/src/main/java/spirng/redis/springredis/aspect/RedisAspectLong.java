package spirng.redis.springredis.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import spirng.redis.springredis.entity.Student;

/**
 * @Author 潘齐
 * @Description:
 * @Create: 2020/11/14 14:54
 */
@Slf4j
@Component
@Aspect
public class RedisAspectLong {

  @Autowired
  RedisTemplate redisTemplate;

  @Pointcut("@annotation(spirng.redis.springredis.aspect.RedisCache)")
  public void pointCut() {
  }

  @Around(value = "@annotation(redisCache)")
  public Object around(ProceedingJoinPoint joinPoint, RedisCache redisCache) throws Throwable {

    String key = redisCache.key();
    Object[] args = joinPoint.getArgs();
    String redisKey = "";
    for (Object arg : args) {
      redisKey += arg.toString();
    }
    Object o = redisTemplate.opsForValue().get(key + ":" + redisKey);
    if (o != null) {
      String result = redisTemplate.opsForValue().get(key + ":" + redisKey).toString();
      return JSONObject.parseObject(result, Student.class);
    }
    System.out.println("方法执行前");


    Object proceed = joinPoint.proceed(args);//执行方法
    redisTemplate.opsForValue().set(key + ":" + redisKey, JSONObject.toJSONString(proceed), redisCache.expireTime(), redisCache.timeUtil());
    System.out.println("执行方法后");
    return proceed;
  }

  /**
   * 异常处理
   *
   * @param joinPoint
   * @param redisCache
   * @param e
   */
  @AfterThrowing(value = "@annotation(redisCache)", throwing = "e")
  public void exception(JoinPoint joinPoint, RedisCache redisCache, Exception e) {
    System.out.println("异常通知。。。。。。。。。。。。。");
    System.out.println(e);
  }
}
