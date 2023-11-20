package com.ecommercewebsite.repository;

import com.ecommercewebsite.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
