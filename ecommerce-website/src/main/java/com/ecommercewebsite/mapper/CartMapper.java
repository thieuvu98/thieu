package com.ecommercewebsite.mapper;

import com.ecommercewebsite.model.CartStatus;
import com.ecommercewebsite.model.entity.Cart;
import com.ecommercewebsite.model.request.CreateCartRequest;
import com.ecommercewebsite.model.request.UpdateCartRequest;
import com.ecommercewebsite.model.response.CartResponse;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public CartResponse map(Cart cart){
        CartResponse response = new CartResponse();
        response.setId(cart.getId());
        response.setInvoiceId(cart.getInvoiceId());
        response.setProductId(cart.getProductId());
        response.setQuantity(cart.getQuantity());
        response.setAccountId(cart.getAccountId());
        response.setStatus(cart.getStatus());
        response.setDeleted(cart.getDeleted());
        return response;
    }
    public Cart map(CreateCartRequest createCartRequest){
        Cart cart = new Cart();
        cart.setProductId(createCartRequest.getProductId());
        cart.setAccountId(createCartRequest.getAccountId());
        cart.setInvoiceId(createCartRequest.getInvoiceId());
        cart.setQuantity(createCartRequest.getQuantity());
        cart.setStatus(CartStatus.PROCESSING);
        cart.setDeleted(false);
        return cart;
    }

    public Cart map(Cart cart, UpdateCartRequest updateCartRequest){
        cart.setProductId(updateCartRequest.getProductId());
        cart.setAccountId(updateCartRequest.getAccountId());
        cart.setInvoiceId(updateCartRequest.getInvoiceId());
        cart.setQuantity(updateCartRequest.getQuantity());
        cart.setStatus(updateCartRequest.getStatus());
        cart.setDeleted(updateCartRequest.getDeleted());
        return cart;
    }
}
