package vn.com.webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.webbanhang.entity.Category;
import vn.com.webbanhang.exception.CategoryNotFoundException;
import vn.com.webbanhang.repository.CategoryRepository;
import vn.com.webbanhang.request.CategoryRequest;
import vn.com.webbanhang.response.CategoryResponse;
import vn.com.webbanhang.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryResponse mapToCategoryResponse(Category category){
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    @Override
    public List<CategoryResponse> getCategories() {
        var categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : categories) {
            categoryResponses.add(mapToCategoryResponse(category));
        }
        return categoryResponses;
    }

    @Override
    public CategoryResponse getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()
                -> new CategoryNotFoundException("Category Not Found"));
        return mapToCategoryResponse(category);
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setId(categoryRequest.getId());
        category.setName(category.getName());
        categoryRepository.save(category);
        return mapToCategoryResponse(category);
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest updateCategoryRequest) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new CategoryNotFoundException("Category Not Found");
        }else {
            Category category = categoryOptional.get();
            category.setId(updateCategoryRequest.getId());
            category.setName(updateCategoryRequest.getName());
            categoryRepository.save(category);
            return mapToCategoryResponse(category);
        }
    }


}
