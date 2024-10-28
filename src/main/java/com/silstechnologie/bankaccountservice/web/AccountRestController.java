package com.silstechnologie.bankaccountservice.web;

import com.silstechnologie.bankaccountservice.dto.BankAccountRequestDTO;
import com.silstechnologie.bankaccountservice.dto.BankAccountResponseDTO;
import com.silstechnologie.bankaccountservice.entities.BankAccount;
import com.silstechnologie.bankaccountservice.mappers.AccountMapper;
import com.silstechnologie.bankaccountservice.repositories.BankAccountRepositoty;
import com.silstechnologie.bankaccountservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepositoty repositoty;
    private AccountService service;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepositoty repositoty, AccountService service, AccountMapper accountMapper) {
        this.repositoty = repositoty;
        this.service = service;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return repositoty.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable("id") String id){
        return repositoty.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccount){
        return service.addAccount(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account = repositoty.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null)
            account.setBalance(bankAccount.getBalance());
        account.setCreatedAt(new Date());
        if(bankAccount.getType()!=null)
            account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null)
            account.setCurrency(bankAccount.getCurrency());
        return repositoty.save(account);
    }


    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable("id") String id){
        repositoty.deleteById(id);
    }
}
