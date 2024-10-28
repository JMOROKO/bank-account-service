package com.silstechnologie.bankaccountservice.dto;

import com.silstechnologie.bankaccountservice.enums.AccountType;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
