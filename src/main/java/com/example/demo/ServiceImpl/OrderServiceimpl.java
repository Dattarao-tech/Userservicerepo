package com.example.demo.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.User;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.OrderService;

@Service
public class OrderServiceimpl implements OrderService{


	  private static final Logger logger = LoggerFactory.getLogger(OrderServiceimpl.class);

	    @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private UserRepository userRepository;

	@Override
    public Order createOrder(Long userId, Cart cart) {
        logger.debug("Creating order for userId: {}", userId);

        if (cart == null || cart.getItems() == null) {
            logger.error("Cart or cart items cannot be null for userId: {}", userId);
            throw new RuntimeException("Cart or cart items cannot be null");
        }

        // Calculate total amount from cart items
        double totalAmount = cart.getItems().stream()
            .mapToDouble(item -> item.getSellingPrice() * item.getUnitsAvailable())
            .sum();

        logger.info("Total amount calculated: {}", totalAmount);

        // Fetch the user from the database
        User user = userRepository.findById(userId)
            .orElseThrow(() -> {
                logger.error("User not found with userId: {}", userId);
                return new RuntimeException("User not found");
            });

        // Create a new order instance
        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(totalAmount);
        order.setStatus("Pending");

        // Save the order to the database
        Order savedOrder = orderRepository.save(order);
        logger.info("Order created successfully with ID: {}", savedOrder.getId());

        return savedOrder;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        logger.debug("Fetching orders for userId: {}", userId);
        return orderRepository.findByUserId(userId);
    }
}




