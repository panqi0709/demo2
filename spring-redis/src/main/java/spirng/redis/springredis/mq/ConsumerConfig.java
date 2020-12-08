package spirng.redis.springredis.mq;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import spirng.redis.springredis.entity.Student;
import spirng.redis.springredis.service.StudentService;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class ConsumerConfig {

  @Autowired
  StudentService studentService;

  @JmsListener(destination = "${myQueue}")
  public void receiveQueue(TextMessage message) throws JMSException {
    System.out.println("获取消息 = " + message.getText());
    if (message != null) {
      String text = message.getText();
      Student student = JSONObject.parseObject(text, Student.class);
      studentService.insertOne(student);
    }
  }
}

