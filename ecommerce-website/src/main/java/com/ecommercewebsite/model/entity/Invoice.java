package com.ecommercewebsite.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Invoice {
    @Id
    @SequenceGenerator(name = "invoice_id_seq", sequenceName = "invoice_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_id_seq")
    Long id;
    @Column(name = "account_id")
    Long accountId;
    @Column(name = "total_amount")
    Double totalAmount;
    @Column(name = "purchase_date")
    LocalDate purchaseDate;
    String status;
    String describe;
}
