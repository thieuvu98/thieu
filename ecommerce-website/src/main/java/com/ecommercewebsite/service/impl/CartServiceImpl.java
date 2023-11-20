package com.ecommercewebsite.service.impl;

import com.ecommercewebsite.exception.CartNotFoundException;
import com.ecommercewebsite.exception.ProductNotFoundException;
import com.ecommercewebsite.mapper.CartMapper;
import com.ecommercewebsite.model.CartStatus;
import com.ecommercewebsite.model.entity.Cart;
import com.ecommercewebsite.model.request.CreateCartRequest;
import com.ecommercewebsite.model.request.UpdateCartRequest;
import com.ecommercewebsite.model.response.CartResponse;
import com.ecommercewebsite.model.response.ProductResponse;
import com.ecommercewebsite.repository.CartRepository;
import com.ecommercewebsite.service.CartService;
import com.ecommercewebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductService productService;
    @Override
    public List<CartResponse> getCarts(Long accountId) {
        List<Cart> carts = cartRepository.findByAccountIdAndStatus(accountId, CartStatus.PROCESSING);
        List<Long> productIds = carts.stream()
                .map(Cart::getProductId)
                .toList();
        List<ProductResponse> products = productService.getProducts(productIds);
        Map<Long, ProductResponse> productMap = products.stream()
                .collect(Collectors.toMap(ProductResponse::getId, Function.identity()));
        return carts.stream()
                .map(cart -> {
                    CartResponse cartResponse = cartMapper.map(cart);
                    ProductResponse productResponse = productMap.get(cart.getProductId());
                    return cartResponse;
                })
                .toList();
    }

    @Override
    public CartResponse createCart(CreateCartRequest createCartRequest) {
        if (!productService.existProduct(createCartRequest.getProductId())){
            throw new ProductNotFoundException("Product Not Found");
        }
        Cart cart = cartMapper.map(createCartRequest);
        cartRepository.save(cart);
        return cartMapper.map(cart);
    }

    @Override
    public void removeProductInCart(Long productId) {
        Cart cart = cartRepository.findByProductId(productId)
                .orElseThrow(()-> new ProductNotFoundException("Cart Not Found"));
        cart.setStatus(CartStatus.CANCELLED);
        cart.setDeleted(true);
        cartRepository.save(cart);

    }

    @Override
    public CartResponse updateCart(Long id, UpdateCartRequest updateCartRequest) {

        Cart cart = cartRepository.findById(id)
                .orElseThrow(()-> new CartNotFoundException("Cart Not Found"));
        Cart updateCart = cartMapper.map(cart, updateCartRequest);
        cartRepository.save(updateCart);
        return cartMapper.map(updateCart);
    }
}
