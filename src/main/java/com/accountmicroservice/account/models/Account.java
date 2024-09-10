package com.accountmicroservice.account.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
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
