package spirng.redis.springredis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.DefaultLettucePool;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import spirng.redis.springredis.entity.Student;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringRedisApplicationTests {


  @Resource
  RedisTemplate<String, String> redisStringTemplate;

  @Resource
  RedisTemplate<String, Object> redisTemplate;

  @Autowired
  StringRedisTemplate stringRedisTemplate;

  @Test
  void contextLoads() {
    Student k3 = (Student) redisTemplate.opsForValue().get("k10");
    System.out.println(k3.toString() + "=========================================");
  }

  @Test
  void setStudent() {
    System.out.println("=========================");
    Student t1 = new Student();
    t1.setId(444);
    t1.setName("wwww");
    t1.setAge(222);
    t1.setGander("男");
    redisTemplate.opsForValue().set("k11", t1);
  }

  @Test
  void setStudentString() {
    System.out.println("=========================");
    Student t1 = new Student();
    t1.setId(444);
    t1.setName("k13344555");
    t1.setAge(222);
    t1.setGander("男");
    redisStringTemplate.opsForValue().set("k13344555", JSONObject.toJSONString(t1), 30, TimeUnit.SECONDS);
  }

  @Test
  void getStudentString() {
    System.out.println("=========================");
    String k11 = stringRedisTemplate.opsForValue().get("k13344555");
    System.out.println(k11 + "=========================");
    Map aa = new HashMap();
    Set set = new HashSet<>();
    List list = new ArrayList();
    List linkList = new LinkedList();
  }

  @Test
  void changeDb() {
    setDataBase(4);
    int aa = ((LettuceConnectionFactory) (redisTemplate.getConnectionFactory())).getDatabase();
    System.out.println(aa + "==============ss========sssssssssssssssssssssssss");
    redisTemplate.opsForValue().set("woshishei", "22sssss22");
  }


  public void setDataBase(int num) {
    LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
    if (connectionFactory != null && num != connectionFactory.getDatabase()) {

      int aa = connectionFactory.getDatabase();
      System.out.println(aa + "======================sssssssssssssssssssssssss");
      connectionFactory.setDatabase(num);
      aa = connectionFactory.getDatabase();
      System.out.println(aa + "======================sssssssssssssssssssssssss");
      this.redisTemplate.setConnectionFactory(connectionFactory);
//      connectionFactory.resetConnection();

    }
  }
}
