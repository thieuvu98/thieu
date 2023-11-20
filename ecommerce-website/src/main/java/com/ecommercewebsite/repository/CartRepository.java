package com.ecommercewebsite.repository;

import com.ecommercewebsite.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    default List<Cart> findByAccountIdAndStatus(Long accountId, String status){
        return findByAccountIdAndStatusAndDeleted(accountId, status, false);
    }

    List<Cart> findByAccountIdAndStatusAndDeleted(Long accountId, String status, boolean deleted);

    Optional<Cart> findByProductId(Long productId);
}
