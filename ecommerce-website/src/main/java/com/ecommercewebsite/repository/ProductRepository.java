package com.ecommercewebsite.repository;

import com.ecommercewebsite.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long > {
     default List<Product> findByCategoryId(Long categoryId){
         return findByCategoryIdAndDeleted(categoryId,false);
     }

    List<Product> findByCategoryIdAndDeleted(Long categoryId, Boolean deleted);

     default List<Product> findByIdIn(List<Long> productIds){
         return findByIdInAndDeleted(productIds, false);
     }

    List<Product> findByIdInAndDeleted(List<Long> productIds, boolean deleted);

     boolean existsById(Long id);

}
