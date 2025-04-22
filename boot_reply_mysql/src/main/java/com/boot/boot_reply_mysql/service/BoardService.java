package com.boot.boot_reply_mysql.service;

import com.boot.boot_reply_mysql.dto.BoardDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardService {
	public ArrayList<BoardDTO> list();
	public void write(HashMap<String, String> param);
	public BoardDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}
