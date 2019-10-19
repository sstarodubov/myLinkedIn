package com.javabycode.springmvc.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class AccessToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int ttl;

    @Column
    @Basic
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @ManyToOne
    private Account account;

    @Column
    private String tokenValue;

    public AccessToken(int ttl, Account account, String tokenValue) {
        this.ttl = ttl;
        this.account = account;
        this.tokenValue = tokenValue;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public AccessToken() {
    }

    public AccessToken(int ttl) {
        this.ttl = ttl;
    }

    public AccessToken(int ttl, Timestamp created, Account account) {
        this.ttl = ttl;
        this.created = created;
        this.account = account;
    }

    public AccessToken(int ttl, Account account) {
        this.ttl = ttl;
        this.account = account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public int getTtl() {
        return ttl;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
