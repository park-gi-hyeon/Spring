package com.lgy.spring_test_item_mybatis.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.spring_test_item_mybatis.ItemDao.ItemDao;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class ItemController {
	@Autowired
	private SqlSession sqlsession;
	
	
	@RequestMapping("/writeResult")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# ==>write");
		ItemDao dao = sqlsession.getMapper(ItemDao.class);
		dao.write(request.getParameter("name")
				,(request.getParameter("price")) 
				, request.getParameter("description"));
		log.info("@# request ==>"+request.getParameter("name"));
		return "writeResult";
	}
	@RequestMapping("/content_view")
	public String list(Model model) {
		
		ItemDao dao = sqlsession.getMapper(ItemDao.class);
		model.addAttribute("list",dao.list());
		
		return "content_view";
	}
}
