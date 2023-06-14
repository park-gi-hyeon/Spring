package com.lgy.spring_mvc_board_std.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//jdbc template 에서 dto 에 기본생성자 필요
@NoArgsConstructor
public class BDto {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private int bhit;
}
