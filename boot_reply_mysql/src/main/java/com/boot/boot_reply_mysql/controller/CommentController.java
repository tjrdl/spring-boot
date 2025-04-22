package com.boot.boot_reply_mysql.controller;

import com.boot.boot_reply_mysql.dto.BoardDTO;
import com.boot.boot_reply_mysql.dto.CommentDTO;
import com.boot.boot_reply_mysql.service.BoardService;
import com.boot.boot_reply_mysql.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService service;

	@RequestMapping("/save")
	public String save(@RequestParam HashMap<String, String> param) {
		log.info("@# write()");
		
		service.save(param);
		
		// 해당 게시글에 작성된 댓글 리스트를 가져옴
		ArrayList<CommentDTO> commentList = service.findAll(param);
		
		return null;
	}

}







