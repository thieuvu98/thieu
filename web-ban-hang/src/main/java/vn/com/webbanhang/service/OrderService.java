package vn.com.webbanhang.service;

import vn.com.webbanhang.request.OrderRequest;
import vn.com.webbanhang.response.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);

    void removeOrder(Long id);
}
