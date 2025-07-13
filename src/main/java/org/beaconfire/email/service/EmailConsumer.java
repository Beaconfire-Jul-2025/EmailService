package org.beaconfire.email.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.beaconfire.email.model.EmailMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class EmailConsumer {

  private final JavaMailSender mailSender;

  @RabbitListener(queues = "emailQueue")
  public void receiveEmail(EmailMessage emailMessage) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(emailMessage.getTo());
    message.setSubject(emailMessage.getSubject());
    message.setText(emailMessage.getBody());
    mailSender.send(message);
  }
}
