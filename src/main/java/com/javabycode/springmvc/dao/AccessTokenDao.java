package com.javabycode.springmvc.dao;

import com.javabycode.springmvc.model.AccessToken;
import com.javabycode.springmvc.model.Account;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("accessTokenDao")
public class AccessTokenDao  extends AbstractDao<Integer, AccessToken> implements AccessTokenAble{

    @Override
    public AccessToken findAccessTokenById(int id) {
        return getByKey(id);
    }

    @Override
    public void removeAccessToken(AccessToken accessToken) {
        delete(accessToken);
    }

    @Override
    public void save(AccessToken token) {
        persist(token);
    }

    @Override
    public AccessToken findAccessTokenByTokenValue(String value) {
        Query query = getSession().createQuery("from AccessToken a where a.tokenValue=:value");
        query.setString("value", value);
        AccessToken token = (AccessToken) query.uniqueResult();
        return token;
    }
}
