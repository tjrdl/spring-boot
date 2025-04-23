package com.boot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dto.BoardDTO;

@Mapper
public interface BoardDAO {
	public ArrayList<BoardDTO> list();

	public void write(HashMap<String, String> param);

	public BoardDTO contentView(HashMap<String, String> param);

	public void modify(HashMap<String, String> param);

	public void delete(HashMap<String, String> param);
}