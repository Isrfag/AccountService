package com.accountmicroservice.account.controllers;

import com.accountmicroservice.account.models.Account;
import com.accountmicroservice.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @RequestMapping("/new")
    public Account createAccount (@RequestBody Account newAccount) {
        return accountService.create(newAccount);
    }

    @RequestMapping("")
    public List<Account> getAllAccounts() {
        List<Account>allAcounts = new ArrayList<>();
        allAcounts= accountService.getAccounts();
        return allAcounts;
    }

    @RequestMapping("/{id}")
    public Account getSingleAccount(@PathVariable("id") Integer id) {
        Account account = accountService.getAccount(id);
        return account;
    }

    @RequestMapping("/customer{customerId}")
    public List<Account> getAccountsByCustomer(@PathVariable("customerId")Integer customerId) {
        List<Account> accounts = accountService.getAccountByOwnerId(customerId);
        return accounts;
    }

    @RequestMapping("/update/{accountId}")
    public Account updateAccount(@PathVariable("accountId") Integer id) {
        Account account = accountService.getAccount(id);
        account.setBalance(200);
        accountService.updateAccount(account.getId(),account);
        return account;
    }

    @RequestMapping("/delete{id}")
    public boolean deleteAccount(@PathVariable("id") Integer id) {
        accountService.delete(id);
        return true;
    }

    @RequestMapping("/delete/{ownerId}")
    public boolean deleteAccountByOwnerId(@PathVariable("ownerId") Integer ownerId) {
        accountService.deleteAccountsUsingOwnerId(ownerId);
        return true;
    }

    @RequestMapping("/balanceAdd{id}/{balance}")
    public Account addBalanceToAccount(@PathVariable("id")Integer id, @PathVariable("balance") Integer balance) {
        return accountService.addBalance(id,balance);
    }

    @RequestMapping("/balanceWith{id}/{balance}")
    public Account withdrawBalanceToAccount(@PathVariable("id")Integer id, @PathVariable("balance") Integer balance) {
        return accountService.addBalance(id,balance);
    }


}
