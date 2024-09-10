package com.accountmicroservice.account.persistence;

import com.accountmicroservice.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByOwnerId(Integer OwnerId);
}
