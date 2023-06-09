package com.lgy.spring_test_item;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	ItemService service;
	
	@RequestMapping("/writeResult")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write");
		model.addAttribute("request",request);
		service = new ItemWriteService();
		service.execute(model);
		log.info("@# ===>"+ request.getParameter("name"));
		
		return "writeResult";
	}
	@RequestMapping("/content_view")
	public String list(Model model) {
		
		service = new ItemContentService();
		service.execute(model);
		return "content_view";
	}
}
