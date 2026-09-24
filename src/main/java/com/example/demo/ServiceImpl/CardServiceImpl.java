package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.CardDTO;
import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Item;
import com.example.demo.Entity.Itemdto;
import com.example.demo.Repository.CardRepository;
import com.example.demo.Service.CartService;

@Service
public class CardServiceImpl implements CartService{

	   @Autowired
	    private CardRepository cartRepository;

	    @Override
	    public Cart createCart() {
	    	Cart cart = new Cart();

	        // If there are any default values or initializations needed, do them here
	        // For example, initializing an empty list for items
	        cart.setItems(new ArrayList<>()); // Assuming 'items' is a List in Cart


	        // Save the cart to the repository and return it
	        return cartRepository.save(cart);
	    }
	    @Override
	    public Cart addItemToCart(Long cartId, Item item) {

	    	 Cart cart = cartRepository.findById(cartId)
	    	            .orElseThrow(() -> new RuntimeException("Cart not found"));

	    	    // Add item to cart without circular reference
	    	    item.setCart(cart); // Set the cart reference in item
	    	    cart.getItems().add(item); // Add item to cart's item list

	    	    // Save the updated cart
	    	    return cartRepository.save(cart);
	    }

	    @Override
	    public Cart removeItemFromCart(Long cartId, Long itemId) {
	        Cart cart = cartRepository.findById(cartId)
	                .orElseThrow(() -> new RuntimeException("Cart not found"));

	        Item itemToRemove = cart.getItems().stream()
	                .filter(item -> item.getId().equals(itemId))
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("Item not found in cart"));

	        cart.removeItem(itemToRemove); // Remove item from cart
	        return cartRepository.save(cart); // Save changes
	    }

	    @Override
	    public Cart getCartById(Long cartId) {
	        return cartRepository.findById(cartId)
	                .orElseThrow(() -> new RuntimeException("Cart not found"));
	    }
		@Override
		public CardDTO addItemToCart1(Long cartId, Item item) {
			Cart cart = cartRepository.findById(cartId)
		            .orElseThrow(() -> new RuntimeException("Cart not found"));

		    item.setCart(cart);
		    cart.getItems().add(item);

		    Cart savedCart = cartRepository.save(cart);
		    return convertToDTO(savedCart);
		}

		private CardDTO convertToDTO(Cart cart) {
		    CardDTO dto = new CardDTO();
		    dto.setId(cart.getId());
		    dto.setItems(cart.getItems().stream()
		            .map(this::convertToItemDTO)
		            .collect(Collectors.toList()));
		    return dto;
		}

		private Itemdto convertToItemDTO(Item item) {
		    Itemdto dto = new Itemdto();
		    dto.setId(item.getId());
		    dto.setName(item.getName());
		    dto.setSellingPrice(item.getSellingPrice());
//		    dto.setUnitsAvailable(item.getUnitsAvailable());
		    return dto;

	}

}