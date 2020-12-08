package spirng.redis.springredis.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spirng.redis.springredis.entity.Student;

@RestController
public class TestRedisController {

  @Autowired
  RedisTemplate<String, String> redisTemplate;

  @RequestMapping("setValue")
  public void setValue() {
    System.out.println("=========================");
    Student t1 = new Student();
    t1.setId(1);
    t1.setName("panqi");
    t1.setAge(18);
    t1.setGander("男");
    redisTemplate.opsForValue().set("k3", JSONObject.toJSONString(t1));

  }

  @RequestMapping("getValue")
  public Student getValue() {

    String k3 = redisTemplate.opsForValue().get("k3");
    Student student = JSONObject.parseObject(k3, Student.class);
    System.out.println(student.toString());
    return student;
  }
}
