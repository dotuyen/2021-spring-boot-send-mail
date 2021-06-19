package com.tuyendt.springbootsendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail() {
        return emailService.sendEmail();
    }

    @GetMapping("/send-email-attach")
    public String sendEmailWithAttachment() {
        return emailService.sendEmailWithAttachment();
    }
}
