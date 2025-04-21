package com.boot.boot_board_login_20250421.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.boot.boot_board_login_20250421.dto.BoardDTO;

public interface BoardDAO {
	public ArrayList<BoardDTO> list();
	public void write(HashMap<String, String> param);
	public BoardDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}















