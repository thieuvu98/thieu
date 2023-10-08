package vn.com.webbanhang.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Invoice {
    @Id
    @SequenceGenerator(name = "invoice_id_seq", sequenceName = "invoice_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_id_seq")
    Long id;
    Long account_id;
    Double totalAmount;
    Date purchaseDate;
    String status;

    String describe;

    public Invoice(Long account_id, Double totalAmount, Date purchaseDate, String status, String describe) {
        this.account_id = account_id;
        this.totalAmount = totalAmount;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.describe = describe;
    }

    public Invoice() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
