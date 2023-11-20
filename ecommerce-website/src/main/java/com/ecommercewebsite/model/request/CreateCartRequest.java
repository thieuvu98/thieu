package com.ecommercewebsite.model.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCartRequest {
    @Positive
    private Long productId;
    @Positive
    private Long accountId;
    @Positive
    private Long invoiceId;
    @PositiveOrZero
    private Long quantity;
    private String status;
    private Boolean Deleted;
}
