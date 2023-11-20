package com.ecommercewebsite.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountResponse {
    private Long id;
    private String name;
    private String username;
    private String password;
}
