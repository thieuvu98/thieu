package com.ecommercewebsite.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {
    private Long id;
    private String name;
    private Double amount;
    private Double price;
    private Long quantity;
    private String link;
    private Long categoryId;
    private Boolean deleted;
}
