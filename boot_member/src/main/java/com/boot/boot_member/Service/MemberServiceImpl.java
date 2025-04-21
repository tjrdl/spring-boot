package com.boot.boot_member.Service;

import com.boot.boot_member.dao.MemDAO;
import com.boot.boot_member.dto.MemDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void write(HashMap<String, String> param) {
        MemDAO dao=sqlSession.getMapper(MemDAO.class);
        dao.write(param);
    }

    @Override
    public ArrayList<MemDTO> list() {
        MemDAO dao = sqlSession.getMapper(MemDAO.class);
        ArrayList<MemDTO> list = dao.list();
        return list;
    }
}
