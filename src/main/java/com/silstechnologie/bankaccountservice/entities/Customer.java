package com.silstechnologie.bankaccountservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // pour reste afin d'eviter l'erreur bidirectionnel
    private List<BankAccount> bankAccounts;
}
