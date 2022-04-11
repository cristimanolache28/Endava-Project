package com.endava.project.bank_account.service.impl;

import com.endava.project.bank_account.model.BankAccount;
import com.endava.project.bank_account.repository.BankAccountRepository;
import com.endava.project.bank_account.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
}
