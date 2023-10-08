package vn.com.webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.webbanhang.entity.Order;
import vn.com.webbanhang.repository.OrderRepository;
import vn.com.webbanhang.request.OrderRequest;
import vn.com.webbanhang.response.OrderResponse;
import vn.com.webbanhang.service.OrderService;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setId(orderRequest.getId());
        order.setAccountId(orderRequest.getAccountId());
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setPurchaseDate(new Date());
        order.setStatus("waiting");
        order.setDescription(orderRequest.getDescription());
        order.setOrderItems(orderRequest.getOrderItems());
        repository.save(order);
        OrderResponse response = new OrderResponse();
        response.setId(repository.save(order).getId());
        response.setMessage(" Create Order SuccessFully");
    return response;
    }
}
