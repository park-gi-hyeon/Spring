package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.boot.dto.MemDto;


public interface MemService {
	public ArrayList<MemDto> loginYn(HashMap<String, String> param);
	public void write(HashMap<String, String> param);
}
