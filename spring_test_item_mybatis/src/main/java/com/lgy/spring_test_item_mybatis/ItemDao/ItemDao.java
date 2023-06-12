package com.lgy.spring_test_item_mybatis.ItemDao;

import java.util.ArrayList;

import com.lgy.spring_test_item_mybatis.ItemDto.ItemDto;


public interface ItemDao {
	public void write(String name, String price, String description);
	public ArrayList<ItemDto> list();
}
