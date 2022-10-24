package com.hit.classservice.config;

import com.hit.classservice.application.constant.RabbitMQConstant;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

  @Bean
  public Declarables topicBindings() {
    Queue topicQueue1 = new Queue(RabbitMQConstant.TOPIC_QUEUE_1_NAME, false);
    Queue topicQueue2 = new Queue(RabbitMQConstant.TOPIC_QUEUE_2_NAME, false);
    TopicExchange topicExchange = new TopicExchange(RabbitMQConstant.TOPIC_EXCHANGE_NAME);
    return new Declarables(
        topicQueue1,
        topicQueue2,
        topicExchange,
        bind(topicQueue1).to(topicExchange).with(String.format(RabbitMQConstant.ROUTING_KEY_MAIL_1, "*", "*")),
        bind(topicQueue2).to(topicExchange).with(String.format(RabbitMQConstant.ROUTING_KEY_MAIL_2, "#"))
    );
  }

}
