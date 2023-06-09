package com.lgy.spring_mvc_board_jdbc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.spring_mvc_board_jdbc.dao.BDao;
import com.lgy.spring_mvc_board_jdbc.dto.BDto;


public class BContentService implements BSerice{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bid = request.getParameter("bid");
		
		//dao 호출
		BDao dao = new BDao();
		BDto dto = dao.contentView(bid);
		model.addAttribute("content_view",dto);
	}
}
