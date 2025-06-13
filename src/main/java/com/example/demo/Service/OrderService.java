package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Order;

public interface OrderService {
	Order createOrder(Long userId, Cart cart);
    List<Order> getUserOrders(Long userId);
}
