package com.lgy.spring_tran.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDto {
	private String consumerId;
//	amount 갯수로 대체
//	private int countnum;
	private int amount;
}
