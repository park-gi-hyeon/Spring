package com.lgy.spring_test_item;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;



public class ItemContentService implements ItemService{

	@Override
	public void execute(Model model) {
		//dao 단 호출
		ItemDao dao=new ItemDao();
//		게시글들을 dtos 객체로 받음
		ArrayList<ItemDto> dtos = dao.list();
//		dtos 객체를 list 이름으로 컨트롤러단으로 전송
		model.addAttribute("list", dtos);
	}
}
