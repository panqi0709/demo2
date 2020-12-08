package spirng.redis.springredis.mapper;

import spirng.redis.springredis.entity.Student;

import java.util.List;

public interface StudentMapper {

  public Student findOne(Integer id);

  List<Student> findAll();

  Integer insertOne(Student student);
}
