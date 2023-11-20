package com.ecommercewebsite.mapper;

import com.ecommercewebsite.model.entity.Product;
import com.ecommercewebsite.model.request.CreateProductRequest;
import com.ecommercewebsite.model.request.UpdateProductRequest;
import com.ecommercewebsite.model.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse map(Product product){
        ProductResponse response = new ProductResponse();
        response.setName(product.getName());
        response.setAmount(product.getAmount());
        response.setPrice(product.getPrice());
        response.setQuantity(product.getQuantity());
        response.setLink(product.getLink());
        response.setCategoryId(product.getCategoryId());
        response.setDeleted(product.getDeleted());
        return response;
    }

    public Product map(CreateProductRequest createProductRequest){
        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setAmount(createProductRequest.getAmount());
        product.setPrice(createProductRequest.getPrice());
        product.setQuantity(createProductRequest.getQuantity());
        product.setLink(createProductRequest.getLink());
        product.setCategoryId(createProductRequest.getCategoryId());
        product.setDeleted(false);
        return product;
    }

    public Product map(UpdateProductRequest updateProductRequest){
        Product product = new Product();
        product.setName(updateProductRequest.getName());
        product.setAmount(updateProductRequest.getAmount());
        product.setPrice(updateProductRequest.getPrice());
        product.setQuantity(updateProductRequest.getQuantity());
        product.setLink(updateProductRequest.getLink());
        product.setCategoryId(updateProductRequest.getCategoryId());
        product.setDeleted(false);
        return product;
    }
}
