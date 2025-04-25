package com.boot.controller;

import com.boot.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.dto.Criteria;
import com.boot.dto.PageDTO;
import com.boot.service.PageService;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Controller
@Slf4j
public class PageController {
	@Autowired
	private PageService service;
	
	@RequestMapping("/list")
	public String list(Criteria cri, Model model) {
		log.info("@# list()");
		log.info("@# cri"+cri);
		
//		model.addAttribute("list", service.listWithPaging(cri));
		ArrayList<BoardDTO> list = service.listWithPaging(cri);
		int total = service.getTotalCount();
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageDTO(total, cri));
		
		return "list";
	}
	
}







