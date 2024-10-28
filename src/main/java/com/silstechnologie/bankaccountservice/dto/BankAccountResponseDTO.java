package com.silstechnologie.bankaccountservice.dto;

import com.silstechnologie.bankaccountservice.enums.AccountType;
import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
