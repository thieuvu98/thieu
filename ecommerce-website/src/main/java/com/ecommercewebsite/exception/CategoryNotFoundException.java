package com.ecommercewebsite.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String  s) {
        super(s);
    }
}
