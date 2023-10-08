package vn.com.webbanhang.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SignupRequest {
    private String name;
    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank(message = "Pass must not be Blank")
    private String hashPass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
