package com.ecommercewebsite.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    @NotNull
    private String name;
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    private String password;
}
