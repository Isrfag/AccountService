package com.accountmicroservice.account.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @RequestMapping("/accounts")
    public List<String> getAllCustomersAccounts() {
        return new ArrayList();
    }
}
