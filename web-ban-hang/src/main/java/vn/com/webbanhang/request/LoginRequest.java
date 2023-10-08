package vn.com.webbanhang.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class LoginRequest {
    @NotBlank(message = "Username must not be blank")
    private String username;
    @NotBlank(message = "Username must not blank")
    private String hashPass;
    @Email
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }
}
