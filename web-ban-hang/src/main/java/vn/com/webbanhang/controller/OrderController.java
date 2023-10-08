package vn.com.webbanhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.webbanhang.request.OrderRequest;
import vn.com.webbanhang.response.OrderResponse;
import vn.com.webbanhang.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){
        return ResponseEntity.ok(service.createOrder(request));
    }
}
