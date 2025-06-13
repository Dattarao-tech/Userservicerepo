package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Item;

public interface ItemService {
	Item createItem(Item item);
    Item getItemById(Long id);
    List<Item> getAllItems();
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
}
