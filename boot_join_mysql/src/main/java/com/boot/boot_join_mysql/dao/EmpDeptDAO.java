package com.boot.boot_join_mysql.dao;

import com.boot.boot_join_mysql.dto.EmpDeptDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface EmpDeptDAO {
    public ArrayList<EmpDeptDTO> list();
}
