package com.accountmicroservice.account.persistence;

import com.accountmicroservice.account.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accRepo;

    @Test
    void testBeans(){
        assertThat(accRepo, notNullValue());
    }

    @Test
    void shouldCreateAccount(){
    }



}
