package com.javabycode.springmvc.dao;

import com.javabycode.springmvc.model.AccessToken;

import java.sql.Date;

public interface AccessTokenAble {

    AccessToken findAccessTokenById(int id);
    void removeAccessToken(AccessToken accessToken);
    void save(AccessToken token);
    AccessToken findAccessTokenByTokenValue(String value);

}
