package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.CardDTO;
import com.example.demo.Entity.CardResponsedto;
import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Item;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

	    @Autowired
	    private CartService cartService;

	    @PostMapping
	    public ResponseEntity<Cart> createCart() {

///	    	cartService.cr
       Cart cart = cartService.createCart();

	        if (cart != null) {
	            // Return 201 Created status with the created cart
	            return ResponseEntity.status(HttpStatus.CREATED).body(cart);
	        } else {
	            // Handle cart creation failure
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

//	    @PostMapping("/{cartId}/items")
	    public ResponseEntity<CardResponsedto> addItemToCart(@PathVariable Long cartId, @RequestBody Item item) {
	        try {
	            Cart updatedCart = cartService.addItemToCart(cartId, item);
	            CardResponsedto responseDTO = new CardResponsedto(updatedCart);
	            return ResponseEntity.ok(responseDTO);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    @DeleteMapping("/{cartId}/items/{itemId}")
	    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
	        Cart updatedCart = cartService.removeItemFromCart(cartId, itemId);
	        return ResponseEntity.ok(updatedCart);
	    }

	    @GetMapping("/{cartId}")
	    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
	        Cart cart = cartService.getCartById(cartId);
	        return ResponseEntity.ok(cart);
	    }

	    @PostMapping("/{cartId}/items")
	    public ResponseEntity<CardDTO> addItemToCart1(@PathVariable Long cartId, @RequestBody Item item) {
	        try {
	        	CardDTO cartDTO = cartService.addItemToCart1(cartId, item);
	            return ResponseEntity.ok(cartDTO);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	}

