package org.beaconfire.email.controller;

import org.beaconfire.email.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> sendRegistrationEmail(
            @RequestParam String email,
            @RequestParam String registrationLink
    ) {
        emailService.sendRegistrationEmail(email, registrationLink);
        return ResponseEntity.ok().build();
    }
}
