package vn.com.webbanhang.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @SequenceGenerator(name = "order_item_id_seq", sequenceName = "order_item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_id_seq")
    Long id; //Id của mục hàng trong đơn đặt hàng
    Long productId; //Id của sản phẩm
    int quantity; // số lượng sản phẩm
    String status; // trạng thái của mục hàng (đã, chờ lên đơn hàng)
    boolean deleted; // trạng thái xóa mục hàng

    public OrderItem(Long productId, int quantity, String status, boolean deleted) {
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        this.deleted = deleted;
    }

    public OrderItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
