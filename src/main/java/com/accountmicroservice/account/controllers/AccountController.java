package com.accountmicroservice.account.controllers;

import com.accountmicroservice.account.models.Account;
import com.accountmicroservice.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    IAccountService accountService;

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


}
