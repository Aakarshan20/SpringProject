package com.it.service.impl;

import com.it.dao.impl.AccountDaoImpl;
import com.it.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private AccountDaoImpl accountDao = new AccountDaoImpl();

    public void saveAccount() {
        int i=1;
        accountDao.saveAccount();
    }
}
