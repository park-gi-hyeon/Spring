package com.lgy.spring_mvc_board_std.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Criteria {
	private int pageNum;//������ ��ȣ
	private int amount;//�������� �� ����
	
	public Criteria() {
//		�ʱ� �������� 1�̰�, 10���� ���
		this(1, 10);//1~10
//		2:11~,3:21~,4:31~
//		this(5, 10);//41~50
	}
}
