package vn.com.webbanhang.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.com.webbanhang.request.ProductRequest;
import vn.com.webbanhang.response.ProductResponse;

public interface ProductService {

    Page<ProductResponse> getProducts(Long categoryId, Pageable pageable);

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    void removeProduct(Long id);

    boolean existProduct(Long id);
}
