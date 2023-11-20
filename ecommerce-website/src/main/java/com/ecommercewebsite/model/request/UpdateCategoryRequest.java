package com.ecommercewebsite.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryRequest {
    private Long id;
    private String name;
}
