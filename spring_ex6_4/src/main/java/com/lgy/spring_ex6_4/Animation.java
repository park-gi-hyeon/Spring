package com.lgy.spring_ex6_4;

import java.util.ArrayList;

public class Animation {
	private String Title,Year;
	private ArrayList<String> character;
	
	
	public Animation(String title) {
		Title = title;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public ArrayList<String> getCharacter() {
		return character;
	}
	public void setCharacter(ArrayList<String> character) {
		this.character = character;
	}
}
