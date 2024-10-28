package com.silstechnologie.bankaccountservice.entities;

import com.silstechnologie.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name="p1")
// permet de pouvoir afficher ce que l'on dans les retour json et ils sont visible sur ce lien : http://localhost:8080/bankAccounts?projection=p1
public interface AccountProjection {
    String getId();
    AccountType getType();
    Double getBalance();
}
