package com.hit.classservice.adapter.web.v1.controller.draft;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.application.constant.RabbitMQConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Demo send message to Queue in RabbitMQ
 */
@RestApiV1
public class SendMessageToQueueController {
  private final RabbitTemplate rabbitTemplate;

  public SendMessageToQueueController(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @GetMapping("/rabbit/demo-send-message")
  public ResponseEntity<?> demoSendMessage(@RequestParam("data") String data) {
    rabbitTemplate.convertAndSend(RabbitMQConstant.TOPIC_EXCHANGE_NAME,
        String.format(RabbitMQConstant.ROUTING_KEY_MAIL_1, "msg", "mail"), data);

    return VsResponseUtil.ok("Test Oke");
  }

}
