package com.javabycode.springmvc.dao;

import com.javabycode.springmvc.model.Account;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDao extends AbstractDao<Integer, Account> implements Accountable{

    @Override
    public Account findById(int id) {
        return getByKey(id);
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
    public void updateAccount(String field, String value, int id) {
        Query query = getSession().createQuery("update Account a set a.:field=:value where id=:id");
        query.setString("field", field);
        query.setString("value", value);
        query.setInteger("id", id);
        query.executeUpdate();
    }
}
