package com.accountmicroservice.account.exceptions;

public class AccountNotfoundException extends GlobalException {
    protected static final long serialVersionUID = 2L;

    public AccountNotfoundException() {
        super("Account not found");
    }

    public AccountNotfoundException(int accountId) {
        super("Account with id: " + accountId + " not found");
    }
}
