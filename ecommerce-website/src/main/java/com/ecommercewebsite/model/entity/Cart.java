package com.ecommercewebsite.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_id_seq", sequenceName = "cart_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_id_seq")
    Long id;
    @Column(name = "invoice_id")
    Long invoiceId;
    @Column(name = "product_id")
    Long productId;
    @Column(name = "account_id")
    Long accountId;
    Long quantity;
    String status;
    Boolean deleted;
}
