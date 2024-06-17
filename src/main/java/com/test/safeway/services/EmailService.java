package com.test.safeway.services;

import com.test.safeway.StatusEmail;
import com.test.safeway.models.Email;
import com.test.safeway.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }


    public Email sendEmail(Email email) {

        email.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch(MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
            System.out.print("O erro: " + e.getMessage());
        } finally {
            return emailRepository.save(email);
        }

    }
}
