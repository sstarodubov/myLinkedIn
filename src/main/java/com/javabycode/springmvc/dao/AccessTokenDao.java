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
    public AccessToken findAccessTokenByAccountId(int id) {
//        Query query = getSession().createQuery("")
        return null;
    }

    @Override
    public void save(AccessToken token) {
        persist(token);
    }
}
