package vn.com.webbanhang.response;

import vn.com.webbanhang.entity.OrderItem;

import java.util.Date;
import java.util.List;

public class OrderResponse {
    private Long id;
   private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
