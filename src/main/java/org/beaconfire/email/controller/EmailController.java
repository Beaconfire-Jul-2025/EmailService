package org.beaconfire.email.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.beaconfire.email.model.EmailMessage;
import org.beaconfire.email.service.EmailPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EmailController {

  private final EmailPublisher emailPublisher;

  @PostMapping("/send")
  public String sendEmail(@RequestBody EmailMessage emailMessage) {
    log.info("Received email request: {}", emailMessage);
    emailPublisher.sendEmail(emailMessage);
    return "Email request sent to queue";
  }
}
