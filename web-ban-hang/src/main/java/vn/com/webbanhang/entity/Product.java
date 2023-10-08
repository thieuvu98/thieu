package vn.com.webbanhang.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    Long id;
    String name;
    Double cost;
    Double price;
    Long amount;
    String link;
    @Column(name = "category_id")
    Long categoryId;
    Boolean deleted;

    public Product(){

    }

    public Product(String name, Double cost, Double price, Long amount, String link, Long categoryId, Boolean deleted) {
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.amount = amount;
        this.link = link;
        this.categoryId = categoryId;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", price=" + price +
                ", amount=" + amount +
                ", link='" + link + '\'' +
                ", categoryId=" + categoryId +
                ", deleted=" + deleted +
                '}';
    }
}
