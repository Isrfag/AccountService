package com.accountmicroservice.account.persistence;

import com.accountmicroservice.account.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
