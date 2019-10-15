package com.javabycode.springmvc.service;

import com.javabycode.springmvc.dao.AccountDao;
import com.javabycode.springmvc.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional
public class AccountService {

    @Autowired
    private AccountDao dao;

    public Account findById(int id) {
        return  dao.findById(id);
    }

    public void saveAccount(Account account) {
        dao.saveAccount(account);
    }
}
