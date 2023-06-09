package com.lgy.spring_test_item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDto {
	private String name;
	private int price;
	private String description;
}
