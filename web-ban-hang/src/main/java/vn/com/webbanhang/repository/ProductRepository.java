package vn.com.webbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.webbanhang.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // lay danh sach san pham dua vao id danh muc
    List<Product> findProductByCategoryId(Long categoryId);

    boolean existsById(Long id);

}
