package vn.com.webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.webbanhang.entity.Product;
import vn.com.webbanhang.exception.ProductDeleteException;
import vn.com.webbanhang.exception.ProductNotFoundException;
import vn.com.webbanhang.repository.ProductRepository;
import vn.com.webbanhang.request.ProductRequest;
import vn.com.webbanhang.response.ProductResponse;
import vn.com.webbanhang.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    private ProductResponse mapToProductResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setCost(product.getCost());
        response.setPrice(product.getPrice());
        response.setAmount(product.getAmount());
        response.setLink(product.getLink());
        response.setCategoryId(product.getCategoryId());
        response.setDeleted(product.getDeleted());
        return response;
    }


    @Override
    public Page<ProductResponse> getProducts(Long categoryId, Pageable pageable) {
        List<Product> products = productRepository.findProductByCategoryId(categoryId);
        List<ProductResponse> productResponses = new ArrayList<>();

        for (Product product : products) {
            ProductResponse response = mapToProductResponse(product);
            productResponses.add(response);
        }
        return new PageImpl<>(productResponses, pageable, productResponses.size());
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setCost(productRequest.getCost());
        product.setPrice(productRequest.getPrice());
        product.setAmount(productRequest.getAmount());
        product.setLink(productRequest.getLink());
        product.setCategoryId(productRequest.getCategoryId());
        product.setDeleted(productRequest.getDeleted());
        return mapToProductResponse(productRepository.save(product));

    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()){
            throw new ProductNotFoundException("Product Not found");
        }
        Product existingProduct = productOptional.get();
        existingProduct.setId(productRequest.getId());
        existingProduct.setName(productRequest.getName());
        existingProduct.setCategoryId(productRequest.getCategoryId());
        existingProduct.setCost(productRequest.getCost());
        existingProduct.setAmount(productRequest.getAmount());
        existingProduct.setLink(productRequest.getLink());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setDeleted(productRequest.getDeleted());
        productRepository.save(existingProduct);
        return mapToProductResponse(existingProduct);
    }

    @Override
    public void removeProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()){
            throw new ProductNotFoundException("Product Not Found with id: " +id);
        }else {
            Product product = productOptional.get();
            product.setDeleted(true);
            productRepository.save(product);
        }
    }

    @Override
    public boolean existProduct(Long id) {
        return productRepository.existsById(id);
    }
}
