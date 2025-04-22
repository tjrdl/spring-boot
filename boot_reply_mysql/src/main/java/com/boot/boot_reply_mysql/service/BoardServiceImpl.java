package com.boot.boot_reply_mysql.service;

import com.boot.boot_reply_mysql.dao.BoardDAO;
import com.boot.boot_reply_mysql.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("BoardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<BoardDTO> list() {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		ArrayList<BoardDTO> list = dao.list();
		return list;
	}

	@Override
	public void write(HashMap<String, String> param) {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		dao.write(param);
	}
	
	@Override
	public BoardDTO contentView(HashMap<String, String> param) {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		BoardDTO dto = dao.contentView(param);
		
		return dto;
	}

	@Override
	public void modify(HashMap<String, String> param) {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		dao.modify(param);
	}

	@Override
	public void delete(HashMap<String, String> param) {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		dao.delete(param);
	}

}




