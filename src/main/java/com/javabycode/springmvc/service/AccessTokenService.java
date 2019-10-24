package com.javabycode.springmvc.service;

import com.javabycode.springmvc.dao.AccessTokenDao;
import com.javabycode.springmvc.model.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service("accessTokenService")
@Transactional
public class AccessTokenService {

    @Autowired
    private AccessTokenDao dao;

    public final static int TTL = 3600000;

    public void save(AccessToken accessToken) {
        dao.save(accessToken);
    }

    public AccessToken getAccessTokenByValue(String tokenValue) {
        AccessToken accessToken = dao.findAccessTokenByTokenValue(tokenValue);
        return accessToken;
    }

    public void remove(AccessToken accessToken) {
        dao.removeAccessToken(accessToken);
    }

    public Boolean checkAccessTokenTTL(AccessToken token) {
        long createdTimestamp = token.getCreated().getTime();
        Date date = new Date();
        long currentTimestamp = date.getTime();
        long difference = currentTimestamp - createdTimestamp;
        if (difference > AccessTokenService.TTL) return false;
        return true;
    }
}
