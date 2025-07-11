package org.beaconfire.email.service;

import org.beaconfire.email.model.EmailMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

  private final JavaMailSender mailSender;

  @Autowired
  public EmailConsumer(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @RabbitListener(queues = "emailQueue")
  public void receiveEmail(EmailMessage emailMessage) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(emailMessage.getTo());
    message.setSubject(emailMessage.getSubject());
    message.setText(emailMessage.getBody());
    mailSender.send(message);
  }
}
