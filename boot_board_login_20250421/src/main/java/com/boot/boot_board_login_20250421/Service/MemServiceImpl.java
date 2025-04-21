package com.boot.boot_board_login_20250421.Service;

import com.boot.boot_board_login_20250421.dao.MemDAO;
import com.boot.boot_board_login_20250421.dto.MemDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("MemService")
public class MemServiceImpl implements MemService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<MemDTO> loginYn(HashMap<String, String> param) {
		MemDAO dao=sqlSession.getMapper(MemDAO.class);
		ArrayList<MemDTO> list = dao.loginYn(param);
		
		return list;
	}

	@Override
	public void write(HashMap<String, String> param) {
		MemDAO dao=sqlSession.getMapper(MemDAO.class);
		dao.write(param);
	}

}











