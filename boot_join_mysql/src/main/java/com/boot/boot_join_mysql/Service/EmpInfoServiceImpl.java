package com.boot.boot_join_mysql.Service;

import com.boot.boot_join_mysql.dao.EmpDeptDAO;
import com.boot.boot_join_mysql.dto.EmpDeptDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("empinfoService")
public class EmpInfoServiceImpl implements EmpInfoService {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public ArrayList<EmpDeptDTO> list() {
        EmpDeptDAO dao = sqlSession.getMapper(EmpDeptDAO.class);
        ArrayList<EmpDeptDTO> list = dao.list();
        return list;
    }


}




