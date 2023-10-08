package vn.com.webbanhang.entity;

import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_id_seq", sequenceName = "cart_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_id_seq")
    Long id;
    Long accountId;
    Long invoiceId;
    Long productId;
    Long quantity;
    String status;
    boolean deleted;

    public Cart(){}

    public Cart(Long accountId, Long invoiceId, Long productId, Long quantity, String status, boolean deleted) {
        this.accountId = accountId;
        this.invoiceId = invoiceId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
