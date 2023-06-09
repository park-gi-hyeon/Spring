package com.lgy.spring_mvc_board_jdbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.spring_mvc_board_jdbc.service.BContentService;
import com.lgy.spring_mvc_board_jdbc.service.BDeleteService;
import com.lgy.spring_mvc_board_jdbc.service.BListService;
import com.lgy.spring_mvc_board_jdbc.service.BModifyService;
import com.lgy.spring_mvc_board_jdbc.service.BSerice;
import com.lgy.spring_mvc_board_jdbc.service.BWriteService;
import com.lgy.spring_mvc_board_jdbc.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BController {
	BSerice service;
	public JdbcTemplate template;
	
	
//	servlet-context.xml에 있는 template 객체를 저장(this.template)
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
//		Constant.template 를 dao 에서 사용
		Constant.template = this.template;
	}
	
	//게시판 목록 조회
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list");
		
		service = new BListService();
		service.execute(model);
		
		return "list";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write");
		model.addAttribute("request",request);
		service = new BWriteService();
		service.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view");
		
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		log.info("@# content_view");		
		
		model.addAttribute("request",request);
		service = new BContentService();
		service.execute(model);
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		log.info("@# modify");		
		
		model.addAttribute("request",request);
		service = new BModifyService();
		service.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		log.info("@# modify");		
		
		model.addAttribute("request",request);
		service = new BDeleteService();
		service.execute(model);
		
		return "redirect:list";
	}
}

