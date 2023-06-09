package com.lgy.spring_mvc_board_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lgy.spring_mvc_board_jdbc.dto.BDto;
import com.lgy.spring_mvc_board_jdbc.util.Constant;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class BDao {
//	DataSource dataSource;
	JdbcTemplate template = null;
	
	public BDao() {
//		try {
//			Context context=new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Constant.template :컨트롤러에서 설정됨
		template = Constant.template;
	}
	
	//게시판 목록 조회
	public ArrayList<BDto> list(){
//		1.방법 4줄
//		ArrayList<BDto> dtos= null;
//		String sql="select bid,bname, btitle,bcontent, bdate, bhit from mvc_board";
////		query : jdbc template 쿼리 처리
//		dtos = (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper(BDto.class));
//		return dtos;
		
//		2.방법 2줄
//		String sql="select bid,bname, btitle,bcontent, bdate, bhit from mvc_board";
//		return (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper(BDto.class));
		
//		3. 방법 1줄
		return (ArrayList<BDto>) template.query("select bid,bname, btitle,bcontent, bdate, bhit from mvc_board"
				, new BeanPropertyRowMapper(BDto.class));

	}
	
//	게시판에 글 작성
	public void write(final String bname,final String btitle,final String bcontent) {
//		update : jsbc template으로 inset (PreparedStatementCreator 객체 사용)
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into mvc_board(bid, bname, btitle, bcontent, bhit) "
						+ "values(MVC_BOARD_SEQ.NEXTVAL,?,?,?,0)";
//				con : 메소드 매개변수와 이름 일치
				PreparedStatement pstmt = con.prepareStatement(sql);
//				bname 파라미터 등은 final로 구성
				pstmt.setString(1, bname);//매개변수를 final로 바꿔야한다. 값을 못바꾸게
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);
				return pstmt;
			}
		});
	}
	
	public BDto contentView(String strID) {
		upHit(strID);
		String sql="select bid, bname, btitle, bcontent, bdate, bhit "
				+ "from mvc_board where bid="+strID;
//		dtos = (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper(BDto.class));
//		queryForObject : jdbc template 조회처리
		return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	
	//게시글 조회수 올리기
	private void upHit(final String bid) {
		String sql="update mvc_board set bhit = bhit+1 where bid=?";
//		update : sql update(PreparedStatementSetter 객체 사용)
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,Integer.parseInt(bid));
			}
		});
	}
	
	//글 수정하기
	public void modify(final String bid, final String bname, final String btitle,final String bcontent) {
		String sql="update mvc_board set bname =?, btitle = ?,bcontent =? where bid=?";
		template.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,bname);
				ps.setString(2,btitle);
				ps.setString(3,bcontent);
				ps.setInt(4,Integer.parseInt(bid));
			}
		});
	}
	
	public void delete(final String strID) {
		String sql="delete from mvc_board where bid=?";
//		update : jdbc template 삭제 처리
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			ps.setInt(1,Integer.parseInt(strID));				
			}
		});
		
	}
}














