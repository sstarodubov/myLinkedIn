package com.javabycode.springmvc.dao;

import com.javabycode.springmvc.model.Account;

public interface Accountable {

    Account findById(int id);
    void saveAccount(Account account);
    void removeAccountById(int id);
    void updateEmailAccount(Account account, String email);
    void updatePasswordAccount(Account account, String password);
}
