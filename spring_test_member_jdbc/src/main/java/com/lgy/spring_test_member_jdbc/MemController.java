package com.lgy.spring_test_member_jdbc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MemController {
	MemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/login_ok")
	public String write(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		service = new MemLoginService();
		int result = service.execute(model);
		log.info("@# login_ok==>" + service.execute(model));
		
		if (result == 1) {			
			return "login_ok";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("register")
	public String register() {
		log.info("@# ==> register");
		return "register";
	}
	
	@RequestMapping("/registerOk")
	public String registerOk(HttpServletRequest request, Model model) {
		log.info("@# ==>registerOk");
		model.addAttribute("request",request);
		
		service = new MWriteService();
		service.execute(model);
		
		return "redirect:login";
	}
}
