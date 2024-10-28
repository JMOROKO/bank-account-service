package com.silstechnologie.bankaccountservice.web;

import com.silstechnologie.bankaccountservice.entities.BankAccount;
import com.silstechnologie.bankaccountservice.repositories.BankAccountRepositoty;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepositoty repositoty;

    public AccountRestController(BankAccountRepositoty repositoty) {
        this.repositoty = repositoty;
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
    public BankAccount save(@RequestBody BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return repositoty.save(bankAccount);
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
