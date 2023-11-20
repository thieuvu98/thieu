package com.ecommercewebsite.controller;

import com.ecommercewebsite.model.request.CreateProductRequest;
import com.ecommercewebsite.model.request.UpdateProductRequest;
import com.ecommercewebsite.model.response.ProductResponse;
import com.ecommercewebsite.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/{categoryId}")
    public ResponseEntity<Page<ProductResponse>> getProducts(@PathVariable("categoryId") @NotNull @PositiveOrZero Long categoryId,
                                                             @RequestParam int page,
                                                             @RequestParam int size){
        return ResponseEntity.ok(service.getProducts(categoryId, PageRequest.of(page, size)));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid CreateProductRequest createProductRequest){
        return ResponseEntity.ok(service.createProduct(createProductRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable @NotNull @PositiveOrZero Long id,
                                           @Valid @RequestBody UpdateProductRequest updateProductRequest){
        return ResponseEntity.ok(service.updateProduct(updateProductRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable @PositiveOrZero @NotNull Long id){
        service.removeProduct(id);
        return ResponseEntity.ok().build();
    }
}
