package com.boot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dto.MemDto;


@Mapper
public interface IMemDao {
	public ArrayList<MemDto> loginYn(HashMap<String, String> param);
	public void write(HashMap<String, String> param);
}
