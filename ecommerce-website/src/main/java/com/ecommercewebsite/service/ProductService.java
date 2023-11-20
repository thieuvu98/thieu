package com.ecommercewebsite.service;

import com.ecommercewebsite.model.request.CreateProductRequest;
import com.ecommercewebsite.model.request.UpdateProductRequest;
import com.ecommercewebsite.model.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<ProductResponse> getProducts(Long categoryId, Pageable pageable);
    ProductResponse createProduct(CreateProductRequest createProductRequest);

    ProductResponse updateProduct(UpdateProductRequest updateProductRequest);

    void removeProduct(Long id);

    List<ProductResponse> getProducts(List<Long> productIds);

    Boolean existProduct(Long id);
}
