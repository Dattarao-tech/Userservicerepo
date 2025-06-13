package com.example.demo.Service;

import org.springframework.http.ResponseEntity;

import com.example.demo.Entity.CardDTO;
import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Item;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.User;

public interface CartService {
	Cart createCart();
	Cart addItemToCart(Long cartId, Item item);
    Cart removeItemFromCart(Long cartId, Long itemId);
    Cart getCartById(Long cartId);
//    public CartDTO addItemToCart(Long cartId, Item item)
    CardDTO addItemToCart1(Long cartId, Item item);

}
