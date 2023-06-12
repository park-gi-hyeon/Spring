package com.lgy.spring_test_member_mybatis.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.spring_test_member_mybatis.Dao.IMemDao;
import com.lgy.spring_test_member_mybatis.Dto.MemDto;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MemController {
	
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/login_ok")
	public String userCheck(HttpServletRequest request, Model model) {
		
//		model.addAttribute("request",request);
//		service = new MemLoginService();
//		int result = service.execute(model);
		log.info("@# userCheck");
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		
		ArrayList<MemDto> result = dao.userCheck(request.getParameter("mem_uid")
				, request.getParameter("mem_uid"));
		
		
		if (!result.isEmpty()) {			
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
		log.info("@# request"+request.getParameter("mem_name"));
		
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		dao.register(request.getParameter("mem_uid")
				, request.getParameter("mem_pwd")
				, request.getParameter("mem_name"));
		
		return "redirect:login";
	}
}
