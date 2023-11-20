package com.ecommercewebsite.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponse {
    private Long id;
    private Long invoiceId;
    private Long productId;
    private Long accountId;
    private Long quantity;
    private String status;
    private Boolean deleted;
}
