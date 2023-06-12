package com.lgy.spring_test_member_jdbc;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


public class MemLoginService implements MemService{

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String uid = request.getParameter("mem_uid");
		String pwd = request.getParameter("mem_pwd");
		int re;
		
		MemDao dao = new MemDao();
//		int check = dao.userCheck(uid, pwd);
		ArrayList<MemDto> dtos = dao.userCheck(uid, pwd);
		
		if (dtos.isEmpty()) {
			re=-1;
		} else {
			//브라우저에서 받아온 pwd dao단의 dtos를 0번지에서 받아서 비밀번호를가져옴
			if (pwd.equals(dtos.get(0).getMem_pwd())) {
				re = 1;
			} else {
				re = 0;
			}
		}
//		컨트롤러 단에 re 전달(0,1,-1,중에서)
		return re;
	}
}
