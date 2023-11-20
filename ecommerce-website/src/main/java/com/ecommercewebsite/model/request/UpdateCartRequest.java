package com.ecommercewebsite.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCartRequest {
    private Long productId;
    private Long accountId;
    private Long invoiceId;
    private Long quantity;
    private String status;
    private Boolean deleted;
}
