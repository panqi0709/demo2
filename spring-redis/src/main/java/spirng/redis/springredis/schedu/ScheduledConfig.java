package spirng.redis.springredis.schedu;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import spirng.redis.springredis.entity.Student;
import spirng.redis.springredis.service.StudentService;
import spirng.redis.springredis.service.TeacherService;

import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class ScheduledConfig {

  @Autowired
  StudentService studentService;

  @Autowired
  TeacherService teacherService;


  //@Scheduled(cron = "0/1 * * * * ?") //5s一次
  //@Scheduled(fixedDelay = 3000) //3s一次
  public void listernStudent() {
    System.out.println("我是定时器");
//    List<Student> list = studentService.findAll();
//    String s = JSONArray.toJSONString(list);
//    System.out.println(s);
    teacherService.getTeacher(1);


    int v = 20 / (int) (Math.random() * 10);

  }

}
