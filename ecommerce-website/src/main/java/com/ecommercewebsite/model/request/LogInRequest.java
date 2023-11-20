package com.ecommercewebsite.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
