package vn.com.webbanhang.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.webbanhang.exception.ProductDeleteException;
import vn.com.webbanhang.exception.ProductNotFoundException;
import vn.com.webbanhang.request.ProductRequest;
import vn.com.webbanhang.response.ProductResponse;
import vn.com.webbanhang.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getProducts(@RequestParam @NotNull @Positive Long categoryId,
                                                            @RequestParam @PositiveOrZero int page,
                                                            @RequestParam @Positive int size){
        return ResponseEntity.ok(service.getProducts(categoryId, PageRequest.of(page, size)));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest productRequest){
        return ResponseEntity.ok(service.createProduct(productRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
                                                         @RequestBody @Valid ProductRequest productRequest){
        try {
            ProductResponse updateProduct = service.updateProduct(id, productRequest);
            return ResponseEntity.ok(updateProduct);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ProductDeleteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long id){
        try {
            service.removeProduct(id);
            return ResponseEntity.ok().build();
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
