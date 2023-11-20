package com.ecommercewebsite.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InvoiceResponse {
    private Long id;
    private Long accountId;
    private Double totalAmount;
    private LocalDate purchaseDate;
    private String status;
    private String describe;
}
