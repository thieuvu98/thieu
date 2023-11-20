package com.ecommercewebsite.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    private String name;
    private Double amount;
    private Double price;
    private Long quantity;
    private String Link;
    private Long categoryId;
    private Boolean deleted;
}
