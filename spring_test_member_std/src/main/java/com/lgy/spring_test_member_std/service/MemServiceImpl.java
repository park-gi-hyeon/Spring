package com.lgy.spring_test_member_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgy.spring_test_member_std.dao.*;
import com.lgy.spring_test_member_std.dto.MemDto;

@Service
public class MemServiceImpl implements MemService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<MemDto> loginYn(HashMap<String, String> param) {
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		ArrayList<MemDto> dtos = dao.loginYn(param);
		
		return dtos;
	}

	@Override
	public void write(HashMap<String, String> param) {
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		dao.write(param);
	}

}








