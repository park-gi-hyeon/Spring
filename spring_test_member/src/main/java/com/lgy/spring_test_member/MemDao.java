package com.lgy.spring_test_member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemDao {
DataSource dataSource;
	
	public MemDao() {
		try {
			Context context=new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	로그인 
	public int userCheck(String mem_uid, String mem_pwd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int re = -1;
		String db_mem_pwd ="";
		
		
		try {
			conn = dataSource.getConnection();
			String sql = "select mem_pwd from mvc_member where mem_uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_uid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				db_mem_pwd = rs.getString("mem_pwd");
				if (db_mem_pwd.equals(mem_pwd)) {
					re = 1;
				}else {
					re = 0;
				}
			}else {
				re = -1;
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
		return re;
	}
}
