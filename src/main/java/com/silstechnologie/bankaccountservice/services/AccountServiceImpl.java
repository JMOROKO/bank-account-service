package com.silstechnologie.bankaccountservice.services;

import com.silstechnologie.bankaccountservice.dto.BankAccountRequestDTO;
import com.silstechnologie.bankaccountservice.dto.BankAccountResponseDTO;
import com.silstechnologie.bankaccountservice.entities.BankAccount;
import com.silstechnologie.bankaccountservice.mappers.AccountMapper;
import com.silstechnologie.bankaccountservice.repositories.BankAccountRepositoty;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private BankAccountRepositoty repositoty;
    private AccountMapper accountMapper;


    public AccountServiceImpl(BankAccountRepositoty repositoty, AccountMapper accountMapper) {
        this.repositoty = repositoty;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount savedBankAccount = repositoty.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount savedBankAccount = repositoty.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
