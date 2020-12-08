package spirng.redis.springredis.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import spirng.redis.springredis.entity.Student;
import spirng.redis.springredis.mq.ProductConfig;
import spirng.redis.springredis.service.StudentService;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@RestController
public class StudentController {

  @Autowired
  StudentService studentService;

  @Autowired
  ProductConfig productConfig;

  @Autowired
  JmsMessagingTemplate jmsMessagingTemplate;

  @Autowired
  Queue queue;

  @GetMapping("student/findOne")
  public Student findOne(Integer id) throws JMSException {
    System.out.println("我要查询啦");
    Student one = studentService.findOne(id);
    String s = JSONObject.toJSONString(one);
    productConfig.sendMessage(s);
    return one;
  }

  /**
   * @param gander
   * @param age
   * @throws JMSException
   */
  @GetMapping("student/findTwo")
  public void findTwo(String gander, Integer age) throws JMSException {
    System.out.println("我要查询啦findTwos," + "gander = " + gander + "  age = " + age);
//    Student one = studentService.findOne(id);
//    String s = JSONObject.toJSONString(one);
//    productConfig.sendMessage(s);
//    return one;
  }

  /**
   * @param gander
   * @param age
   * @throws JMSException
   */
  @PostMapping("student/findThree")
  public void findThree(String gander, Integer age, HttpServletRequest request) throws JMSException {
    String session = request.getHeader("session");
    System.out.println("session = " + session);

    System.out.println("findThree," + "gander = " + gander + "  age = " + age);
//    Student one = studentService.findOne(id);
//    String s = JSONObject.toJSONString(one);
//    productConfig.sendMessage(s);
//    return one;
  }

  @GetMapping("student/{id}")
  public Student deleteStudent(@PathVariable("id") Integer id) throws JMSException {
    Student one = studentService.findOne(id);
    String s = JSONObject.toJSONString(one);
    //productConfig.sendMessage(s);
    return one;
  }

  @GetMapping("getAllStudent")
  public List<Student> findAll() {
    List<Student> all = studentService.findAll();
    all.forEach(one -> {
      String s = JSONObject.toJSONString(one);
      jmsMessagingTemplate.convertAndSend(queue, s);
    });
    return all;
  }

  /**
   * 测试idea热部署
   * 只有deubg模式下，热部署才起作用
   *
   * @return
   */
  @GetMapping("string")
  public String string() {
    String aa = "我那么多遗憾，那么多期盼你知道吗，22。。。。";
    System.out.println(aa);
    String bb = "我爱你，是多么清楚多么坚固的信仰。。。。。。";
    System.out.println(bb);
    String cc = "我爱你，是来自灵魂来自生命的力量。。。。。。";
    System.out.println(cc);

    return aa;
  }
}
