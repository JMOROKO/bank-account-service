package com.silstechnologie.bankaccountservice.web;

import com.silstechnologie.bankaccountservice.dto.BankAccountRequestDTO;
import com.silstechnologie.bankaccountservice.dto.BankAccountResponseDTO;
import com.silstechnologie.bankaccountservice.entities.BankAccount;
import com.silstechnologie.bankaccountservice.entities.Customer;
import com.silstechnologie.bankaccountservice.repositories.BankAccountRepositoty;
import com.silstechnologie.bankaccountservice.repositories.CustomerRepositoty;
import com.silstechnologie.bankaccountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

// TODO nous n'avons pas vue la pagination avec graphQL
@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepositoty bankAccountRepositoty;
    @Autowired
    private CustomerRepositoty customerRepositoty;
    @Autowired
    private AccountService accountService;

    // utiliser le lien suivant pour afficher la page graphQL : http://localhost:8080/graphiql?path=/graphql
    // comment envoyer la requete ? Il faut savoir que ce sont des query de type poste
    /*
    query{
      accountsList{ // la méthode
        id, balance // les éléments à retourner
        }
    }
     */
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepositoty.findAll();
    }
    @QueryMapping
    public List<Customer> customers(){
        return customerRepositoty.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepositoty.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO){
        //BankAccount bankAccount = accountMapper.toBankAccount(bankAccountRequestDTO);
        return accountService.addAccount(bankAccountRequestDTO);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccountRequestDTO){
        // BankAccount bankAccount = accountMapper.toBankAccount(bankAccountRequestDTO);
        return accountService.updateAccount(id, bankAccountRequestDTO);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
        bankAccountRepositoty.deleteById(id);
        return true;
    }
}
