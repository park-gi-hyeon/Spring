package com.lgy.spring_6_1;

public class StudentInfo {
	private Student student;
	
//	set치면 자동완성으로 빨리하는 방법이 있음 set치고 student클릭하면 됨
	public void setStudent(Student student) {
		this.student = student;
	}
	public Student getStudent() {
		return student;
	}
}
