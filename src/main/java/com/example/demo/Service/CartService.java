package com.example.demo.Service;

import com.example.demo.Entity.CardDTO;
import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Item;

public interface CartService {
	Cart createCart();
	Cart addItemToCart(Long cartId, Item item);
    Cart removeItemFromCart(Long cartId, Long itemId);
    Cart getCartById(Long cartId);
//    public CartDTO addItemToCart(Long cartId, Item item)
    CardDTO addItemToCart1(Long cartId, Item item);

}
