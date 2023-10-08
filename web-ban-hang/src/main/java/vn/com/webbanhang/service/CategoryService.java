package vn.com.webbanhang.service;

import vn.com.webbanhang.request.CategoryRequest;
import vn.com.webbanhang.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getCategories();

    CategoryResponse getCategory(Long id);

    CategoryResponse createCategory(CategoryRequest categoryRequest);

    CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest);

}
