package com.javabycode.springmvc.model;

import org.hibernate.engine.jdbc.ReaderInputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ResetPasswordForm {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String email;

    public ResetPasswordForm() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResetPasswordForm(String email) {
        this.email = email;
    }
}
