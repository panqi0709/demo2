package spirng.redis.springredis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import spirng.redis.springredis.aspect.RedisCache;
import spirng.redis.springredis.entity.Student;
import spirng.redis.springredis.mapper.StudentMapper;
import spirng.redis.springredis.service.StudentService;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentMapper studentMapper;

  @Override
  @RedisCache(key = "findOne", expireTime = 10, timeUtil = TimeUnit.HOURS)
  public Student findOne(Integer id) {
    System.out.println("本次查询学生ssid = " + id);
    return studentMapper.findOne(id);
  }

  @Override
  public List<Student> findAll() {
    return studentMapper.findAll();
  }

  @Override
  public Integer insertOne(Student student) {
    return studentMapper.insertOne(student);
  }
}
