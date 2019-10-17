package com.javabycode.springmvc.service;

import java.security.NoSuchAlgorithmException;

public interface GuardablePassword {
    String generateHashPassword(String password) throws NoSuchAlgorithmException;
}
