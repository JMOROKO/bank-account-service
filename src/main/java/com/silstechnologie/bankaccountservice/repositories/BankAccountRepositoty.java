package com.silstechnologie.bankaccountservice.repositories;

import com.silstechnologie.bankaccountservice.entities.BankAccount;
import com.silstechnologie.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource //permet de creer automatiquement un service web rest
// @TODO peut-on utiliser cette méthode pour publier une application en production ?
public interface BankAccountRepositoty extends JpaRepository<BankAccount, String> {
    @RestResource(path = "byType") //anotation de spring data rest permet de modifier les URL
    // tu peux y accéder grace à ce lien : http://localhost:8080/bankAccounts/search/byType?t=SAVING_ACCOUNT
    List<BankAccount> findByType(@Param("t") AccountType type);
}
