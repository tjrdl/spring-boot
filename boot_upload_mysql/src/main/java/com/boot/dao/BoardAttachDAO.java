package com.boot.dao;

import com.boot.dto.BoardDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardAttachDAO {
	public ArrayList<BoardDTO> list();
	public void write(BoardDTO boardDTO);
	public BoardDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}















