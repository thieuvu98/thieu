package com.ecommercewebsite.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @SequenceGenerator(name = "account_id_seq", sequenceName = "account_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_seq")
    Long id;
    String name;
    @Column(unique = true, nullable = false, name = "username")
    String username;
    @Column(nullable = false, name = "password")
    @JsonIgnore
    String password;

}
