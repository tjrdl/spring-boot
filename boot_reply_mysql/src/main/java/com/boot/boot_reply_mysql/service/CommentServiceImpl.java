package com.boot.boot_reply_mysql.service;

import com.boot.boot_reply_mysql.dao.CommentDAO;
import com.boot.boot_reply_mysql.dto.CommentDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private SqlSession sqlSession;


	@Override
	public ArrayList<CommentDTO> findAll(HashMap<String, String> param) {
		CommentDAO dao=sqlSession.getMapper(CommentDAO.class);
		ArrayList<CommentDTO> list = dao.findAll(param);
		return list;
	}

	@Override
	public void save(HashMap<String, String> param) {
		CommentDAO dao=sqlSession.getMapper(CommentDAO.class);
		dao.save(param);
	}
}




