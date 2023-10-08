package vn.com.webbanhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.webbanhang.request.CategoryRequest;
import vn.com.webbanhang.response.CategoryResponse;
import vn.com.webbanhang.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id){
       return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest){
        return ResponseEntity.ok(categoryService.createCategory(categoryRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategories(@PathVariable Long id,
                                                    @RequestBody CategoryRequest updateCategoryRequest){
        return ResponseEntity.ok(categoryService.updateCategory(id, updateCategoryRequest));
    }
}
