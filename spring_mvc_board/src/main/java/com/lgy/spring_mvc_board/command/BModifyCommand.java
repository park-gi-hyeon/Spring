package com.lgy.spring_mvc_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.spring_mvc_board.dao.BDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BModifyCommand implements BCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		log.info("@# modify id ===>"+request.getParameter("bid"));
		
		BDao dao = new BDao();
		dao.modify(bid, bname, btitle, bcontent);
	}
	
}
