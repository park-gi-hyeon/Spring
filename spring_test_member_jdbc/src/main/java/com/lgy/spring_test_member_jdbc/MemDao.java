package com.lgy.spring_test_member_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class MemDao {
	JdbcTemplate template = null;
	
	public MemDao() {
		template = Constant.template;
	}
	
//	로그인 
//	public int userCheck(final String mem_uid, String mem_pwd) {
	public ArrayList<MemDto> userCheck(final String mem_uid, String mem_pwd) {
//		mem_uid varchar2(15) : 작음따옴표가 없어서 sql문에서 오류
//	    String sql = "select mem_pwd FROM mvc_member WHERE mem_uid="+mem_uid;
	    String sql = "select mem_pwd FROM mvc_member WHERE mem_uid='"+mem_uid+"'";
	    return (ArrayList<MemDto>) template.query(sql, new BeanPropertyRowMapper(MemDto.class));
	}
	
	public void write(final String mem_uid,final String mem_pwd, final String mem_name) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into MVC_MEMBER values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mem_uid);
				pstmt.setString(2, mem_pwd);
				pstmt.setString(3, mem_name);
				return pstmt;
			}
		});
	}
}
