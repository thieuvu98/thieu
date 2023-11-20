package com.ecommercewebsite.controller;

import com.ecommercewebsite.model.request.CreateCartRequest;
import com.ecommercewebsite.model.request.UpdateCartRequest;
import com.ecommercewebsite.service.CartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<?> getCarts(@RequestParam @Positive @NotNull Long accountId){
        return ResponseEntity.ok(cartService.getCarts(accountId));
    }

    @PostMapping
    public ResponseEntity<?> createCart(@RequestBody @Valid CreateCartRequest createCartRequest){
        cartService.createCart(createCartRequest);
        return ResponseEntity.ok("create cart successfully");
    }

    @DeleteMapping
    public ResponseEntity<?> removeCart(@RequestParam @Positive @NotNull Long productId){
        cartService.removeProductInCart(productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCart(@PathVariable @Positive Long id,
                                        @Valid @RequestBody UpdateCartRequest updateCartRequest){
        cartService.updateCart(id, updateCartRequest);
        return ResponseEntity.ok().build();
    }
}
