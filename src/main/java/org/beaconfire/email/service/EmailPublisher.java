package org.beaconfire.email.service;

import lombok.extern.slf4j.Slf4j;
import org.beaconfire.email.model.EmailMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailPublisher {
  private final AmqpTemplate rabbitTemplate;

  @Value("${spring.rabbitmq.template.exchange}")
  private String exchange;

  @Value("${spring.rabbitmq.template.routing-key}")
  private String routingKey;

  @Autowired
  public EmailPublisher(AmqpTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendEmail(EmailMessage emailMessage) {
    log.info("Sending email to {}", emailMessage.getTo());
    rabbitTemplate.convertAndSend(exchange, routingKey, emailMessage);
  }
}
