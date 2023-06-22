package com.lgy.spring_tran.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.lgy.spring_tran.dto.TicketDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketDao {
	JdbcTemplate template;
	PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void buyTicket(final TicketDto dto) {
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		try {
//			ī�� ���� ó��
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					log.info("@# ī�� ���� ó��");
					
					String query = "insert into card(consumerId,amount) values(?,?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setInt(2, dto.getAmount());
					return pstmt;
				}
			});
//			Ƽ�� ����
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					log.info("@# ī�� ���� ó��");
					String query = "insert into ticket(consumerId,countnum) values(?,?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setInt(2, dto.getAmount());
					return pstmt;
				}
			});
			
//			���� ������ ī�� ���� ó��, Ƽ�� ���� ���� ó��
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			
//			���� ������ ��� ó��
			transactionManager.rollback(status);
		}
		
	}
}
