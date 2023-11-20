package com.ecommercewebsite.controller;

import com.ecommercewebsite.model.request.CreateCategoryRequest;
import com.ecommercewebsite.model.request.UpdateCategoryRequest;
import com.ecommercewebsite.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(service.getCategories());
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody@Valid CreateCategoryRequest request){
        return ResponseEntity.ok(service.createCategory(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable @NotNull @PositiveOrZero Long id,
                                            @RequestBody @Valid UpdateCategoryRequest categoryRequest){
        return ResponseEntity.ok(service.updateCategory(categoryRequest));
    }
}
