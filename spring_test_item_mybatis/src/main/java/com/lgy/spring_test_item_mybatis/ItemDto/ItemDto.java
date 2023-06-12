package com.lgy.spring_test_item_mybatis.ItemDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
	private String name;
	private int price;
	private String description;
}
