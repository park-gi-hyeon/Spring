package com.lgy.spring_test_member_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.spring_test_member_std.dto.MemDto;

public interface MemService {
	public ArrayList<MemDto> loginYn(HashMap<String, String> param);
	public void write(HashMap<String, String> param);
}
