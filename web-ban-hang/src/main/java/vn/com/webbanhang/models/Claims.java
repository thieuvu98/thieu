package vn.com.webbanhang.models;

import com.auth0.jwt.interfaces.DecodedJWT;
import vn.com.webbanhang.entity.Account;

public class Claims {
    private String accountId;
    private DecodedJWT decodedJWT;

    public Claims(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public static Claims from(DecodedJWT decodedJWT){
        return new Claims(
                decodedJWT.getClaim("account_id").asString()
        );
    }

    public static Claims from(Account account){
        return new Claims(
                account.getUsername()
        );
    }

}
