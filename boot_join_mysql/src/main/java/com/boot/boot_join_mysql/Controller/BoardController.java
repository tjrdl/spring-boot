package com.boot.boot_join_mysql.Controller;

import com.boot.boot_join_mysql.Service.EmpInfoService;
import com.boot.boot_join_mysql.dto.EmpDeptDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private EmpInfoService service;
	
	@RequestMapping("/list")
//	public String list(Model model) {
	public String list(Model model) {
		log.info("@# list()");

		ArrayList<EmpDeptDTO> list = service.list();
		model.addAttribute("list", list);

		return "list";
	}

}







