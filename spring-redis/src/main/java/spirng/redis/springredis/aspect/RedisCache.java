package spirng.redis.springredis.aspect;


import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Documented
public @interface RedisCache {

  String key();

  long expireTime() default 60;

  TimeUnit timeUtil() default TimeUnit.MINUTES;
}
