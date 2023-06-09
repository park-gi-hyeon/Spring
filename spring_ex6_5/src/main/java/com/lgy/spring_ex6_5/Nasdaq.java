package com.lgy.spring_ex6_5;

import java.util.ArrayList;

public class Nasdaq {
	private String stock,capRank;
	private ArrayList<String> product;
	
	public Nasdaq(String stock) {
		this.stock = stock;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getCapRank() {
		return capRank;
	}
	public void setCapRank(String capRank) {
		this.capRank = capRank;
	}
	public ArrayList<String> getProduct() {
		return product;
	}
	public void setProduct(ArrayList<String> product) {
		this.product = product;
	}
}
