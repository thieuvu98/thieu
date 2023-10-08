package vn.com.webbanhang.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.webbanhang.request.CartRequest;
import vn.com.webbanhang.response.CartResponse;
import vn.com.webbanhang.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    
    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCart(@PathVariable @Positive Long id){
        return ResponseEntity.ok(cartService.getCart(id));
    }

    @PostMapping
    public ResponseEntity<?> createCart(@RequestBody @Valid CartRequest cartRequest){
        cartService.createCart(cartRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity <?> removeCart(@RequestParam @Positive Long productId){
        cartService.removeCart(productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCart(@PathVariable @Positive Long id,
                                        @Valid @RequestBody CartRequest cartRequest){
        cartService.updateCart(id, cartRequest);
        return ResponseEntity.ok().build();
    }
}
