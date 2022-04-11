package com.endava.project.bank_account.repository;

import com.endava.project.bank_account.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Id> {
}
