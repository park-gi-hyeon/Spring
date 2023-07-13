package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.IMemDao;
import com.boot.dto.MemDto;


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








