package com.ecommercewebsite.service;

import com.ecommercewebsite.model.request.CreateCategoryRequest;
import com.ecommercewebsite.model.request.UpdateCategoryRequest;
import com.ecommercewebsite.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getCategories();

    CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);

    CategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest);
}
