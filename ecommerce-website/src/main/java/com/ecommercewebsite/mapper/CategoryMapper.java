package com.ecommercewebsite.mapper;

import com.ecommercewebsite.model.entity.Category;
import com.ecommercewebsite.model.request.CreateCategoryRequest;
import com.ecommercewebsite.model.request.UpdateCategoryRequest;
import com.ecommercewebsite.model.response.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponse map(Category category){
        CategoryResponse response = new CategoryResponse();
        response.setName(category.getName());
        return response;
    }

    public Category map(CreateCategoryRequest categoryRequest){
        Category category  = new Category();
        category.setName(categoryRequest.getName());
        return category;
    }

    public Category map(UpdateCategoryRequest updateCategoryRequest){
        Category category = new Category();
        category.setName(updateCategoryRequest.getName());
        return category;
    }
}
