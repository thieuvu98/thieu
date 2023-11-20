package com.ecommercewebsite.service.impl;

import com.ecommercewebsite.exception.ProductNotFoundException;
import com.ecommercewebsite.model.entity.Product;
import com.ecommercewebsite.mapper.ProductMapper;
import com.ecommercewebsite.model.request.CreateProductRequest;
import com.ecommercewebsite.model.request.UpdateProductRequest;
import com.ecommercewebsite.model.response.ProductResponse;
import com.ecommercewebsite.repository.ProductRepository;
import com.ecommercewebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Page<ProductResponse> getProducts(Long categoryId, Pageable pageable) {
        var products =  repository.findByCategoryId(categoryId);
        return new PageImpl<>(products.stream().map(productMapper::map).toList(), pageable, products.size());
    }

    @Override
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        var product = repository.save(productMapper.map(createProductRequest));
        return productMapper.map(product);
    }

    @Override
    public ProductResponse updateProduct(UpdateProductRequest updateProductRequest) {
        repository.findById(updateProductRequest.getId())
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found With Id: "+updateProductRequest.getId()));
        Product updateProduct = repository.save(productMapper.map(updateProductRequest));
        return productMapper.map(updateProduct);
    }


    @Override
    public void removeProduct(Long id) {
        var product = repository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product Not found With Id: "+id));
        product.setDeleted(true);
        repository.save(product);
    }

    @Override
    public List<ProductResponse> getProducts(List<Long> productIds) {
        return repository.findByIdIn(productIds)
                .stream()
                .map(product -> productMapper.map(product))
                .toList();
    }

    @Override
    public Boolean existProduct(Long id) {
        return repository.existsById(id);
    }
}
