package spirng.redis.springredis.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class ProductConfig {

  @Autowired
  ActiveMQConnectionFactory activeMQConnectionFactory;
  @Autowired
  ActiveMQQueue activeMQQueue;

  public void sendMessage(String message) throws JMSException {
    Connection connection = activeMQConnectionFactory.createConnection();

    connection.start();
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    TextMessage textMessage = session.createTextMessage(message);
    MessageProducer producer = session.createProducer(activeMQQueue);
    producer.send(textMessage);
    System.out.println("发送消息成功  ====={" + message + "}");
  }


}
