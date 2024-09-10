package com.accountmicroservice.account.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String type;

    private int balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner")
    private Customer owner;

}
