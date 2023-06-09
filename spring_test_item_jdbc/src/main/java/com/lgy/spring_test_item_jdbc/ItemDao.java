package com.lgy.spring_test_item_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;




public class ItemDao {
JdbcTemplate template = null;
	
	public ItemDao() {
		template = Constant.template;
	}
	
//	게시판에 글 작성
	public void write(final String name,final int price,final String description) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into test_item(name, price, description) "
						+ "values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, price);
				pstmt.setString(3, description);
				return pstmt;
			}
		});
	}
	
	public ArrayList<ItemDto> list(){
		ArrayList<ItemDto> dtos=new ArrayList<ItemDto>();
		String sql="select name,price,description from test_item";
		dtos = (ArrayList<ItemDto>) template.query(sql, new BeanPropertyRowMapper(ItemDto.class));
		return dtos;
		
	}
}
