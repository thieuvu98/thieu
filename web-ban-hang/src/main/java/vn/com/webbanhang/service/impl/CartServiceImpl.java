package vn.com.webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.webbanhang.entity.Cart;
import vn.com.webbanhang.exception.CartNotFoundException;
import vn.com.webbanhang.exception.ProductNotFoundException;
import vn.com.webbanhang.repository.CartRepository;
import vn.com.webbanhang.request.CartRequest;
import vn.com.webbanhang.response.CartResponse;
import vn.com.webbanhang.service.CartService;
import vn.com.webbanhang.service.ProductService;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    @Override
    public void createCart(CartRequest request) {
        if (!productService.existProduct(request.getProductId())){
            throw new ProductNotFoundException(" Product Not Found ");
        }else {
            Cart cart = new Cart();
            cart.setId(request.getId());
            cart.setProductId(request.getProductId());
            cart.setQuantity(request.getQuantity());
            cart.setAccountId(request.getAccountId());
            cart.setInvoiceId(request.getInvoiceId());
            cart.setStatus("waiting");
            cart.setDeleted(false);
            cartRepository.save(cart);
        }
    }

    @Override
    public CartResponse getCart(Long id) {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if (cartOptional.isEmpty()){
            throw new CartNotFoundException("Cart Not Found");
        }else{
            Cart cart = cartOptional.get();
            CartResponse response = new CartResponse();
            response.setId(cart.getId());
            response.setInvoiceId(cart.getInvoiceId());
            response.setProductId(cart.getProductId());
            response.setQuantity(cart.getQuantity());
            response.setAccountId(cart.getAccountId());
            response.setStatus(cart.getStatus());
            response.setDeleted(cart.isDeleted());
            return response;
        }
    }

    @Override
    public void removeCart(Long productId) {
        Cart cart = cartRepository.findByProductId(productId).orElseThrow(()
                        ->new ProductNotFoundException("Cart Not Found"));
        cart.setStatus("Cancelled");
        cart.setDeleted(true);
        cartRepository.save(cart);
        }

    @Override
    public void updateCart(Long id, CartRequest request) {
        Cart cart = cartRepository.findById(id).orElseThrow(()
                ->new ProductNotFoundException("Cart Not Found"));
        cart.setId(request.getId());
        cart.setProductId(request.getProductId());
        cart.setAccountId(request.getAccountId());
        cart.setQuantity(request.getQuantity());
        cart.setDeleted(request.isDeleted());
        cart.setInvoiceId(request.getInvoiceId());
        cart.setStatus(request.getStatus());
        cart.setDeleted(request.isDeleted());
        cartRepository.save(cart);
    }

    @Override
    public Cart findByInvoiceId(Long invoiceId) {
        return cartRepository.findByInvoiceId(invoiceId);
    }

}
