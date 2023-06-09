package com.lgy.spring_test_member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemLoginService implements MemService{

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String uid = request.getParameter("mem_uid");
		String pwd = request.getParameter("mem_pwd");
		
		MemDao dao = new MemDao();
		int check = dao.userCheck(uid, pwd);
		
		if (check ==1) {
			return 1;
		}else {
			return 0;
		}
	}
}
