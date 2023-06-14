package com.lgy.spring_test_member_std.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.spring_test_member_std.dto.*;

public interface IMemDao {
	public ArrayList<MemDto> loginYn(HashMap<String, String> param);
	public void write(HashMap<String, String> param);
}
