package com.accountmicroservice.account.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @RequestMapping("")
    public List<String> getAllAccounts() {
        return new ArrayList();
    }
}
