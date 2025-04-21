package com.boot.boot_board_login_20250421.dao;

import com.boot.boot_board_login_20250421.dto.*;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemDAO {
	public ArrayList<MemDTO> loginYn(HashMap<String, String> param);
	public void write(HashMap<String, String> param);
}







