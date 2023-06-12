package com.lgy.spring_test_member_mybatis.Dao;

import java.util.ArrayList;

import com.lgy.spring_test_member_mybatis.Dto.MemDto;

public interface IMemDao {
	public ArrayList<MemDto> userCheck( String mem_uid, String mem_pwd); 
	
	public void register( String mem_uid, String mem_pwd,  String mem_name);
}
