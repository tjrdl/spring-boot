package com.boot.boot_reply_mysql.dao;

import com.boot.boot_reply_mysql.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

//실행시 매퍼파일을 읽어 들이도록 지정
@Mapper
public interface CommentDAO {
	public ArrayList<CommentDTO> findAll(HashMap<String, String> param);
	public void save(HashMap<String, String> param);
}















