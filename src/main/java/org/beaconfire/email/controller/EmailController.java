package org.beaconfire.email.controller;

import org.beaconfire.email.model.EmailMessage;
import org.beaconfire.email.service.EmailPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

  private final EmailPublisher emailPublisher;

  @Autowired
  public EmailController(EmailPublisher emailPublisher) {
    this.emailPublisher = emailPublisher;
  }

  @PostMapping("/send")
  public ResponseEntity<String> sendEmail(@RequestBody EmailMessage emailMessage) {
    emailPublisher.sendEmail(emailMessage);
    return ResponseEntity.ok("Email request sent to queue");
  }
}
