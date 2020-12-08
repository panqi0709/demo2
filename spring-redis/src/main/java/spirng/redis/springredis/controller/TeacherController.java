package spirng.redis.springredis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spirng.redis.springredis.aspect.LogString;
import spirng.redis.springredis.entity.Teacher;
import spirng.redis.springredis.service.StudentService;
import spirng.redis.springredis.service.TeacherService;

@Slf4j
@RestController
public class TeacherController {

  @Autowired
  StudentService studentService;

  @Autowired
  TeacherService teacherService;

  @RequestMapping("saveTeacher")
  @LogString(desc = "你说呢")
  public Integer save() {
    Teacher t = new Teacher();
    t.setTeacherName("陈琳");
    t.setAge(18);
    Integer save = teacherService.save(t);
    return save;
  }

  @RequestMapping("getTeacher")
  public Teacher getTeacher(Integer id) {
    Teacher t = teacherService.getTeacher(id);
    return t;
  }
}
