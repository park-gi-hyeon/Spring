package com.lgy.spring_15.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@Data
//@NoArgsConstructor
public class SampleVO {
	private int nmo;
	private String firstName;
	private String lastName;
	
	/*
	public SampleVO(int nmo, String firstName, String lastName) {
		this.nmo = nmo;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getNmo() {
		return nmo;
	}

	public void setNmo(int nmo) {
		this.nmo = nmo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	*/
	
}
