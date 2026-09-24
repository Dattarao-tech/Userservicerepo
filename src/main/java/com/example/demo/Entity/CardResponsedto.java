package com.example.demo.Entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardResponsedto {

	public CardResponsedto(Cart updatedCart) {
		// TODO Auto-generated constructor stub
	}

	private Long id;
    private List<Item> items;
}
