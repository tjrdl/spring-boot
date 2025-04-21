package com.boot.boot_board_login_20250421.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.boot.boot_board_login_20250421.dto.BoardDTO;

public interface BoardService {
	public ArrayList<BoardDTO> list();
//	public void write(String boardName, String boardTitle, String boardContent);
	public void write(HashMap<String, String> param);
//	public BoardDTO contentView(String strID);
	public BoardDTO contentView(HashMap<String, String> param);
//	public void modify(String boardNo, String boardName, String boardTitle, String boardContent);
	public void modify(HashMap<String, String> param);
//	public void delete(String strID);
	public void delete(HashMap<String, String> param);
}
