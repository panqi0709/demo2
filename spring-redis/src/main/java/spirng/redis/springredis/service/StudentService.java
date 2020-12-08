package spirng.redis.springredis.service;

import spirng.redis.springredis.entity.Student;

import java.util.List;

public interface StudentService {

  Student findOne(Integer id);

  List<Student> findAll();

  Integer insertOne(Student student);
}
