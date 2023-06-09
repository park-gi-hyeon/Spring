package com.lgy.spring_test_item_jdbc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


public class ItemWriteService implements ItemService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String desciption = request.getParameter("description");
		
		ItemDao dao = new ItemDao();
		dao.write(name, Integer.parseInt(price), desciption);
	}
}
