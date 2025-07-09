package org.beaconfire.email.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface EmailService {
    @PostMapping("/emails/registration")
    void sendRegistrationEmail(@RequestParam String email, @RequestParam String registrationLink);
}
