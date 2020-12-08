package spirng.redis.springredis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spirng.redis.springredis.aspect.LogString;
import spirng.redis.springredis.entity.Student;
import spirng.redis.springredis.entity.Teacher;
import spirng.redis.springredis.mapper.StudentMapper;
import spirng.redis.springredis.mapper.TeacherMapper;
import spirng.redis.springredis.service.TeacherService;

//@Transactional
@Service
public class TeacherServiceImpl implements TeacherService {

  @Autowired
  TeacherMapper teacherMapper;

  @Autowired
  StudentMapper studentMapper;


  @Override
  public Integer save(Teacher teacher) {

    teacherMapper.save(teacher);
    studentMapper.insertOne(new Student(null, "panqi", 11, "nan", "2"));
    return 1;
  }

  @Override
  @LogString(desc = "我就是desc")
  public Teacher getTeacher(Integer id) {

    Teacher teacher = teacherMapper.getTeacher(id);
    return teacher;
  }
}
