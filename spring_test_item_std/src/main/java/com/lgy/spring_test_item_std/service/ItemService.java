package com.lgy.spring_test_item_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.spring_test_item_std.dto.ItemDto;

public interface ItemService {
	public void write(HashMap<String, String> param);
	public ArrayList<ItemDto> contentView();
}
