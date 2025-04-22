package com.boot.boot_reply_mysql.dao;

import com.boot.boot_reply_mysql.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

//실행시 매퍼파일을 읽어 들이도록 지정
@Mapper
public interface BoardDAO {
	public ArrayList<BoardDTO> list();
	public void write(HashMap<String, String> param);
	public BoardDTO contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}















