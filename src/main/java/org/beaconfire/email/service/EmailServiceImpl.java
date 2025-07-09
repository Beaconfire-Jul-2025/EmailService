package org.beaconfire.email.service;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    // Just for testing now
    // Will implement email sending in the future
    public void sendRegistrationEmail(String email, String registrationLink) {
        System.out.println("===Sending Email===");
        System.out.println("To Email: " + email);
        System.out.println("Registration Link: " + registrationLink);
    }
}
