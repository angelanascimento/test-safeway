package com.test.safeway.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public class EmailDTO {
    @NotBlank
    private String ownerRef;
    @Email
    @NotBlank
    private String emailFrom;
    @Email
    @NotBlank
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailDTO emailDTO = (EmailDTO) o;
        return Objects.equals(ownerRef, emailDTO.ownerRef) && Objects.equals(emailFrom, emailDTO.emailFrom) && Objects.equals(emailTo, emailDTO.emailTo) && Objects.equals(subject, emailDTO.subject) && Objects.equals(text, emailDTO.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerRef, emailFrom, emailTo, subject, text);
    }

    @Override
    public String toString() {
        return "EmailDTO{" +
                "ownerRef='" + ownerRef + '\'' +
                ", emailFrom='" + emailFrom + '\'' +
                ", emailTo='" + emailTo + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
