package com.lgy.spring_test_item_jdbc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ItemController {
	ItemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/writeResult")
	public String write(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		service = new ItemWriteService();
		service.execute(model);
		
		return "writeResult";
	}
	@RequestMapping("/content_view")
	public String list(Model model) {
		
		service = new ItemContentService();
		service.execute(model);
		return "content_view";
	}
}
