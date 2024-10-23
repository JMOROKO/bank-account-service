package com.silstechnologie.bankaccountservice;

import com.silstechnologie.bankaccountservice.entities.BankAccount;
import com.silstechnologie.bankaccountservice.enums.AccountType;
import com.silstechnologie.bankaccountservice.repositories.BankAccountRepositoty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(BankAccountRepositoty bankAccountRepositoty){
		return args -> {
			for(int i=0; i<=9; i++){
				BankAccount account = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
						.balance(Math.random()*9000*i)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				bankAccountRepositoty.save(account);
			}
		};
	}
}
