package spirng.redis.springredis.config;

import org.apache.activemq.ActiveMQConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
@EnableJms
public class MqConfig {

  @Value("${myQueue}")
  private String activeQueueName;

  @Value("${spring.activemq.broker-url}")
  private String url;

  @Bean
  public ActiveMQConnectionFactory getActiveMQConnectionFactory() {
    return new ActiveMQConnectionFactory(url);
  }

  @Bean
  public ActiveMQQueue getQueue() {
    return new ActiveMQQueue(activeQueueName);
  }

  @Bean
  public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory, Queue queue) {
    JmsTemplate jmsTemplate = new JmsTemplate();
    jmsTemplate.setDeliveryMode(2);//进行持久化配置 1表示非持久化，2表示持久化
    jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
    jmsTemplate.setDefaultDestination(queue); //此处可不设置默认，在发送消息时也可设置队列
    jmsTemplate.setSessionAcknowledgeMode(4);//客户端签收模式
    return jmsTemplate;
  }
}
