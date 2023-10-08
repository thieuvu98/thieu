package vn.com.webbanhang.service;

import vn.com.webbanhang.entity.Cart;
import vn.com.webbanhang.request.CartRequest;
import vn.com.webbanhang.response.CartResponse;

public interface CartService {
    CartResponse getCart(Long id);
    void createCart(CartRequest request);

    void removeCart(Long productId);

    void updateCart(Long id, CartRequest request);

    Cart findByInvoiceId(Long invoiceId);

}
