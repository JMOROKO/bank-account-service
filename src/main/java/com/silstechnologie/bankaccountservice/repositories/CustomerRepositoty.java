package com.silstechnologie.bankaccountservice.repositories;

import com.silstechnologie.bankaccountservice.entities.BankAccount;
import com.silstechnologie.bankaccountservice.entities.Customer;
import com.silstechnologie.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface CustomerRepositoty extends JpaRepository<Customer, Long> {
}
