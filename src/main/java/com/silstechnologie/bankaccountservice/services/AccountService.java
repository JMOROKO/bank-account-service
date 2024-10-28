package com.silstechnologie.bankaccountservice.services;


import com.silstechnologie.bankaccountservice.dto.BankAccountRequestDTO;
import com.silstechnologie.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
