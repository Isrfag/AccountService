package com.accountmicroservice.account.persistence;

import com.accountmicroservice.account.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByOwnerId(Integer OwnerId);
}
