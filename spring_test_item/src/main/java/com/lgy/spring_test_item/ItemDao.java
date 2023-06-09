package com.lgy.spring_test_item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class ItemDao {
DataSource dataSource;
	
	public ItemDao() {
		try {
			Context context=new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	게시판에 글 작성
	public void write(String name,int price,String description) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn = dataSource.getConnection();
			String sql="insert into test_item(name, price, description) "
					+ "values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, description);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<ItemDto> list(){
//		dtos : 게시글들을 담는 객체
		ArrayList<ItemDto> dtos=new ArrayList<ItemDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn = dataSource.getConnection();
			String sql="select name,price,description from test_item";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				
//				하나의 게시글 객체
				ItemDto dto = new ItemDto(name,price,description);
//				게시글을 추가(dtos : 여러 게시글이 될수 있음)
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
}
