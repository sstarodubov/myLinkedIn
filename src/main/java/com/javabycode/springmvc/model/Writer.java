package com.javabycode.springmvc.model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Writer {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String address;

    public Writer() {
    }

    public Writer(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
