package vn.com.webbanhang.request;

import vn.com.webbanhang.entity.OrderItem;

import java.util.Date;
import java.util.List;

public class OrderRequest {
    Long id; // id của đơn đặt hàng
    Long AccountId; // id của tài khoản liên quan đến đơn đặt hàng
    double totalAmount; // tổng tiền đơn hàng
    Date purchaseDate; // ngày mua hàng
    String status; // trạng thái của đơn hàng
    String description; // mô tả đơn hàng
    List<OrderItem> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return AccountId;
    }

    public void setAccountId(Long accountId) {
        AccountId = accountId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
