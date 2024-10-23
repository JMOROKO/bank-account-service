package com.silstechnologie.bankaccountservice.repositories;

import com.silstechnologie.bankaccountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankAccountRepositoty extends JpaRepository<BankAccount, String> {
}
