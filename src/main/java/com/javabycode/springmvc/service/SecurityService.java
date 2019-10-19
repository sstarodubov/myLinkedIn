package com.javabycode.springmvc.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service("securityService")
public class SecurityService implements GuardablePassword{

    public final static String SALT = "-$]}HL[bF9>7G:^zp;kpjrr!ZbvDWgS5%ag3WMVxXL#p!Eus'q~,P5~:p=h$dCHP_?VXcUrqJtvjyP4PNJ.5f}BvFcd]u;*.5~";
    public String generateHashPassword(String input) throws NoSuchAlgorithmException {
        StringBuilder hash = new StringBuilder();
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] hashedBytes = sha.digest(input.getBytes());
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        for (int idx = 0; idx < hashedBytes.length; idx++) {
            byte b = hashedBytes[idx];
            hash.append(digits[(b & 0xf0) >> 4]);
            hash.append(digits[b & 0x0f]);
        }
        return hash.toString();
    }
}
