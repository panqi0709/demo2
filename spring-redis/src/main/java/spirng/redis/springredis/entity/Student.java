package spirng.redis.springredis.entity;

import java.io.Serializable;

public class Student implements Serializable {

  public Student(Integer id, String name, Integer age, String gander, String teacherId) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gander = gander;
    this.teacherId = teacherId;
  }

  public Student() {
  }

  private Integer id;

  private String name;

  private Integer age;

  private String gander;

  private String teacherId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGander() {
    return gander;
  }

  public void setGander(String gander) {
    this.gander = gander;
  }

  public String getTeacherId() {

    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }
}
