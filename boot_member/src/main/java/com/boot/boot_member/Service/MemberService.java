package com.boot.boot_member.Service;

import com.boot.boot_member.dto.MemDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberService {
    public void write(HashMap<String, String> param);
    public ArrayList<MemDTO> list();
}
