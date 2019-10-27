package com.javabycode.springmvc.dao;

import com.javabycode.springmvc.model.Account;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDao extends AbstractDao<Integer, Account> implements Accountable{

    @Override
    public Account findById(int id) {
        return getByKey(id);
    }

    public Account findByEmail(String email) {
        Query query = getSession().createQuery("from Account a where a.email=:email");
        query.setString("email", email);
        Account account = (Account) query.uniqueResult();
        return account;
    }

    @Override
    public void saveAccount(Account account) {
        persist(account);
    }

    @Override
    public void removeAccountById(int id) {
        Query query = getSession().createQuery("delete from Account a where a.id=:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateEmailAccount(Account account, String email) {
        account.setEmail(email);
        getSession().update(account);
    }

    @Override
    public void updatePasswordAccount(Account account, String password) {
        account.setPassword(password);
        getSession().update(account);
    }

    public void updateAccount(Account account) {
        getSession().update(account);
    }


}
