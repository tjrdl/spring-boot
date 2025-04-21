package com.boot.boot_board_login_20250421.Service;

import com.boot.boot_board_login_20250421.dto.*;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemService {
	public ArrayList<MemDTO> loginYn(HashMap<String, String> param);
	public void write(HashMap<String, String> param);
}
