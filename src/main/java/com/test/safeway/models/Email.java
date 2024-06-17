package com.test.safeway.models;


import com.test.safeway.StatusEmail;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerRef() {
        return ownerRef;
    }

    public void setOwnerRef(String ownerRef) {
        this.ownerRef = ownerRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(id, email.id) && Objects.equals(ownerRef, email.ownerRef) && Objects.equals(emailFrom, email.emailFrom) && Objects.equals(emailTo, email.emailTo) && Objects.equals(subject, email.subject) && Objects.equals(text, email.text) && Objects.equals(sendDateEmail, email.sendDateEmail) && statusEmail == email.statusEmail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerRef, emailFrom, emailTo, subject, text, sendDateEmail, statusEmail);
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", ownerRef='" + ownerRef + '\'' +
                ", emailFrom='" + emailFrom + '\'' +
                ", emailTo='" + emailTo + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", sendDateEmail=" + sendDateEmail +
                ", statusEmail=" + statusEmail +
                '}';
    }
}
