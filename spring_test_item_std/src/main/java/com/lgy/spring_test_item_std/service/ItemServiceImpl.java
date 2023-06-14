package com.lgy.spring_test_item_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgy.spring_test_item_std.dao.*;
import com.lgy.spring_test_item_std.dto.ItemDto;

//@Service("ItemService")
@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(HashMap<String, String> param) {
		ItemDao dao = sqlSession.getMapper(ItemDao.class);
//		dao.write(request.getParameter("name")
//				, Integer.parseInt(request.getParameter("price"))
//				, request.getParameter("description"));
		dao.write(param);
	}

	@Override
	public ArrayList<ItemDto> contentView() {
		ItemDao dao = sqlSession.getMapper(ItemDao.class);
//		model.addAttribute("content_view", dao.contentView());
		ArrayList<ItemDto> dtos = dao.contentView();
		
		return dtos;
	}

}





