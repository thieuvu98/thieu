package com.ecommercewebsite.service.impl;

import com.ecommercewebsite.exception.CategoryNotFoundException;
import com.ecommercewebsite.mapper.CategoryMapper;
import com.ecommercewebsite.model.entity.Category;
import com.ecommercewebsite.model.request.CreateCategoryRequest;
import com.ecommercewebsite.model.request.UpdateCategoryRequest;
import com.ecommercewebsite.model.response.CategoryResponse;
import com.ecommercewebsite.repository.CategoryRepository;
import com.ecommercewebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired private CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getCategories() {
       return categoryRepository.findAll().stream()
               .map(category -> categoryMapper.map(category))
               .toList();
    }

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = categoryRepository.save(categoryMapper.map(createCategoryRequest));
        return categoryMapper.map(category);
    }

    @Override
    public CategoryResponse updateCategory(UpdateCategoryRequest updateCategoryRequest) {
        categoryRepository.findById(updateCategoryRequest.getId())
                .orElseThrow(()-> new CategoryNotFoundException("Category Not Found With id: "+updateCategoryRequest.getId()));
        Category category = categoryRepository.save(categoryMapper.map(updateCategoryRequest));
        return categoryMapper.map(category);
    }
}
