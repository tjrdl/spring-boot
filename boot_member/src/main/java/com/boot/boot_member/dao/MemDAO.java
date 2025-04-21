package com.boot.boot_member.dao;

import org.apache.ibatis.annotations.Mapper;
import com.boot.boot_member.dto.MemDTO;
import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface MemDAO {
    void write(HashMap<String, String> param);
    ArrayList<MemDTO> list();
}