package com.tuyendt.springbootsendmail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

    final
    JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dotuyen174@gmail.com");
        message.setTo("dotuyen174@gmail.com");
        message.setCc("dotuyen174@gmail.com");
        message.setSubject("Test Subject");
        message.setText("Test Body");
        javaMailSender.send(message);
        return "Mail was sent successfully!";
    }

    public String sendEmailWithAttachment() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom("dotuyen174@gmail.com");
            mimeMessageHelper.setTo("dotuyen174@gmail.com");
            mimeMessageHelper.setCc("dotuyen174@gmail.com");
            mimeMessageHelper.setSubject("Test Subject");
            mimeMessageHelper.setText("Test Body");

            File file = new File("G:\\mytxt.txt");
            mimeMessageHelper.addAttachment(file.getName(), file);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            return "Mail was not sent successfully!";
        }
        return "Mail was sent successfully!";
    }
}
