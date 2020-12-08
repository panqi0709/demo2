package spirng.redis.springredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(value = "spirng.redis.springredis.mapper")
@EnableCaching
@EnableScheduling
public class SpringRedisApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringRedisApplication.class, args);
  }

}
