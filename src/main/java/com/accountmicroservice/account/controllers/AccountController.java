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

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Account createAccount (@RequestBody Account newAccount) {
        return accountService.create(newAccount);
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Account> getAllAccounts() {
        List<Account>allAcounts = new ArrayList<>();
        allAcounts= accountService.getAccounts();
        return allAcounts;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Account getSingleAccount(@PathVariable("id") Integer id) {
        Account account = accountService.getAccount(id);
        return account;
    }

    @RequestMapping(value="/customer{customerId}",method = RequestMethod.GET)
    public List<Account> getAccountsByCustomer(@PathVariable("customerId")Integer customerId) {
        List<Account> accounts = accountService.getAccountByOwnerId(customerId);
        return accounts;
    }

    @RequestMapping(value="/update/{accountId}",method = RequestMethod.PUT)
    public Account updateAccount(@PathVariable("accountId") Integer id, @RequestBody Account account) {
        account.setId(id);
        accountService.updateAccount(account.getId(),account);
        return account;
    }

    @RequestMapping(value="/delete{id}",method = RequestMethod.DELETE)
    public boolean deleteAccount(@PathVariable("id") Integer id) {
        accountService.delete(id);
        return true;
    }

    @RequestMapping(value = "/delete/{ownerId}",method = RequestMethod.DELETE)
    public boolean deleteAccountByOwnerId(@PathVariable("ownerId") Integer ownerId) {
        accountService.deleteAccountsUsingOwnerId(ownerId);
        return true;
    }

    @RequestMapping(value = "/balanceAdd{id}/{balance}",method = RequestMethod.POST)
    public Account addBalanceToAccount(@PathVariable("id")Integer id, @PathVariable("balance") Integer balance) {
        return accountService.addBalance(id,balance);
    }

    @RequestMapping(value = "/balanceWith{id}/{balance}", method = RequestMethod.POST)
    public Account withdrawBalanceToAccount(@PathVariable("id")Integer id, @PathVariable("balance") Integer balance) {
        return accountService.addBalance(id,balance);
    }


}
