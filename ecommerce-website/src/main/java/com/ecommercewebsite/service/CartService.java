package com.ecommercewebsite.service;

import com.ecommercewebsite.model.request.CreateCartRequest;
import com.ecommercewebsite.model.request.UpdateCartRequest;
import com.ecommercewebsite.model.response.CartResponse;

import java.util.List;

public interface CartService {
    List<CartResponse> getCarts(Long accountId);

    CartResponse createCart(CreateCartRequest createCartRequest);

    void removeProductInCart(Long productId);

    CartResponse updateCart(Long id, UpdateCartRequest updateCartRequest);


}
