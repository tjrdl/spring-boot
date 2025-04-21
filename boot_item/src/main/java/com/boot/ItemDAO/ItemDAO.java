package com.boot.ItemDAO;

import com.boot.ItemDTO.ItemDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ItemDAO {
    public void write(HashMap<String, String> param);
    public ArrayList<ItemDTO> list();
}
