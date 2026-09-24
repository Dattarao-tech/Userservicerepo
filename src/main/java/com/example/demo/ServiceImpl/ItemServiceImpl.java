package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Item;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.Service.ItemService;


@Service
public class ItemServiceImpl implements ItemService{

	    @Autowired
	    private ItemRepository itemRepository;

	    @Override
	    public Item createItem(Item item) {
	        return itemRepository.save(item);
	    }

	    @Override
	    public Item getItemById(Long id) {
	        return itemRepository.findById(id).orElse(null);
	    }

	    @Override
	    public List<Item> getAllItems() {
	        return itemRepository.findAll();
	    }

	    @Override
	    public Item updateItem(Long id, Item item) {
	        if (!itemRepository.existsById(id)) {
	            return null;
	        }
	        item.setId(id);
	        return itemRepository.save(item);
	    }

	    @Override
	    public void deleteItem(Long id) {
	        itemRepository.deleteById(id);
	    }
	}


