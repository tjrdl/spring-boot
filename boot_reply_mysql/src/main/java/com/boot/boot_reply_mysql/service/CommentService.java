package com.boot.boot_reply_mysql.service;

import com.boot.boot_reply_mysql.dto.BoardDTO;
import com.boot.boot_reply_mysql.dto.CommentDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface CommentService {
	public ArrayList<CommentDTO> findAll(HashMap<String, String> param);
	public void save(HashMap<String, String> param);

}
