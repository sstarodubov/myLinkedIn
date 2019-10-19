package com.javabycode.springmvc.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class AccessToken {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private Date ttl;

    @Column
    @CreationTimestamp
    private Date created;

    @ManyToOne
    private Account account;

    public AccessToken(Date ttl, Date created, Account account) {
        this.ttl = ttl;
        this.created = created;
        this.account = account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTtl(Date ttl) {
        this.ttl = ttl;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public Date getTtl() {
        return ttl;
    }

    public Date getCreated() {
        return created;
    }

    public Account getAccount() {
        return account;
    }
}
