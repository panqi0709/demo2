package spirng.redis.springredis.mapper;

import org.apache.ibatis.annotations.Param;
import spirng.redis.springredis.entity.Teacher;

public interface TeacherMapper {

  Integer save(Teacher teacher);

  Teacher getTeacher(@Param("id") Integer id);
}
