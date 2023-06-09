package com.lgy.spring_ex6_1;

import java.util.ArrayList;

public class Employee {
	private String name;
	private String sal;
	private ArrayList<String> Certificate;
	
	public Employee(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public ArrayList<String> getCertificate() {
		return Certificate;
	}
	public void setCertificate(ArrayList<String> certificate) {
		Certificate = certificate;
	}
}
