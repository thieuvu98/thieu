package com.ecommercewebsite.model.request;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateInvoiceRequest {
    @Positive
    private Long accountId;
    private Double totalAmount;
    private Date purchaseDate;
    private String status;
    private String describe;
}
