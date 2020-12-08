package spirng.redis.springredis.service;

import spirng.redis.springredis.entity.Teacher;

public interface TeacherService {

  Integer save(Teacher teacher);

  Teacher getTeacher(Integer id);
}
