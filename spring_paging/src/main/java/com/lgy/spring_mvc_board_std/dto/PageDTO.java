package com.lgy.spring_mvc_board_std.dto;

import lombok.Getter;

@Getter
public class PageDTO {
	//��������ȣ�� 10���� ���̰�(1~10,11~20)
	private int startPage;//����������:1,11
	private int EndPage;//�� ������ 10,20
	private boolean prev,next;//������ ����
	private int total;
	private Criteria cri;//ȭ�鿡 ��� ����
	
	public PageDTO(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
//		Math.ceil() : �ø�
//		ex> 3������ = 3/10 -> 0.3 -> 1* 10 = 10(��������)
//		ex> 11������ = 11/10 -> 1.1 -> 2* 10 = 20(��������)
		this.EndPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		
//		ex>10-9=1������
//		ex>20-9=11������
		this.startPage = this.EndPage - 9;
		
//		ex>total:70, ���� ������ 3 -> endPage:10 => 70 * 1.0 / 10 = 7������
//		ex>total:300, ���� ������ 3 -> endPage:10 => 300 * 1.0 / 10 = 30������
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
//		ex>7������ <= 10������ : endPage : 7������
//		ex>30������ <= 10������ : endPage : 10������
		if(realEnd <=this.EndPage) {
			this.EndPage = realEnd;
		}
		
//		1���������� ũ�� ���� => ���̰� �ƴ� �������� ����
		this.prev = this.startPage > 1;
		
//		ex>10������ < 30������
		this.next = this.EndPage < realEnd;
	}
}
