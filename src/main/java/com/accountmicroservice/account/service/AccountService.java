package com.accountmicroservice.account.service;

import com.accountmicroservice.account.exceptions.AccountNotfoundException;
import com.accountmicroservice.account.models.Account;
import com.accountmicroservice.account.models.Customer;
import com.accountmicroservice.account.persistence.AccountRepository;
import com.accountmicroservice.account.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Account create(Account account) {
        account.setDate(LocalDate.now().toString());
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

      public Account getAccount(int id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        return account;
    }

    @Override
    public List<Account> getAccountByOwnerId(int ownerId) {

        return accountRepository.findByOwnerId(ownerId);
    }

    @Override
    public Account updateAccount(int id, Account account) {
        Account newAccount = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        newAccount.setType(account.getType());
        return accountRepository.save(newAccount);
    }

    @Override
    public Account addBalance(int id, int amount, Long ownerId) {
        Account newAccount = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        int newBalance = newAccount.getBalance() + amount;
        newAccount.setBalance(newBalance);
        return accountRepository.save(newAccount);
    }

    @Override
    public Account withdrawBalance(int id, int amount, Long ownerId) {
        Account newAccount = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        Customer owner = null;
        int newBalance = newAccount.getBalance() - amount;
        newAccount.setBalance(newBalance);
        return accountRepository.save(newAccount);
    }

    @Override
    public void delete(int id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotfoundException(id));
        this.accountRepository.delete(account);
    }

    @Override
    public void deleteAccountsUsingOwnerId(int ownerId) {
        List<Account> accounts = accountRepository.findByOwnerId(ownerId);
        for (Account account : accounts) {
            this.accountRepository.delete(account);
        }
    }
}
