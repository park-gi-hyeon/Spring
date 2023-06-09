package com.lgy.spring_test_member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MemController {
	MemService service;
	
	@RequestMapping("/login_ok")
	public String write(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		service = new MemLoginService();
		int result = service.execute(model);
		log.info("@# ==>" + service.execute(model));
		
		if (result == 1) {			
			return "login_ok";
		} else {
			return "redirect:login";
		}
	}
}
