package com.accountmicroservice.account.service;

import com.accountmicroservice.account.models.Account;

import java.util.List;

public interface IAccountService {
        Account create(Account account);

        List<Account> getAccounts();

        Account getAccount(int id);

        List<Account> getAccountByOwnerId(int ownerId);

        Account updateAccount(int id, Account account);

        Account addBalance(int id, int amount);

        Account withdrawBalance(int id, int amount);

        void delete(int id);

        void deleteAccountsUsingOwnerId(int ownerId);

}
